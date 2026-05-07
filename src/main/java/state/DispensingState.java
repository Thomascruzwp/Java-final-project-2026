

// Category: Polymorphism / State pattern / Encapsulation 

// Package declaration for state classes 
package state;

// Importing vending machine class 
import core.VendingMachine;

// Importing Coin class 
import hardware.Coin;

//DispensingState implements VendingState 
// Polymorphism
public class DispensingState implements VendingState{

    //referemce to vending machine 
    //Encapsulation 
    private VendingMachine machine;

    //Constructor initializes machine refernce 
    public DispensingState(VendingMachine machine)
{ // Assigning machine reference 
        this.machine = machine;
    }

    //Slect method while dispensing 
    // Polymorphism
    @Override
    public void select(int item){
        //Preventing additional selections 
        machine.setMessage("Already dispensing");
    }
    //Insert method while dispensing 
    //Polymorphism
    @Override
    public void insert(Coin coin){
        //Preventing coin insertion
        machine.setMessage("Cannot insert now");
    }
// Dispense method 
//Polymorphism
    @Override
    public void dispense(){
        //Dispensing message 
        machine.setMessage("Dispensing item...");
        //Resetting machine 
        machine.reset();
        //Returning machine to ready state 
        machine.setState(new ReadyState(machine));
    }
// Cancel method while dispensing
//Polymorphism 
    @Override
    public void cancel(){
//Preventing cancellation
            machine.setMessage("Cannot cancel");
        }
}