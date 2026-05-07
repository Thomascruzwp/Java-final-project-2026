//Category: Encapsulation 

//Package class represnets vending machine slots

package core;

//Slot identification number 
//Encapsulation 
public class ProductSlot{
    //Constructor initializes slot ID 

    private int id;
//Constructoy initializes Slot ID 
    public ProductSlot(int id){
        //Assigning slot ID 
        this.id = id;
    }

// Getter mehtod for slot ID 
//Encapsulation 
    public int getId(){
        //Returning slot ID 
        return id;
    }
}