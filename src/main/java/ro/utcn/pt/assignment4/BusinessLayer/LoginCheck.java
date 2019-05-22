package ro.utcn.pt.assignment4.BusinessLayer;

import ro.utcn.pt.assignment4.DataLayer.DBConnection;
import ro.utcn.pt.assignment4.DataLayer.LoginOp;

import java.sql.SQLException;

/**
 * This Class check the login
 */
public class LoginCheck {

    DBConnection connection = DBConnection.getConnection();
    LoginOp loginOp = new LoginOp();

    /**
     * Check to see if the login is valid
     * @param username
     * @param password
     * @return true or false
     * @throws SQLException
     */
    public boolean isLoginOk(String username, String password) throws SQLException{
        return loginOp.isLoginOk(connection.connection, username, password);
    }

    /**
     * Checks to see if the login belongs to an admin
     * @param username
     * @param password
     * @return true or false
     * @throws SQLException
     */
    public boolean isAdmin(String username, String password) throws SQLException{
        return loginOp.isAdmin(connection.connection, username, password);
    }
}
