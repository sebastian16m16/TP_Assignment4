package ro.utcn.pt.assignment4.BusinessLayer;

import ro.utcn.pt.assignment4.DataLayer.DBConnection;
import ro.utcn.pt.assignment4.DataLayer.DishOp;
import ro.utcn.pt.assignment4.Model.Dish;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminOp {

    DBConnection connection = DBConnection.getConnection();
    DishOp dishOp = new DishOp();

    public ArrayList<Dish> getMenu() throws SQLException{
        return dishOp.getMenu(connection.connection);
    }

    public void insertDish(String dish_name, double dish_price) throws SQLException{
        dishOp.insertDish(connection.connection, dish_name, dish_price);
    }

    public void deleteDish(String dish_name) throws SQLException{
        dishOp.deleteDish(connection.connection, dish_name);
    }

    public void editDishName(String dish_name, String newName) throws SQLException{
        dishOp.editDishName(connection.connection, dish_name, newName);
    }

    public void editDishPrice(String dish_name, double newPrice) throws SQLException{
        dishOp.editDishPrice(connection.connection, dish_name, newPrice);
    }


}
