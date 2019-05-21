package ro.utcn.pt.assignment4.PresentationLayer;

import ro.utcn.pt.assignment4.BusinessLayer.UserOp;
import ro.utcn.pt.assignment4.Model.Dish;
import ro.utcn.pt.assignment4.Model.Order;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CreateOrderGUI extends JFrame implements Subject {
    private JList menuList;
    private JList orderList;
    private JButton sumbitOrderButton;
    private JPanel mainPanel;
    private JButton backButton;
    private JLabel totalSumLabel;
    private JTextField tableField;

    String p = "(.+?)\\sx(\\d+)";
    Pattern pattern = Pattern.compile(p);
    DefaultListModel<String> orderModel = new DefaultListModel<>();
    ArrayList<Order> newOrder = new ArrayList<>();

    ChefWindow chef;


    public CreateOrderGUI(ChefWindow chef){
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("New Order");
        add(mainPanel);

        this.chef = chef;

        final UserOp userOp = new UserOp();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserGUI userGUI = new UserGUI();
                userGUI.setVisible(true);
                setVisible(false);
            }
        });

        ArrayList<Dish> menu = null;
        try {
            menu = userOp.getMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DefaultListModel<String> menuModel = new DefaultListModel<>();
        totalSumLabel.setText("0");

        for(int i = 0; i<menu.size(); i++){
            menuModel.addElement(menu.get(i).getDish_name());
        }
        menuList.setModel(menuModel);

        menuList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Dish selectedDish = userOp.getDish(menuList.getSelectedValue().toString());
                    boolean found = false;
                        for(int i=0; i < orderModel.size(); i++){

                            Matcher m = pattern.matcher(orderModel.get(i));
                            m.find();
                            //check groups
                            String group1 = m.group(1);
                            String group2 = m.group(2);

                            if(m.group(1).equals(selectedDish.getDish_name())){
                                orderModel.set(i,selectedDish.getDish_name() + " x" + (Integer.parseInt(m.group(2)) + 1));
                                //set price
                                double totalSum = Double.parseDouble(totalSumLabel.getText()) + selectedDish.getDish_price();
                                totalSumLabel.setText( totalSum + "");
                                orderList.setModel(orderModel);
                                found = true;
                            }

                        }
                        if(found == false){
                            orderModel.addElement(selectedDish.getDish_name() + " x" + 1);
                            double totalSum = Double.parseDouble(totalSumLabel.getText()) + selectedDish.getDish_price();
                            totalSumLabel.setText( totalSum + "");
                            orderList.setModel(orderModel);
                        }
                        menuList.clearSelection();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        sumbitOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> orders = new ArrayList<>();

                try {
                    for(int i = 0; i<orderModel.size(); i++){
                        Matcher m = pattern.matcher(orderModel.get(i));
                        m.find();
                        orders.add(orderModel.get(i));
                        Dish dish = userOp.getDish(m.group(1));
                        int quantity = Integer.parseInt(m.group(2));
                        Order order = new Order(dish.getDish_id(), dish.getDish_name(), quantity, dish.getDish_price() * quantity, Integer.parseInt(tableField.getText()));

                        userOp.addOrder(order);

                    }
                    newOrder = userOp.getAllOrders();
                    notifyChef();
                    orderModel.clear();
                    int table = Integer.parseInt(tableField.getText());
                    double totalSum = Double.parseDouble(totalSumLabel.getText());
                    createBill(orders, totalSum, table);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void createBill(ArrayList<String> order, double totalSum, int table){
        int nr = 1;
        UserOp userOp = new UserOp();
        File file = new File("C:\\Learning\\Java\\TehniciProgramare\\PT2019_32711_Muresan_Sebastian_Assignment4\\bills\\BILL " + nr + ".txt");

        while(file.exists()){
            nr++;
            file = new File("C:\\Learning\\Java\\TehniciProgramare\\PT2019_32711_Muresan_Sebastian_Assignment4\\bills\\BILL #" + nr + ".txt");
        }
        try {
            try {
                PrintWriter printWriter = new PrintWriter(file);
                for (int i = 0; i < order.size(); i++) {
                    Matcher m = pattern.matcher(order.get(i));
                    m.find();
                    Dish dish = userOp.getDish(m.group(1));
                    int quantity = (Integer.parseInt(m.group(2)));

                    printWriter.println("Product: " + dish.getDish_name() + "  ..........  Price: " + dish.getDish_price() + " --- x" + quantity +
                            ("  " + dish.getDish_price() * quantity));
                    printWriter.println("\n---------------");
                    printWriter.println();
                    printWriter.println("\n-------TABLE " + table +"--------");

                }
                printWriter.println("Total Sum = " + totalSum + " RON");
                printWriter.println("..................");
                printWriter.close();

            }catch(SQLException ex){
                ex.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void notifyChef() {
        chef.update(newOrder);
    }
}
