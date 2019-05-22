package ro.utcn.pt.assignment4.BusinessLayer;

import ro.utcn.pt.assignment4.DataLayer.DBConnection;
import ro.utcn.pt.assignment4.DataLayer.DishOp;
import ro.utcn.pt.assignment4.Model.Dish;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Defines all the privileges an admin has
 */
public class AdminOp {

    DBConnection connection = DBConnection.getConnection();
    DishOp dishOp = new DishOp();

    /**
     * Gets all the items from the menu
     * @return Array list that contains all the items from the menu
     * @throws SQLException
     */
    public ArrayList<Dish> getMenu() throws SQLException{
        return dishOp.getMenu(connection.connection);
    }

    /**
     * Inserts a new item to the menu
     * @param dish_name
     * @param dish_price
     * @param quantity
     * @throws SQLException
     */
    public void insertDish(String dish_name, double dish_price, int quantity) throws SQLException{
        dishOp.insertDish(connection.connection, dish_name, dish_price, quantity);
    }

    /**
     * Deletes a dish
     * @param dish_name
     * @throws SQLException
     */
    public void deleteDish(String dish_name) throws SQLException{
        dishOp.deleteDish(connection.connection, dish_name);
    }

    /**
     * Edits the name of an item from the menu
     * @param dish_name
     * @param newName
     * @throws SQLException
     */
    public void editDishName(String dish_name, String newName) throws SQLException{
        dishOp.editDishName(connection.connection, dish_name, newName);
    }

    /**
     * Edits the price of an item from the menu
     * @param dish_name
     * @param newPrice
     * @throws SQLException
     */
    public void editDishPrice(String dish_name, double newPrice) throws SQLException{
        dishOp.editDishPrice(connection.connection, dish_name, newPrice);
    }

    /**
     * Edits the quantity of an item from the menu
     * @param dish_name
     * @param newQuantity
     * @throws SQLException
     */
    public void editDishQuantity(String dish_name, int newQuantity) throws SQLException{
        dishOp.editDishQuantity(connection.connection, dish_name, newQuantity);
    }

    /**
     * Tells if the item exists
     * @param dish_name
     * @return true or false
     * @throws SQLException
     */
    public boolean existsDish(String dish_name) throws SQLException{
        return dishOp.existsDish(connection.connection, dish_name);
    }




}
