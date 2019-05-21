package ro.utcn.pt.assignment4.BusinessLayer;

import ro.utcn.pt.assignment4.DataLayer.DBConnection;
import ro.utcn.pt.assignment4.DataLayer.LoginOp;

import java.sql.SQLException;

public class LoginCheck {

    DBConnection connection = DBConnection.getConnection();
    LoginOp loginOp = new LoginOp();

    public boolean isLoginOk(String username, String password) throws SQLException{
        return loginOp.isLoginOk(connection.connection, username, password);
    }

    public boolean isAdmin(String username, String password) throws SQLException{
        return loginOp.isAdmin(connection.connection, username, password);
    }
}
