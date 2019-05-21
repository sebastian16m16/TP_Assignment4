package ro.utcn.pt.assignment4.PresentationLayer;

import ro.utcn.pt.assignment4.Model.Order;

import java.util.ArrayList;

public interface Observer {

    public void update(ArrayList<Order> toDo);

}
