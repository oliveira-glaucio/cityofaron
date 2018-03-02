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
    private static Game theGame = cityofaron.CityOfAron.getTheGame();
    private static CropData theCropData = theGame.getCropData();
    
    
// The buyLandView method
// Purpose: interface with the user input for buying land
// Parameters: none
// Returns: none
 public static void buyLandView()
 {
     // Get the cost of land for this round.
     int price = CropControl.calcLandCost();

     // Prompt the user to enter the number of acres to buy
     System.out.format("Land is selling for %d bushels per acre.%n", price);
     System.out.print("\nHow many acres of land do you wish to buy? "); 

    //  Get the user’s input and save it.
    int toBuy;
    toBuy = keyboard.nextInt();
    
    
    
    CropControl.buyLand(toBuy, theCropData, price, 0);       
}
 
 
 public static void sellLandView()
 {
     // Prompt the user to enter the number of acres to sell
     System.out.print("\nHow many acres of new land do you want to sell? "); 

    // Get the user’s input and save it.
    int toSell = 0, typedValue = 0;
    Boolean validInput = false;
    
    //Wait for a valid and positive input
    while(!validInput)
    {
        validInput = keyboard.hasNextInt();
        
        if(validInput == true){
            typedValue = keyboard.nextInt();
            
            if(typedValue <= 0) 
            {
                System.out.print("\nPlease type a positive number."); 
                validInput = false;
            }
            else if (CropControl.getCropData().getAcresOwned() > typedValue){
               System.out.print("\nYou don't have all this land to sell. Type a smaller number."); 
               validInput = false;
            }
        }
    }
    
    toSell = typedValue;
    
    CropControl.sellLand(0, toSell, theCropData);   
 }
 // The feedPeopleView method()
// Purpose: allocates wheat to feed the people
// Parameters: none
// Returns: none
//Author: Arunas Rancevas
   //Please advice how to make this work 100 %?
   
   public static void feedPeopleView()
   {
       // Get wheat in store for this round.
       //int wheatInStore = CropControl.WheatInStore();

       // Prompt the user to enter the number of wheat to allocate
       System.out.print("\nHow many bushels of grain do you want to give to the people? "); 

       //  Get the user’s input and save it.
       int toFeed ,typedValue;
       toFeed = keyboard.nextInt();
       Boolean validInput = false;
   
         //Wait for a valid and positive input
        while(!validInput)
   {
       validInput = keyboard.hasNextInt();
       
       if(validInput == true){
           typedValue = keyboard.nextInt();
           
           if(typedValue <= 0) 
           {
               System.out.print("\nPlease type a positive number."); 
               validInput = false;
           }
           else if (theCropData.getWheatInStore() > typedValue){
              System.out.print("\nYou don't have all this wheat to alocate. Type a smaller number."); 
              validInput = false;
           }
}
  }
 }//the fourth on
    
// The runCropsView method()
// Purpose: runs the City of Aron Game
// Parameters: none
// Returns: none
public static void runCropsView()
{
    buyLandView();

    sellLandView();

}


}
