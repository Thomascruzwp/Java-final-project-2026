//Caegory: Abstraction / Polymorphism / State Pattern 

//Package declartion for state classes

package state;

// Importing Coin class

import hardware.Coin;

//Interface representing vending machine states 

public interface VendingState{

    // Method for selecting an item
    void select(int item);

    //Method for inserting coins 
    void insert(Coin coin);

    // mehtod for dispensing items 

    void dispense();
    //Method for cancelling transactions
    
    void cancel();
}