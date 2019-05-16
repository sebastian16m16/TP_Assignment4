package ro.utcn.pt.assignment4.PresentationLayer;

import ro.utcn.pt.assignment4.BusinessLayer.AdminOp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {
    private JTable table1;
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

        viewMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
