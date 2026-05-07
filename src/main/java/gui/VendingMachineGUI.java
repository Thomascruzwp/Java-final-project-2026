//Category: GUI / Encapsulation / User Interaction / Swing Application 

// Package declaration for GUI layer 
package gui; 

//Importing Swing components for UI creation 
import javax.swing.*;
//Importing AWT for layout mangers, fonts, colors, and dimensions 
import java.awt.*;
//Importing ArrayList for dynamic cart storage 
import java.util.ArrayList;
//Importin g LinkedHashMap to preserve item order 
import java.util.LinkedHashMap;
// Importing Map interface for collections 
import java.util.List;

// Importing Map interface for key value item storage 
import java.util.Map;

// Main GUI for vending machine system 
//Inheritance: extends JFrame to create application window 
public class VendingMachineGUI extends JFrame{
    //Label showing private field 
    private JLabel status;
    //label showing current balance 
    //Encapsulation: private field 
    private JLabel balance;

    //Text area showing cart contents 
    //Encapsulation private field
    private JTextArea cartArea;

    //Stores selected item codes in cart 
    //Encapsulation private collection 
    private List<String> cart = new ArrayList<>();

     //Stores inserted money values 
    //Encapsulation private collection 
    private List<Double> money = new ArrayList<>();

//Inner class representing an item in vendin machine 
//Encapsulation group name and price together 
    private static class Item{
        //Item name 
        String name;
        //Item price 
        double price;

//Constructor initializes item data
        Item(String name, double price){

            //Assign item name 
            this.name = name;

            //Assign item price 
            this.price = price;
        }
    }

    //Map stroign vending machine items using item codes
    //Encapsulation private data structure 
    private Map<String, Item> items = new LinkedHashMap<>();

//Constructor builds entire GUI and initializes system
    public VendingMachineGUI(){
        //Registering drink items into vending machine 
        register("A2", "Diet Coke", 1.85);
        register("A3", "pepsi", 1.65);
        register("A4", "Sprite", 1.70);
        register("A5", "Fanta Orange", 1.80);
        register("A6", "Dr Pepper", 1.90);
        register("A7", "Water Bottle", 1.00);
        register("A8", "Sparkling Water", 1.25);
        register("A9", "Sparkling Water", 2.25);
        register("A10", "Powerade", 2.35);



//Registering chips items
        register("B1", "Lays Chips", 1.50);
        register("B2", "Doritos", 1.60);
        register("B3", "Cheetos", 1.55);
        register("B4", "Ruffles", 1.65);
        register("B5", "Pringles", 2.00);

        //Registering chips items
        register("C1", "Snickers", 1.75);
        register("C2", "KitKat", 1.80);
        register("C3", "Twix", 1.85);
        register("C4", "M&Ms", 1.95);
        register("C5", "Skittles", 1.90);

        //registering snacks
        register("D1", "Oreo Cookies", 2.10);
        register("D2", "Granola Bar", 1.40);
        register("D3", "Trail Mix", 2.30);
        register("D4", "Salted Peanuts", 1.20);
        register("D5", "Salt Crackers", 1.25);


// Registering additional snacks and drinks 
        register("E1", "Pretzels", 1.45);
        register("E2", "Rice Krispies", 1.35);
        register("E3", "Cheese Crackers", 1.30);
        register("E4", "Beef Jerky", 2.75);
        register("E5", "Iced Tea", 2.10);

        //Setting layout window title  
        setTitle("Vending Machine");
        //Setting layout window size
        setSize(950, 900);
        //Program closes when window is closed 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting layout manger 
        setLayout(new BorderLayout());


        // Top panel for status and balance display 
        JPanel top = new JPanel(new GridLayout(2, 1));

        //Initial status message 
        status = new JLabel("Insert Money");
        //Initial balance display 
        balance = new JLabel("Balance: $0.00");

        //Adding status label to top panel 
        top.add(status);
        //Adding balance label to top panel
        top.add(balance);

        // Adding top panel to window 
        add(top, BorderLayout.NORTH);

    // Creating cart display area 
        cartArea = new JTextArea();
        //making car readonly 
        cartArea.setEditable(false);
        // Setting font for cart display
        cartArea.setFont(new Font("Arial", Font.PLAIN, 14));

// Scroll pane for cart
        JScrollPane scroll = new JScrollPane(cartArea);
        // Setting cart panel width 
        scroll.setPreferredSize(new Dimension(220, 0));

        //Adding cart to right side
        add(scroll, BorderLayout.EAST);

        //Center panel holding money + items 
        JPanel center = new JPanel(new GridLayout(1, 2));

        // Money panel for inserting cash 
        JPanel moneyPanel = new JPanel(new GridLayout(0, 1));
        //Border title for money panel
        moneyPanel.setBorder(BorderFactory.createTitledBorder("Money"));

// Adding coin buttons 
        addMoney(moneyPanel, "$0.50", 0.50);
        addMoney(moneyPanel, "$0.25", 0.25);
        addMoney(moneyPanel, "$0.10", 0.10);
        addMoney(moneyPanel, "$0.05", 0.05);
        addMoney(moneyPanel, "$0.01", 0.01);
 
        //Adding bill buttons 
        addMoney(moneyPanel, "$1 Bill", 1.00);
        addMoney(moneyPanel, "$5 Bill", 5.00);
        addMoney(moneyPanel, "$10 Bill", 10.00);
        addMoney(moneyPanel, "$20 Bill" , 20.00);

        //Item selection panel
        JPanel itemPanel = new JPanel(new GridLayout(0, 2));
        //Border title for items 
        itemPanel.setBorder(BorderFactory.createTitledBorder("Items"));

        // Creating item buttons from map 
        for (String code : items.keySet()){
            // Adding button for each item 
            addItemButton(itemPanel, code);
        }
// adding panels to center layout 
        center.add(moneyPanel);
        center.add(itemPanel);
// Adding center panel to frame 
        add(center, BorderLayout.CENTER);
        
        //Buy button (final purchase action)
        JButton buy = new JButton("BUY ALL");
        //Setting button color (green = success action)
        buy.setBackground(Color.GREEN);

        //Cancel button (refund action)
        JButton cancel = new JButton("CANCEL");
        // Setting button color (red = cancel action)
        cancel.setBackground(Color.RED);

// Buy button logic 
        buy.addActionListener(e -> {

            // Calculating total cost
            double total = calculateTotal();
            //Calculating inserted money
            double moneyTotal = getBalance();

            // Checking if enough balance exists 
            if (moneyTotal < total) {
                //Error message 
                status.setText("Not enough money");
                return;
            }
            // Calcualting change 
            double change = moneyTotal - total;

            //Dispensing items in cart
            for (String code : cart){
                //Updating status 
                status.setText("Dispensing " + code);
                //Small delay simulation 
                try{Thread.sleep(20); } catch (Exception ignored) {}
            }
            //Clearing cart after purchase 
            cart.clear();
            //Clearing money after purchase 
            money.clear();

            //Updating UI 
            updateCart();
            updateUI();

            //Showing change 
            status.setText("Change: $" + String.format("%.2f", change));
        });

        //Cancel button logic 
        cancel.addActionListener(e -> {
            // Calculating refund 
            double refund = getBalance();
// Clearing cart 
            cart.clear();
            //Clearing money 
            money.clear();
//Updating UI 
            updateCart();
            updateUI();

            // Showing refund message 
            status.setText("Refunded: $" + String.format("%.2f", refund));
        });

        // Bottom panel for buttons 
        JPanel bottom = new JPanel(new GridLayout(1, 2));
        // Adding buttons to bottom panel
        bottom.add(buy);
        bottom.add(cancel);

        // adding bottom panel to frame
        add(bottom, BorderLayout.SOUTH);    
        
        // Making GUI visible 
        setVisible(true);
    }


    //Registers item into vending machine 
    //Encapsulation 
    private void register(String code, String name, double price) {
        //Adding itme into map
        items.put(code, new Item(name, price));
    }

    //Creating button 
    private void addMoney(JPanel panel, String label, double value){
        // Creating button 
        JButton btn = new JButton(label);
        //Setting font style 
        btn.setFont(new Font("Arial", Font.PLAIN, 11));
        //Setting button spacing 
        btn.setMargin(new Insets(2, 2, 2, 2));
//Button click event 
        btn.addActionListener(e-> {
            // Adding money to blance list
            money.add(value);
            // Updating UI 
            updateUI();
        });

        // Adding button to panel
        panel.add(btn);
    }

    // Creates item buttons 
    //Encapsulation 
    private void addItemButton(JPanel panel, String code){
        //Creating formatted button
        Item item = items.get(code);

        JButton btn = new JButton(
        "<html><center>"
        + code + "<br>"
        + item.name + "<br>"
        + String.format("$%.2f", item.price)
        + "</center></html>"
        );

        // Setting font size 
        btn.setFont(new Font("Arial", Font.PLAIN, 10));
        //Setting button size 
        btn.setPreferredSize(new Dimension(140, 90));

        //Button click event 
        btn.addActionListener(e -> {
            //Adding item to cart 
            cart.add(code);
            // Updating cart display 
            updateCart();
        });
// Adding button to panel 
        panel.add(btn);
    }

    //Updates cart display 
    //encapsulation
    private void updateCart(){
        
        // If cart is empty
        if(cart.isEmpty()){
            //Show empty mesage 
        cartArea.setText("Cart: empty");
        return;
    }

    //String builder for cart display
    StringBuilder sb = new StringBuilder();
    //Total price variable 
    double total = 0;

//Loop through cart 
    for (String code : cart){
        // Add item code 
        sb.append(code).append("\n");
        //Add price 
        total += items.get(code).price;
    }
    
    //Append total 
    sb.append("\nTotal: $").append(String.format("%.2f", total));
    //Update text area 
    cartArea.setText(sb.toString());
    }

    //Calcualtes total cart value 
    //Encapsulation 
    private double calculateTotal(){
        //Total variable 
        double total = 0;

        //Loop through cart itmes 
        for (String code : cart){
            // Add price 
            total += items.get(code).price;
        }
        //Return total 
        return total;
    }

    //Calculates inserted money 
    private double getBalance(){
        // Total variable 
        double total = 0;
        //Loop through money list 
        for (double m : money){
            // Add value 
            total += m;
        }
        //Return balance 
        return total;
    }
    
    //Updates balance label 
    //Encapsulation 
    private void updateUI(){
        // Set balance text
        balance.setText("Balance: $" + String.format("%.2f", getBalance()));
    }
}
