package ro.utcn.pt.assignment4.DataLayer;

import ro.utcn.pt.assignment4.Model.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This Class Does all the necessary Dish Table operations in the Data Base
 */
public class DishOp {

    /**
     * Get all the items in the menu
     * @param connection
     * @return An array list containing all the items from the menu
     * @throws SQLException
     */
    public ArrayList<Dish> getMenu(Connection connection) throws SQLException{
        String stmt = "Select * from Dish";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);

        ArrayList<Dish> menu = new ArrayList<>();

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            Dish foundDish = new Dish(resultSet.getInt("dish_id"),resultSet.getString("dish_name"),
                    resultSet.getDouble("dish_price"), resultSet.getInt("Quantity"));
            menu.add(foundDish);
        }

        return menu;
    }

    /**
     * Inserts an item into the Menu
     * @param connection
     * @param dish_name
     * @param dish_price
     * @param quantity
     * @throws SQLException
     */
    public void insertDish(Connection connection, String dish_name, double dish_price, int quantity) throws SQLException{
        String stmt = "Insert into dish (dish_name, dish_price, quantity) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setString(1, dish_name);
        preparedStatement.setDouble(2, dish_price);
        preparedStatement.setInt(3, quantity);
        preparedStatement.executeUpdate();
    }

    /**
     * Deletes the item from the menu with the given name
     * @param connection
     * @param dish_name
     * @throws SQLException
     */
    public void deleteDish(Connection connection, String dish_name) throws SQLException{
        String stmt = "Delete from dish where dish_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setString(1, dish_name);
        preparedStatement.executeUpdate();
    }

    /**
     * Edits the name of the menu item
     * @param connection
     * @param dish_name
     * @param newDishName
     * @throws SQLException
     */
    public void editDishName(Connection connection,String dish_name, String newDishName) throws SQLException{
        String stmt = "Update Dish set dish_name = ? where dish_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setString(1, newDishName);
        preparedStatement.setString(2, dish_name);
        preparedStatement.executeUpdate();
    }

    /**
     * Edits the price of the menu item
     * @param connection
     * @param dish_name
     * @param newPrice
     * @throws SQLException
     */
    public void editDishPrice(Connection connection, String dish_name, double newPrice) throws SQLException{
        String stmt = "Update Dish set dish_price = ? where dish_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setDouble(1, newPrice);
        preparedStatement.setString(2, dish_name);
        preparedStatement.executeUpdate();
    }

    /**
     * Edits the quantity of the menu item
     * @param connection
     * @param dish_name
     * @param newQuantity
     * @throws SQLException
     */
    public void editDishQuantity(Connection connection, String dish_name, int newQuantity) throws SQLException{
        String stmt = "Update Dish set quantity = ? where dish_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setDouble(1, newQuantity);
        preparedStatement.setString(2, dish_name);
        preparedStatement.executeUpdate();
    }

    /**
     * Checks to see if the item exists in the Data Base
     * @param connection
     * @param dish_name
     * @return true or false
     * @throws SQLException
     */
    public boolean existsDish(Connection connection, String dish_name) throws SQLException{
        String stmt = "Select * from dish where dish_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setString(1, dish_name);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next())
            return true;
        return false;
    }

    /**
     * Gets the menu item with the given name
     * @param connection
     * @param dish_name
     * @return menu item
     * @throws SQLException
     */
    public Dish getDish(Connection connection, String dish_name) throws SQLException{
        String stmt = "Select * from Dish where dish_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setString(1, dish_name);
        Dish dish = new Dish();

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            dish.setDish_id(resultSet.getInt("dish_id"));
            dish.setDish_name(resultSet.getString("dish_name"));
            dish.setDish_price(resultSet.getDouble("dish_price"));
            dish.setQuantity(resultSet.getInt("quantity"));

        }

        String name = dish.getDish_name();
        double price = dish.getDish_price();

        return dish;
    }
}
