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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setTitle("Admin");
        getRootPane().setDefaultButton(viewMenuButton);

        add(mainPanel);

        Object[] columns = {"Dish ID", "Dish NAME", "Dish PRICE"};
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
                Object[] row = new Object[3];
                tableModel.setRowCount(0);

                try {
                    ArrayList<Dish> menu = adminOp.getMenu();

                    for(int i=0; i<menu.size(); i++){
                        row[0] = menu.get(i).getDish_id();
                        row[1] = menu.get(i).getDish_name();
                        row[2] = menu.get(i).getDish_price();
                        tableModel.addRow(row);
                    }
                    resultsTable.setModel(tableModel);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });


    }
}
