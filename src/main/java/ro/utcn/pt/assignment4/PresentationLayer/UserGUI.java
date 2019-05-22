package ro.utcn.pt.assignment4.PresentationLayer;

import ro.utcn.pt.assignment4.BusinessLayer.UserOp;
import ro.utcn.pt.assignment4.Model.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserGUI extends JFrame implements Subject{
    private JPanel mainPanel;
    private JButton newOrderButton;
    private JButton viewAllOrdersButton;
    private JTable resultsTable;
    private JSplitPane splitpane;
    private JButton deleteOrderButton;
    private JButton deleteAllButton;

    ChefWindow chef = new ChefWindow();

    ArrayList<Order> orders = new ArrayList<>();

    public UserGUI(){

        setTitle("Waiter");
        setContentPane(mainPanel);
        pack();
        setSize(1400, 1000);
        getRootPane().setDefaultButton(viewAllOrdersButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(10, 10);

        final UserOp userOp = new UserOp();

        try {
            orders = userOp.getAllOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        notifyChef();


        Font font = new Font("", 1, 15);
        Font font1 = new Font("", Font.BOLD, 15);

        newOrderButton.setFont(font);
        newOrderButton.setBackground(Color.orange);
        newOrderButton.setForeground(Color.black);

        viewAllOrdersButton.setFont(font);
        viewAllOrdersButton.setBackground(Color.GRAY);
        viewAllOrdersButton.setForeground(Color.white);

        deleteOrderButton.setFont(font);
        deleteOrderButton.setBackground(Color.red);
        deleteOrderButton.setForeground(Color.white);

        splitpane.setDividerLocation(450);

        final Object[] columns = {"ID", "Dish_id", "Dish Name", "Dish Quantity", "Subtotal", "Table"};

        final DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);
        final Object[] row = new Object[6];

        resultsTable.setModel(tableModel);
        resultsTable.setRowHeight(30);
        resultsTable.setBackground(Color.cyan);
        resultsTable.setForeground(Color.black);
        resultsTable.setFont(font);

        JTableHeader header = resultsTable.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.white);
        header.setFont(font1);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        resultsTable.setDefaultRenderer(Object.class, centerRenderer);


        newOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateOrderGUI createOrderGUI = new CreateOrderGUI(chef);
                setVisible(false);
                createOrderGUI.setVisible(true);
            }
        });



        deleteAllButton.setBackground(Color.black);
        deleteAllButton.setForeground(Color.white);
        deleteOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the id of the order you want to delete!!!"));

                    if(userOp.existsOrder(id)){
                        userOp.deleteOrder(id);
                        JOptionPane.showMessageDialog(null, "Order deleted!");
                        orders = userOp.getAllOrders();
                        notifyChef();
                    }else
                        JOptionPane.showMessageDialog(null, "The order doesn't exist!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        viewAllOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ArrayList<Order> orders = userOp.getAllOrders();
                    tableModel.setRowCount(0);

                    for(int i=0; i<orders.size(); i++){
                        row[0] = orders.get(i).getOrder_id();
                        row[1] = orders.get(i).getDish_id();
                        row[2] = orders.get(i).getDish_name();
                        row[3] = orders.get(i).getQuantity();
                        row[4] = orders.get(i).getTotalSum();
                        row[5] = orders.get(i).getTable();

                        tableModel.addRow(row);

                    }
                    resultsTable.setModel(tableModel);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        deleteAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yes = JOptionPane.showConfirmDialog(null, "Are you sure?");

                if(yes==0){
                    try {
                        userOp.deleteAll();
                        notifyChef();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });


    }



    @Override
    public void notifyChef() {
        UserOp userOp = new UserOp();
        try {
            orders = userOp.getAllOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        chef.update(orders);
    }
}
