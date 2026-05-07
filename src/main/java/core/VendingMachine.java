
// Category: Encapsulation / State Pattern / Polymorphism 


// Package declartion for core classes 
package core;

//Importing all state classes 
import state.*;
//Importin Coin class

import hardware.Coin;
// Main vending machine controller class
public class VendingMachine{
    //Current balance inside the machine 
    //Encapsulation
    private double currentBalance;
    //Machine location
    //Encapsulation
    private String location;
    //Current machine state 
    //Polymorphsim / State Pattern 
    private VendingState state;

//Inventory object storing products 
//Encapsulation
    private Inventory inventory;
    //Message shown by vending machine 
    private String message = "";

//Constructor initializes vending machine 

    public VendingMachine(String location){
        //Starting machine location 
        this.location = location;
        //default machine state 
        //polymorphism
        this.state = new ReadyState(this);
        //Starting balance 
        this.currentBalance = 0;

        //Creating inventory object
        this.inventory = new Inventory();
// Initial machine message 
        setMessage("Machine ready at " + location);
    }
    // Sets machine message 
    //Encapsulation
    public void setMessage(String msg){
        //Updating message 
        this.message = msg;
    }

    //Returns machine message 
    //Encapsulation 
    public String getMessage(){
        //Returning current message 
        return message;
    }

    // Returns inventory object 
    //Encapsulation
    public Inventory getInventory(){
        //Returning inventory
        return inventory;
    }
    // Inserts a coin machine 
    //Polymorphism
    public void insertCoin(Coin coin){
        //Delegating insert behavior to current state 

        state.insert(coin);
    }
    //Selects an item
    //Polymorphism
    public void selectItem(int id){
        //Delegating selection behavior to current state 
        state.select(id);
    }

    // Dispesnes selected item
    //Polymorphism
    public void dispense(){
    // Delegating cancel behavior to current state 
        state.dispense();
    }
    //Cancels current transaction
    //Polymorphism
    public void cancel(){
        //Delegating cancel behavior to current state

        state.cancel();
    }
// Adds money to machine balance 
//Encapsulation
public void addBalance(double amount){
    //Increasing balance 

    currentBalance += amount; 
}

//Returns current balance 
//Encapsulation 

public double getBalance(){
    //Resetting balance 
    return currentBalance;
}


//Resets vending machine 
//Encapsulation 
public void reset(){
    // Resetting balance 
    currentBalance = 0;

    //Returning to ready state 
    setState(new ReadyState(this));
}
//Changes vending machine state 
//Polymorphism 

public void setState(VendingState state){
    //Assigning new state 
    this.state = state;
}

//Returns machine location
//Encapsulation
public String getLocation(){
    
    //Returning location 
    return location;
}
}