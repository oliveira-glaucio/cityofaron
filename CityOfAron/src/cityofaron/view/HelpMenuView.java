    package cityofaron.view;

import cityofaron.model.Game;
import java.util.Scanner;
import cityofaron.model.Player;

// The HelpMenuView class - part of the view layer
// Object of this class manage the help menu
// Author: Arunas
// Date last modified: February 2018
//-------------------------------------------------------------
public class HelpMenuView {
/*    private static Game theGame = null;
    private static Player thePlayer = null;
    private String mainMenu;
    private int max;

    Scanner keyboard = new Scanner(System.in);
    
    
    // The HelpMenuView constructor
    // Purpose: Initialize the help menu data
    // Parameters: none
    // Returns: none
    // ===================================
    public HelpMenuView() {
        helpMenu = "\n"
                + "**********************************\n"
                + "* CITY OF AARON: Help Menu  *\n"
                + "**********************************\n"
                + " 1 - What are the goals of the game?\n"
                + " 2 - Where is the city of Aaron?\n"
                + " 3 - How do I view the map?\n"
                + " 4 - How do I move to another location?\n"
                + " 5 - How do I display a list of animals, provisions and tools in the city storehouse?"
                + " 6 - Back to the Main Menu.\n";
        max = 6;
    }
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
            // Display the menu
            System.out.println(mainMenu);

            // Prompt the user and get the user’s input
            menuOption = getMenuOption();

            // Perform the desired action
            doAction(menuOption);

            // Determine and display the next view
        } while (menuOption != max);
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
        
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    public void doAction(int option)
    {
        switch(option) {
            case 1: // display goals of the game
                displayGameGoals();
                break;
            case 2: // display where the city of Aaron is
                displayLocation();
                break;
            case 3: // display how view map
                displayMap();
                break;
            case 4: // display how to move to another location
                displayMove();
                break;
            case 5: // display animals, provisions, and tools in storehouse
                displayWheatInStore();
                break;
            case 6: // back to main menu
                break;
        }
 

    
    }
    // The displayHelpGoalsOfGame method
    // Purpose: displays the goals of the game
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayGameGoals()
    {
        System.out.println("*Game goals*");
    }
    // The displayHelpWhere method
    // Purpose: displays where the city of Aaron is loacted
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayLocation()
    {
        System.out.println("*Location*");
    }
    // The displayHelpViewMap method
    // Purpose: displays the goals of the game
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayMap()
    {
        System.out.println("*Map*");
    }
    // The displayHelpMoveLocation method
    // Purpose: explains how to move to another location
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayMove()
    {
        System.out.println("*Move to another location*.");
    }
    // The displayHelpWhatInStorehouse method
    // Purpose: Shows resources
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayWheatInStore()
    {
        System.out.println("*Animals, Provisions, and Tools*.");
    }
  }
*/
}
