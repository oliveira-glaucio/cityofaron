
package cityofaron.view;

import cityofaron.model.CropData;
import cityofaron.model.Game;
import java.util.Scanner;
import cityofaron.model.Player;

// The GameMenuView class - part of the view layer
// Author: Glaucio
// Date last modified: February 2018
//-------------------------------------------------------------
public class GameMenuView {
    private static Game theGame = null;
    private static Player thePlayer = null;
    private String gameMenu;
    private int max;

    Scanner keyboard = new Scanner(System.in);
    
    
    // The MainMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================
    public GameMenuView() {
        gameMenu = "\n"
                + "**********************************\n"
                + "* CITY OF AARON: GAME MENU       *\n"
                + "**********************************\n"
                + " 1 - View the map\n"
                + " 2 - View/Print a list\n"
                + " 3 - Move to a new location\n"
                + " 4 - Manage the Crops\n"
                + " 5 - Return to the Main menu\n";
        max = 5;
    }
    
    
    // The displayMenuView method
    // Purpose: displays the menu, gets the user's input, and does the 
    // selected action
    // Parameters: none
    // Returns: none
    // =========================================================
    public void displayMenuView() {
        int menuOption;
        do {
            // Display the game menu
            System.out.println(gameMenu);

            // Prompt the user and get the user’s input
            menuOption = getMenuOption();

            // Perform the desired action
            doAction(menuOption);

            // Determine and display the next view
        } while (menuOption != max);
    }

    
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    public void doAction(int option) {
        switch (option) {
            case 1: // View the map
                viewMap();
                break;
            case 2: // View/Print a list
                viewList();
                break;
            case 3: // Move to a new location
                moveToNewLocation();
                break;
            case 4: // Manage the Crops
                manageCrops();
                break;
            case 5:
                System.out.println("\nReturn to main menu.");
        }
    }

    
    
    // The viewMap method
    // Purpose: display the map
    // Parameters: none
    // Returns: none
    // ===================================     
    public void viewMap() {
        System.out.println("\nDisplay a map of the City of Aron.");
 }

    public void viewList() {
        System.out.println("\nPrint a List.");
    }

    public void moveToNewLocation() {
        System.out.println("\n Move to a new location.");
    }

    public void manageCrops() {
        System.out.println("\nManage the Crops.");
    }

    
    // The getMenuOption method
    // Purpose: gets the user's input
    // Parameters: none
    // Returns: integer - the option selected
    // ===================================       
    public int getMenuOption() {
        // declare a variable to hold user’s input
        int userInput;

        // begin loop
        do {
            // get user input from the keyboard
            userInput = keyboard.nextInt();

            // if it is not a valid value, output an error message
            if (userInput < 1 || userInput > max) {
                System.out.println("\noption must be between 1 and " + max);
            }

            // go back to the top of the loop if input was not valid
        } while (userInput < 1 || userInput > max);

        // return the value input by the user
        return userInput;
    }          
}
