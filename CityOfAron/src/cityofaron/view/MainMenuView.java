package cityofaron.view;

import cityofaron.MenuView;
import cityofaron.model.CropData;
import cityofaron.model.Game;
import java.util.Scanner;
import cityofaron.model.Player;

// The MainMenuView class - part of the view layer
// Object of this class manage the main menu
// Author: Eric, Arunas, Glaucio, Mario
// Date last modified: February 2018
//-------------------------------------------------------------
public class MainMenuView extends MenuView {
    private static Game theGame = null;
    private static Player thePlayer = null;
    

    // The MainMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================
    public MainMenuView() {
        super("\n"
                + "**********************************\n"
                + "* CITY OF AARON: MAIN GAME MENU  *\n"
                + "**********************************\n"
                + " 1 - Start new game\n"
                + " 2 - Get and start a saved game\n"
                + " 3 - Get help on playing the game\n"
                + " 4 - Save game\n"
                + " 5 - Quit\n",
                5);
    }
    
  
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================    
    @Override
    public void doAction(int option) {
        switch (option) {
            case 1: // create and start a new game
                startNewGame();
                break;
            case 2: // get and start a saved game
                startSavedGame();
                break;
            case 3: // get help menu
                displayHelpMenuView();
                break;
            case 4: // save game
                displaySaveGameView();
                break;
            case 5:
                System.out.println("Thanks for playing ... goodbye.");
        }
    }

    
    
    // The startNewGame method
    // Purpose: creates game object and starts the game
    // Parameters: none
    // Returns: none
    // ===================================     
    public void startNewGame() {
        
        // Show banner page
        System.out.println(
            "\n********************************************************\n" +
            "* Welcome to the City of Aaron. You have been summoned *\n" +
            "* by the High Priest to assume your role as ruler of   *\n" +
            "* the city. Your responsibility is to buy land, sell   *\n" +
            "* land, determine how much wheat to plant each year,   *\n" +
            "* and how much to set aside to feed the people. You     *\n" +
            "* will also be required to pay an annual tithe on the  *\n" +
            "* that is harvested. If you fail to provide      *\n" +
            "* enough wheat for the people to eat, people will die  *\n" +
            "* and your workforce will be diminished. Plan very     *\n" +
            "* carefully or you may find yourself in trouble with   *\n" +
            "* the people. And oh, watch out for plagues and rats!  *\n" +
            "********************************************************\n");
            
            
        CropData cropData = createCropData();
        
        theGame = new Game();
        thePlayer = new Player();
    
        //Prompt for and get the user's name.
        String name;
        System.out.println("\nPlease type in your first name: ");
        name = keyboard.next();

        // Save the user's name in the Player object
        thePlayer.setName(name);

        // Save a reference to the player object in the Game object
        theGame.setThePlayer(thePlayer);

        // Save a reference of a new cropData;
        theGame.setCropData(cropData);
        
        
        // Welcome message
        System.out.println("\nWelcome " + name + " have fun, during your Journey!");
        
        //cityofaron.CityOfAron.createNewGame(name);
                
        // Display the Game menu      
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
 }

    public void startSavedGame() {
        System.out.println("\nStart saved Game.");
    }

    public void displayHelpMenuView() {
        System.out.println("\nHelp Menu.");
    }

    public void displaySaveGameView() {
        System.out.println("\nSave game.");
    }

    
    
    private CropData createCropData() {
        //Create the CropData object, 
        // initialize it and save a reference to it in the Game
        CropData theCrops = new CropData();
        theCrops.setYear(0);
        theCrops.setPopulation(100);
        theCrops.setNewPeople(5);
        theCrops.setCropYield(3);
        theCrops.setNumberWhoDied(0);
        theCrops.setOffering(10);
        theCrops.setWheatInStore(2700);
        theCrops.setAcresOwned(1000);
        theCrops.setAcresPlanted(1000);
        theCrops.setHarvest(3000);
        theCrops.setOfferingBushels(300);
        theCrops.setAcresPlanted(1000); 
        
        return theCrops;
    }
        
}
