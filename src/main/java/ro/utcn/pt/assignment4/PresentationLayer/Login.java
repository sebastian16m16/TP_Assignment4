package ro.utcn.pt.assignment4.PresentationLayer;

import javax.swing.*;

public class Login extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel mainPanel;

    public Login(){

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,700);
        getRootPane().setDefaultButton(loginButton);
        add(mainPanel);
    }

}
