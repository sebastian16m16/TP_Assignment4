package ro.utcn.pt.assignment4.PresentationLayer;

import ro.utcn.pt.assignment4.Model.Order;

import javax.swing.*;
import java.util.ArrayList;


public class ChefWindow extends JFrame implements Observer {

    private JList chefList;
    private JPanel chefPanel;

    DefaultListModel<String> chefListModel = new DefaultListModel<>();

    public ChefWindow(){
        setTitle("Chef");
        setContentPane(chefPanel);
        pack();
        setSize(500, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(1400, 10);

        setVisible(true);

    }

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
