/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaron.view;

import cityofaron.model.*;
import cityofaron.control.*;
import cityofaron.exceptions.CropException;
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
    public static void buyLandView() throws CropException {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();
        boolean paramsNotOkay;

        do {
            paramsNotOkay = false;

            // Prompt the user to enter the number of acres to buy
            System.out.format("Land is selling for %d bushels per acre.%n", price);
            System.out.print("\nHow many acres of land do you wish to buy? ");

            //  Get the user’s input and save it.
            int toBuy;
            toBuy = keyboard.nextInt();

            try {
                CropControl.buyLand(toBuy, theCropData, price, 0);
            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);

    }

    public static void sellLandView() {
        // Prompt the user to enter the number of acres to sell
        System.out.print("\nHow many acres of new land do you want to sell? ");

        // Get the user’s input and save it.
        int toSell = 0, typedValue = 0;
        Boolean validInput = false;
        boolean paramsNotOkay;

        do {
            paramsNotOkay = false;

            //Wait for a valid and positive input
            while (!validInput) {
                validInput = keyboard.hasNextInt();

                if (validInput == true) {
                    typedValue = keyboard.nextInt();

                    if (typedValue <= 0) {
                        System.out.print("\nPlease type a positive number.");
                        validInput = false;
                    } else if (CropControl.getCropData().getAcresOwned() > typedValue) {
                        System.out.print("\nYou don't have all this land to sell. Type a smaller number.");
                        validInput = false;
                    }
                }
            }

            toSell = typedValue;
            try {
                CropControl.sellLand(0, toSell, theCropData);
            } catch (CropException e) {
                System.out.println("I am sorry, something went wrong.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);
    }
// The feedPeopleView method()
// Purpose: allocates wheat to feed the people
// Parameters: none
// Returns: none
//Author: Arunas Rancevas
    public static void feedPeopleView() {
  // Check wheatInStore for this round.
   int wheatInStore = theCropData.getWheatInStore();
   //  Get the user’s input and save it.
   int toFeed;
   boolean paramsNotOkay;
     do {
            paramsNotOkay = false;
            System.out.print("\nHow many bushels of wheat do you want to alloacte to the people?  ");   
            toFeed = keyboard.nextInt();
            try {
              CropControl.feedPeople(theCropData, toFeed);  
            } catch(CropException e) {
                System.out.println("Excuse me, something went wrong.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        }while(paramsNotOkay);
    }//the fourth one
    
  //The showStarvedView method()
  //Purpose: shows the number of people in the population that starved
  //Parameters: none
  //Returns: none
 public static void calcStarvedView() {
 // Check peopleStarved  for this round.
/int peopleStarved = CropControl.peopleStarved();
boolean paramsNotOk;
do {
    paramsNotOk = false;
    try {CropControl.peopleStarved(peopleFed, population, theCropData);
   }
    catch (Exception e)
    {
        System.out.println("Your actions cost the lives of your people and domned the city! Game over!");
        System.out.println(e.getMessage());
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenu();
        paramsNotOk = true;
    }
}while(paramsNotOk);
  }
  
  
  public static void setNewYearView() {
    boolean paramsNotOk;
    int year = 1;
    do {
        paramsNotOk = false;
        try{CropControl.setNewYear(year, theCropData);
        }
        catch (Exception e) {
        System.out.println("You have succesfully served your term as the governor and can now pursue for other positions in the Nephie government!");
        System.out.println(e.getMessage());
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenu();
        paramsNotOk = true;
      }
    }while(paramsNotOk);
  }

// The runCropsView method()
// Purpose: runs the City of Aron Game
// Parameters: none
// Returns: none
    public static void runCropsView() throws CropException {
        buyLandView();
        
        sellLandView();
    }
    
    

}
