package ro.utcn.pt.assignment4.Model;

public class Dish {

    protected int dish_id;
    protected String dish_name;
    protected double dish_price;

    public Dish() {
    }

    public Dish(String dish_name, double dish_price) {
        this.dish_name = dish_name;
        this.dish_price = dish_price;
    }

    public Dish(int dish_id, String dish_name, double dish_price) {
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.dish_price = dish_price;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public double getDish_price() {
        return dish_price;
    }

    public void setDish_price(double dish_price) {
        this.dish_price = dish_price;
    }
}
