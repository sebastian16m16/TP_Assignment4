package ro.utcn.pt.assignment4.PresentationLayer;

import ro.utcn.pt.assignment4.Model.Order;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Creates the window for the chef (where he gets all the orders)
 */
public class ChefWindow extends JFrame implements Observer {

    private JList chefList;
    private JPanel chefPanel;

    DefaultListModel<String> chefListModel = new DefaultListModel<>();

    /**
     * Constructor creates the window for the chef
     */
    public ChefWindow(){
        setTitle("Chef");
        setContentPane(chefPanel);
        pack();
        setSize(500, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(1400, 10);

        setVisible(true);

    }

    /**
     * Implements the method from the Observer interface
     * @param toDo
     */
    @Override
    public void update(ArrayList<Order> toDo) {
        System.out.println("Chef list updated");
        chefListModel.clear();
        for(Order order : toDo){
            chefListModel.addElement(order.getDish_name() + " x" + order.getQuantity());
        }
        chefList.setModel(chefListModel);

    }




}
