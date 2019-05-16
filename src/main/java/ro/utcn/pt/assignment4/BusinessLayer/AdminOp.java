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


}
