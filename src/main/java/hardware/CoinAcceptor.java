
//Category: Hardware / Encapsulation 
//Package declaration for hardware classes 

package hardware;

//Importing ArrayList collection


import java.util.ArrayList;

//Importing List interface 

import java.util.List;

// CoinAcceptor handles inserted coins
public class CoinAcceptor{

    //Encapsulation
    private List<Coin>  acceptedCoins = new ArrayList<>();

    //Accept method adds coins into storage 
    public void accept(Coin coin){

        // Adding inserted coin to collection 
        acceptedCoins.add(coin);
    }

}