package ro.utcn.pt.assignment4.PresentationLayer;

import ro.utcn.pt.assignment4.Model.Order;

import java.util.ArrayList;

/**
 * Interface that defines the methods of an Observer
 */
public interface Observer {
    /**
     * Updates the list for the observer
     * @param toDo
     */
    public void update(ArrayList<Order> toDo);

}
