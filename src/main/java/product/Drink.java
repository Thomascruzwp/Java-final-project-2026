
//Category: Inheritance / Polymorphism 

// Package declaration for product classes 
package product;

//Drink class inherits from Product 
//Inheritance 
public class Drink extends Product{

    // Constructor initializes drink values 

    public Drink(String name, double price, int stock){
        // Calling parent constructor

        super(name, price, stock);
    }
    
    // Overrideen dispense mehtod 
    //Polymorphism

    @Override
    public void dispense(){
        
        //Displaying drink dispensing message 

        System.out.println("Dispensing drink: " + name);
    }
}