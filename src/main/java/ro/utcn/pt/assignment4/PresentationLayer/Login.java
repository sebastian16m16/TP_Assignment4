package ro.utcn.pt.assignment4.PresentationLayer;

import ro.utcn.pt.assignment4.BusinessLayer.LoginCheck;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Provides the window for the login
 */
public class Login extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel mainPanel;


    /**
     * Creates the login window
     */
    public Login(){


        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(400,700);
        getRootPane().setDefaultButton(loginButton);
        setLocationRelativeTo(null);

        final LoginCheck loginCheck = new LoginCheck();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    if(loginCheck.isLoginOk(username, password)){
                        if(loginCheck.isAdmin(username, password)){
                            AdminGUI adminGUI = new AdminGUI();
                            adminGUI.setVisible(true);
                            setVisible(false);
                        }else{
                            UserGUI userGUI = new UserGUI();
                            userGUI.setVisible(true);
                            setVisible(false);
                        }
                    }else
                        JOptionPane.showMessageDialog(null,"Wrong Username or Password!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
