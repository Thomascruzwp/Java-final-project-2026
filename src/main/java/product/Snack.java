//Category: Inheritance / Polymorphism


// Package delcaration for product classes 
package product;

//Snack class inherits from Product
//Inheritance 

public class Snack extends Product{

    //Constructor initializes snack values
    public Snack(String name, double price, int stock){
        // Calling parent constructor 
        super(name, price, stock);
    }
// Overridden dispense method 
//Polymorphism
    @Override
    public void dispense(){

        //Displaying snakc dispensing message
        
        System.out.println("Dispensing snack: " + name);
    }
}