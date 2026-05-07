package core;

import state.*;
import hardware.Coin;

public class VendingMachine{
    private double currentBalance;
    private String location;
    private VendingState state;

    private Inventory inventory;
    private String message = "";

    public VendingMachine(String location){
        this.location = location;
        this.state = new ReadyState(this);
        this.currentBalance = 0;

        this.inventory = new Inventory();

        setMessage("Machine ready at " + location);
    }
    // this is message 
    public void setMessage(String msg){
        this.message = msg;
    }

    public String getMessage(){
        return message;
    }

    //Inventory
    public Inventory getInventory(){
        return inventory;
    }
    //actions 
    public void insertCoin(Coin coin){
        state.insert(coin);
    }
    public void selectItem(int id){
        state.select(id);
    }

    public void dispense(){
        state.dispense();
    }
    public void cancel(){
        state.cancel();
    }
//Balance 
public void addBalance(double amount){
    currentBalance += amount; 
}

public double getBalance(){
    return currentBalance;
}


//Reset 
public void reset(){
    currentBalance = 0;

    setState(new ReadyState(this));
}

public void setState(VendingState state){
    this.state = state;
}

//location 
public String getLocation(){
    return location;
}
}