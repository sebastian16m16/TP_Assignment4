package ro.utcn.pt.assignment4.Model;

public class Order {

    protected int order_id;
    protected int dish_id;
    protected String dish_name;
    protected int quantity;

    public Order() {
    }

    public Order(int order_id, int dish_id, String dish_name, int quantity) {
        this.order_id = order_id;
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.quantity = quantity;
    }

    public Order(int dish_id, String dish_name, int quantity) {
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.quantity = quantity;
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
}
