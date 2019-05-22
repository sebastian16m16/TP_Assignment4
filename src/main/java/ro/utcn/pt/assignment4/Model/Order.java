package ro.utcn.pt.assignment4.Model;

/**
 * This Class defines the order object
 */
public class Order {

    protected int order_id;
    protected int dish_id;
    protected String dish_name;
    protected int quantity;
    protected double totalSum;
    protected int table;

    public Order() {
    }

    /**
     * Constructor 2
     * @param order_id
     * @param dish_id
     * @param dish_name
     * @param quantity
     * @param totalSum
     * @param table
     */
    public Order(int order_id, int dish_id, String dish_name, int quantity, double totalSum, int table) {
        this.order_id = order_id;
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.quantity = quantity;
        this.totalSum = totalSum;
        this.table = table;
    }

    /**
     * Constructor 3
     * @param dish_id
     * @param dish_name
     * @param quantity
     * @param totalSum
     * @param table
     */
    public Order(int dish_id, String dish_name, int quantity, double totalSum, int table) {
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.quantity = quantity;
        this.totalSum = totalSum;
        this.table = table;
    }

    /**
     * Gets the Order Id
     * @return order id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * Sets the order id
     * @param order_id
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * Gets the dish id
     * @return dish id
     */
    public int getDish_id() {
        return dish_id;
    }

    /**
     * Sets Dish id
     * @param dish_id
     */
    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    /**
     * Gets the dish name
     * @return dish name
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
     * Gets the quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * sets the quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the total sum
     * @return total sum
     */
    public double getTotalSum() {
        return totalSum;
    }

    /**
     * Sets the total Sum
     * @param totalSum
     */
    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    /**
     * Gets The table where the dish is served
     * @return the table
     */
    public int getTable() {
        return table;
    }

    /**
     * Sets the table where the dish is served
     * @param table
     */
    public void setTable(int table) {
        this.table = table;
    }
}
