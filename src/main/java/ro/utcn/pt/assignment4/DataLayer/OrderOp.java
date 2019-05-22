package ro.utcn.pt.assignment4.DataLayer;

import ro.utcn.pt.assignment4.Model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This Class operates the Order Table
 */
public class OrderOp {

    /**
     * Adds a new order to the Data Base
     * @param connection
     * @param order
     * @throws SQLException
     */
    public void addOrder(Connection connection, Order order)throws SQLException{
        String stmt = "Insert into Orders (dish_id, dish_name, quantity, totalSum, tableNr) values (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setInt(1, order.getDish_id());
        preparedStatement.setString(2, order.getDish_name());
        preparedStatement.setInt(3, order.getQuantity());
        preparedStatement.setDouble(4, order.getTotalSum());
        preparedStatement.setInt(5, order.getTable());

        preparedStatement.executeUpdate();
    }

    /**
     * Gets all the orders from the data base
     * @param connection
     * @return Array list that contains all the orders
     * @throws SQLException
     */
    public ArrayList<Order> getAllOrders(Connection connection) throws SQLException{
        String stmt = "Select * from Orders";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);

        ArrayList<Order> allOrders = new ArrayList<>();
        Order order;

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            order = new Order(resultSet.getInt("order_id"), resultSet.getInt("dish_id"),
                    resultSet.getString("dish_name"), resultSet.getInt("Quantity"), resultSet.getDouble("totalSum"),
                    resultSet.getInt("tableNr"));
            allOrders.add(order);
        }

        return allOrders;
    }

    /**
     * Deletes an order
     * @param connection
     * @param id
     * @throws SQLException
     */
    public void deleteOrder(Connection connection, int id) throws SQLException{
        String stmt = "Delete from orders where order_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    /**
     * Tells if the order exists
     * @param connection
     * @param id
     * @return true or false
     * @throws SQLException
     */
    public boolean existsOrder(Connection connection, int id) throws SQLException{
        String stmt = "Select * from orders where order_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            return true;
        }
        return false;
    }

    /**
     * Deletes all the items from the order table
     * @param connection
     * @throws SQLException
     */
    public void deleteAll(Connection connection) throws SQLException{
        String stmt = "Delete from Orders";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.executeUpdate();
    }
}
