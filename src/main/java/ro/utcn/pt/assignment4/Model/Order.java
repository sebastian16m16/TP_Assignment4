package ro.utcn.pt.assignment4.Model;

public class Order {

    protected int order_id;
    protected int dish_id;
    protected String dish_name;
    protected int quantity;
    protected double totalSum;
    protected int table;

    public Order() {
    }


    public Order(int order_id, int dish_id, String dish_name, int quantity, double totalSum, int table) {
        this.order_id = order_id;
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.quantity = quantity;
        this.totalSum = totalSum;
        this.table = table;
    }

    public Order(int dish_id, String dish_name, int quantity, double totalSum, int table) {
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.quantity = quantity;
        this.totalSum = totalSum;
        this.table = table;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
