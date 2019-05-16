package ro.utcn.pt.assignment4.PresentationLayer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class UserGUI extends JFrame {
    private JPanel mainPanel;
    private JButton newOrderButton;
    private JButton viewAllOrdersButton;
    private JTable resultsTable;
    private JSplitPane splitpane;
    private JButton deleteOrderButton;

    public UserGUI(){

        setTitle("Waiter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1000);
        getRootPane().setDefaultButton(viewAllOrdersButton);
        add(mainPanel);


        Font font = new Font("", 1, 30);
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
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        resultsTable.setDefaultRenderer(Object.class, centerRenderer);




    }

}
