//Category: Polymorphism / State pattern / Encapsulation

//Package declartion for state classes 
package state;

//Importing vending machine core class
import core.VendingMachine;

//Importing Coin class
import hardware.Coin;

//ReadyState class impements VendingState 

public class ReadyState implements VendingState{
//Reference to vending machine 
//Encapsulation 
    private VendingMachine machine;

// Constructor initializes machine reference 

    public ReadyState(VendingMachine machine){
        //Assigning machine reference 
        this.machine = machine;
    }

    //Insert method handles coin insertion 
    //Polymorphism 
    @Override
    public void insert(Coin coin){
        //Adding balance to machine 
        machine.addBalance(coin.getValue());
        //Updating machine message 
        machine.setMessage("Inserted: " + coin.getValue() + " | Balance: " + machine.getBalance()); 
    }

    //Select method handles item selection
    //Polymorphism 

@Override
public void select(int item){
    // Validating balance
    if(machine.getBalance() <= 0){
        //Message for insufficient balance 
        machine.setMessage("Insert coins first");
        return;
    }
    
    // Displaying selected item
    machine.setMessage("Item selected: " + item);

    //Changing machine state
    machine.setState(new ProcessingPaymentState(machine));
}

// Dispense method 
//Polymorphism
@Override
public void dispense(){
    //Message shown before item selection

    machine.setMessage("Select item first");
}

// Cancel method
//Polymorphism
@Override
public void cancel(){
    //Message for empty transaction
    machine.setMessage("Nothing to cancel");
}
}