//Category: Abstraction / Inheritance / Encapsulation 

// Package declaration for product classes 

package product;

//Abstract parent class for all vending products
//Abstraction
public abstract class Product{

    //Product name
    //Encapsulation
    protected String name;

    //Product price 
    //Encapsulation 
    protected double price;

    //Product stock quantity 
    //Encapsulation 
    protected int stock;

    //Constructor initializes product values 

    public Product(String name, double price, int stock){
        //Assigning produc name 
        this.name = name;
        //Assigning product price 
        this.price = price;
        //Assigning product stock 
        this.stock = stock;
    }
    //Getter method for product price 
    //Encapsulation
    public double getPrice(){
        //Returning product price 
        return price;
    }
    
    // Getter mehtod for product name 
    //Encapsulation 
    public String getName(){
        //Returning product name

        return name;
    }

    // Checks if product is available 
    public boolean inStock(){
        //Returning product name 

        return stock > 0;
    }
// Reduces product stock
    public void reduceStock(){
        //Validating stock 
        if (stock > 0) 
            //Decreaing stock quantity

            stock--;
    }

    //Abstract dispense method 
    //abstraction / Polymorphism 

    public abstract void dispense();
}
