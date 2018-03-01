/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaron.view;

import cityofaron.model.*;
import cityofaron.control.*;
import java.util.Scanner;


/**
 *
 * @author glaucio
 */
public class CropView {
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);
 
    
    // Get reference to the Game object and the Crops object
    private static Game theGame = DeBryGameProject.getCurrentGame();
    private static CropData theCropData = theGame.getCropData();

    
     // The buyLandView method
 // Purpose: interface with the user input for buying land
// Parameters: none
 // Returns: none
 public static void buyLandView()
 {
     // Get the cost of land for this round.
     int price = CropDataControl.calcLandCost();

     // Prompt the user to enter the number of acres to buy
     System.out.format("Land is selling for %d bushels per acre.%n",price);
     System.out.print("\nHow many acres of land do you wish to buy? "); 

    //  Get the user’s input and save it.
    int toBuy;
    toBuy = keyboard.nextInt();

    // Call the buyLand( ) method in the control layer to buy the land
    CropDataControl.buyLand(toBuy, price);
    
}
 
 
// The runCropsView method()
// Purpose: runs the Hamurabi game
// Parameters: none
// Returns: none
public static void runCropsView()
{
    // call the buyLandView( ) method
    buyLandView();

    // add calls to the other crop view methods
    // as they are written
}


}
