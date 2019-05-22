package ro.utcn.pt.assignment4.Model;

/**
 * This Class defines the Dish table object
 */

public class Dish {

    protected int dish_id;
    protected String dish_name;
    protected double dish_price;
    protected int quantity;



    public Dish() {
    }

    /**
     * Constructor:
     * @param dish_id
     * @param dish_name
     * @param dish_price
     * @param quantity
     */
    public Dish(int dish_id, String dish_name, double dish_price, int quantity) {
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.dish_price = dish_price;
        this.quantity = quantity;
    }

    /**
     * Get the Quantity
     * @return quantity in grams
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the id of the Dish
     * @return Id of the dish
     */
    public int getDish_id() {
        return dish_id;
    }

    /**
     * Sets the dish Id
     * @param dish_id
     */
    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    /**
     * Get the name of  the Dish
     * @return the name of the Dish
     */
    public String getDish_name() {
        return dish_name;
    }

    /**
     * Sets the dish name
     * @param dish_name
     */
    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    /**
     * Gets the price of the Dish
     * @return price of the Dish
     */
    public double getDish_price() {
        return dish_price;
    }

    /**
     * Sets the price of the Dish
     * @param dish_price
     */
    public void setDish_price(double dish_price) {
        this.dish_price = dish_price;
    }
}
