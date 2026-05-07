

//Category: Polymorphism / State Pattern / Encapsulation 


// Package declartion for state classes 
package state;

//Importing vending machine class
import core.VendingMachine;
//Importing coin class

import hardware.Coin;

//ProcessingPaymentState implements VendingState
public class ProcessingPaymentState implements VendingState{
    
    //Reference to vending machine 
    //Encapsulation
    private VendingMachine machine;

    // Constructor initializes machine refernce 
    public ProcessingPaymentState(VendingMachine machine) {
        //Assigning machine refernce
        this.machine = machine;
    }

    //Select method during payment processing 
    //Polymorphism 

    public void select(int item){
        // Processing message 
        System.out.println("Processing...");
    }

// Insert method handles additional coins 
//polymorphism 
    public void insert(Coin coin){
        // Adding balance 
        machine.addBalance(coin.getValue());
    }

//Dispense method 
//Polymorphism
    public void dispense(){
        //Dispensing message 
        System.out.println("Dispensing...");
        //Resetting machine 
        machine.reset();
        //Returning to ready state 

        machine.setState(new ReadyState(machine));
    }

    //Cancel method 
    //Polymorphism
    public void cancel(){
        //Cancel message 
        System.out.println("Cancelled");
        //Resetting machine
        machine.reset();
        //Returning to ready state 
        machine.setState(new ReadyState(machine));
    }

}