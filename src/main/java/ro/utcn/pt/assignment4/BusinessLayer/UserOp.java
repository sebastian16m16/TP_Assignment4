package ro.utcn.pt.assignment4.BusinessLayer;

import ro.utcn.pt.assignment4.DataLayer.DBConnection;
import ro.utcn.pt.assignment4.DataLayer.DishOp;
import ro.utcn.pt.assignment4.DataLayer.OrderOp;
import ro.utcn.pt.assignment4.Model.Dish;
import ro.utcn.pt.assignment4.Model.Order;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Defines the privileges of a waiter
 */
public class UserOp {

    DBConnection connection = DBConnection.getConnection();
    DishOp dishOp = new DishOp();
    OrderOp orderOp = new OrderOp();

    /**
     * Returns all the items from the menu
     * @return An array list containing all the items from the menu
     * @throws SQLException
     */
    public ArrayList<Dish> getMenu() throws SQLException {
        return dishOp.getMenu(connection.connection);
    }

    /**
     * Gets a menu item
     * @param name
     * @return the menu item
     * @throws SQLException
     */
    public Dish getDish(String name) throws SQLException{
        return dishOp.getDish(connection.connection, name);
    }

    /**
     * Adds a new order
     * @param order
     * @throws SQLException
     */
    public void addOrder(Order order)throws SQLException{
        orderOp.addOrder(connection.connection, order);
    }

    /**
     * Deletes an order
     * @param id
     * @throws SQLException
     */
    public void deleteOrder(int id) throws SQLException{
        orderOp.deleteOrder(connection.connection, id);
    }

    /**
     * Gets all the orders
     * @return Array list that contains all the orders
     * @throws SQLException
     */
    public ArrayList<Order> getAllOrders() throws SQLException{
        return orderOp.getAllOrders(connection.connection);
    }

    /**
     * Tells if the order exists
     * @param id
     * @return the order
     * @throws SQLException
     */
    public boolean existsOrder(int id) throws SQLException{
        return orderOp.existsOrder(connection.connection, id);
    }

    /**
     * Deletes all the made orders
     * @throws SQLException
     */
    public void deleteAll()throws SQLException{
        orderOp.deleteAll(connection.connection);
    }
}
