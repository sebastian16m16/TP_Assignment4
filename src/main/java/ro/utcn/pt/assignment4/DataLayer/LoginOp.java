package ro.utcn.pt.assignment4.DataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class gets the info from the Data Base concerning the login process
 */
public class LoginOp {

    /**
     * Tells if the login account is ok
     * @param connection
     * @param username
     * @param password
     * @return true or false
     * @throws SQLException
     */
    public boolean isLoginOk(Connection connection, String username, String password) throws SQLException{
        String stmt = "Select * from login where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next())
            return true;
        return false;
    }

    /**
     * Tells if the inserted account is admin
     * @param connection
     * @param username
     * @param password
     * @return true or false
     * @throws SQLException
     */
    public boolean isAdmin(Connection connection, String username, String password) throws SQLException{
        String stmt = "Select status from login where username =? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        boolean admin = false;

        while(resultSet.next()){
            admin = resultSet.getBoolean("status");
        }

        return admin;
    }
}
