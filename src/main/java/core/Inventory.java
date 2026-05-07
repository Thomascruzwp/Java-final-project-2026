//Category: Encapsulation /Aggregation 

//Package declartion for cor classes 
package core;

//IMporting HasMap collection
import java.util.HashMap;

//Importing Map interface 
import java.util.Map;
//Importing all prodcut classes 

import product.*;
// Inventroy class stores products and slots
public class Inventory{

//Map connecting slots to products
//Encapsulation
    private Map<ProductSlot, Product> products = new HashMap<>();

    //Add a product into inventroy
    public void addProduct(ProductSlot slot, Product product){
        //Storing product in slot 

        products.put(slot, product);
    }
//Returns product from a slot 
//Encapsulation
    public Product getProduct(ProductSlot slot) {
        //Returning stored product
        return products.get(slot);
    }
// Returns all inventory product 
//Encapsulation
    public Map<ProductSlot, Product> getProducts(){
        //Returning product map 
        
        return products;
    }
}