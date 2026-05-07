//Category: Hardware / Encapsulation  
// Package declaration for hardware classes 

package hardware;

// Coin class represnts a single coin object 
public class Coin{

    //Stores the monetary value of the coin
    //Encapsulation 
    private double value;

    //Assigning value to coin
    public Coin(double value){
        this.value = value;
    }

    //Getter method return coin value
    public double getValue(){
    //returning coin value
        return value;
    }
}