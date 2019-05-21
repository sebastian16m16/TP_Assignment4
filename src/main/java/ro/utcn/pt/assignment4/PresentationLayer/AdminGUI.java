package ro.utcn.pt.assignment4.PresentationLayer;

import ro.utcn.pt.assignment4.BusinessLayer.AdminOp;
import ro.utcn.pt.assignment4.Model.Dish;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminGUI extends JFrame {
    private JTable resultsTable;
    private JButton viewMenuButton;
    private JButton addDishButton;
    private JButton editDishButton;
    private JButton deleteDishButton;
    private JPanel mainPanel;

    AdminOp adminOp = new AdminOp();

    public AdminGUI(){

        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setTitle("Admin");
        getRootPane().setDefaultButton(viewMenuButton);




        Object[] columns = {"Dish ID", "Dish NAME", "Dish PRICE", "Quantity [g]"};
        final DefaultTableModel tableModel = new DefaultTableModel();

        final Font font = new Font("", 1, 20);
        final Font font1 = new Font("", Font.BOLD, 15);

        tableModel.setColumnIdentifiers(columns);
        resultsTable.setModel(tableModel);
        resultsTable.setRowHeight(30);
        resultsTable.setBackground(Color.cyan);
        resultsTable.setForeground(Color.black);
        resultsTable.setFont(font);

        JTableHeader header = resultsTable.getTableHeader();
        header.setBackground(Color.red);
        header.setForeground(Color.white);
        header.setFont(font1);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        resultsTable.setDefaultRenderer(Object.class, centerRenderer);

        viewMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] row = new Object[4];
                tableModel.setRowCount(0);

                try {
                    ArrayList<Dish> menu = adminOp.getMenu();

                    for(int i=0; i<menu.size(); i++){
                        row[0] = menu.get(i).getDish_id();
                        row[1] = menu.get(i).getDish_name();
                        row[2] = menu.get(i).getDish_price();
                        row[3] = menu.get(i).getQuantity();
                        tableModel.addRow(row);
                    }
                    resultsTable.setModel(tableModel);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        addDishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dish_name = JOptionPane.showInputDialog(null, "Insert the Dish Name:");

                try {
                    if (!dish_name.equals("")){
                        if(!adminOp.existsDish(dish_name)){
                            String dish_price = JOptionPane.showInputDialog(null, "Insert the price:");
                            if(!dish_price.equals("")){
                                String quantity =JOptionPane.showInputDialog(null, "Enter quantity!");

                                if(!quantity.equals("")){
                                    adminOp.insertDish(dish_name, Double.parseDouble(dish_price), Integer.parseInt(quantity));
                                    JOptionPane.showMessageDialog(null, "Dish added to the Menu!");
                                }
                            }
                        }else
                            JOptionPane.showMessageDialog(null, "This dish already exists!");
                    }else
                        JOptionPane.showMessageDialog(null, "Invalid NAME!");

                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        });

        deleteDishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dish_name = JOptionPane.showInputDialog(null, "Enter the name of the Dish you want to delete!");
                if(dish_name != null){
                    try {
                        adminOp.deleteDish(dish_name);
                        JOptionPane.showMessageDialog(null, "Dish deleted successfully!");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        editDishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object response = JOptionPane.showInputDialog(null, "What do you want to edit?",
                        "Edit choice", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Name", "Price", "Quantity", "All"}, "Name");
                try {
                     if(response.equals("Name")){
                         String dish_name = JOptionPane.showInputDialog(null, "Enter the dish you want to edit!");

                             if(adminOp.existsDish(dish_name)) {
                                 String new_name = JOptionPane.showInputDialog(null, "Enter the new name");

                                 if (!new_name.equals("")) {
                                     adminOp.editDishName(dish_name, new_name);
                                     JOptionPane.showMessageDialog(null, "Name edited successfully!");
                                 }else
                                     JOptionPane.showMessageDialog(null, "Invalid Name");

                             }else
                                 JOptionPane.showMessageDialog(null, "NO SUCH DISH!");

                     }else if(response.equals("Price")){
                         String dish_name = JOptionPane.showInputDialog(null, "Enter the dish you want to edit!");

                         if (adminOp.existsDish(dish_name)) {
                            String newPrice = JOptionPane.showInputDialog(null, "Enter the new Price");
                            if(!newPrice.equals("")){
                                adminOp.editDishPrice(dish_name, Double.parseDouble(newPrice));
                            }else
                                JOptionPane.showMessageDialog(null, "Invalid price!");
                         }else
                             JOptionPane.showMessageDialog(null, "NO SUCH DISH!");

                     }else if(response.equals("Quantity")){
                         String dish_name = JOptionPane.showInputDialog(null, "Enter the dish you want to edit!");

                         if (adminOp.existsDish(dish_name)) {
                             String quantity = JOptionPane.showInputDialog(null, "Enter the new Quantity!");

                             if(!quantity.equals("")){
                                 if(Integer.parseInt(quantity) > 50)
                                     adminOp.editDishQuantity(dish_name, Integer.parseInt(quantity));
                                 else
                                     JOptionPane.showMessageDialog(null, "Invalid quantity");
                             }else
                                 JOptionPane.showMessageDialog(null, "Invalid quantity");
                         }else
                             JOptionPane.showMessageDialog(null, "NO SUCH DISH!");
                     }else if(response.equals("All")){
                         String dish_name = JOptionPane.showInputDialog(null, "Enter the dish you want to edit!");
                         if (adminOp.existsDish(dish_name)) {
                             String new_name = JOptionPane.showInputDialog(null, "Enter the new name");
                             String newPrice = JOptionPane.showInputDialog(null, "Enter the new Price");
                             String quantity = JOptionPane.showInputDialog(null, "Enter the new Quantity!");


                             if (!new_name.equals("")) {
                                 adminOp.editDishName(dish_name, new_name);
                                 JOptionPane.showMessageDialog(null, "Name edited successfully!");
                             }else
                                 JOptionPane.showMessageDialog(null, "Invalid Name");

                             if(!newPrice.equals("")){
                                 adminOp.editDishPrice(dish_name, Double.parseDouble(newPrice));
                             }else
                                 JOptionPane.showMessageDialog(null, "Invalid price!");

                             if(!quantity.equals("")){
                                 if(Integer.parseInt(quantity) > 50)
                                    adminOp.editDishQuantity(dish_name, Integer.parseInt(quantity));
                                 else
                                     JOptionPane.showMessageDialog(null, "Invalid quantity");
                             }else
                                 JOptionPane.showMessageDialog(null, "Invalid quantity");

                         }else
                             JOptionPane.showMessageDialog(null, "NO SUCH DISH!");
                     }
                 } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
