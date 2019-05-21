package ro.utcn.pt.assignment4.BusinessLayer;

import ro.utcn.pt.assignment4.DataLayer.DBConnection;
import ro.utcn.pt.assignment4.DataLayer.DishOp;
import ro.utcn.pt.assignment4.DataLayer.OrderOp;
import ro.utcn.pt.assignment4.Model.Dish;
import ro.utcn.pt.assignment4.Model.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserOp {

    DBConnection connection = DBConnection.getConnection();
    DishOp dishOp = new DishOp();
    OrderOp orderOp = new OrderOp();

    public ArrayList<Dish> getMenu() throws SQLException {
        return dishOp.getMenu(connection.connection);
    }

    public Dish getDish(String name) throws SQLException{
        return dishOp.getDish(connection.connection, name);
    }

    public void addOrder(Order order)throws SQLException{
        orderOp.addOrder(connection.connection, order);
    }

    public void deleteOrder(int id) throws SQLException{
        orderOp.deleteOrder(connection.connection, id);
    }

    public ArrayList<Order> getAllOrders() throws SQLException{
        return orderOp.getAllOrders(connection.connection);
    }

    public boolean existsOrder(int id) throws SQLException{
        return orderOp.existsOrder(connection.connection, id);
    }

    public void deleteAll()throws SQLException{
        orderOp.deleteAll(connection.connection);
    }
}
