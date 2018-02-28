
package cityofaron.view;

import cityofaron.model.Game;
import java.util.Scanner;
import cityofaron.model.Player;

// The feedPeopleView class - part of the view layer
// Object of this class manage the feed people menu
// Author: Arunas
// Date last modified: February 2018
//-------------------------------------------------------------
public class feedPeopleView {
    private static Game theGame = null;
    private static Player thePlayer = null;
    private String mainMenu;
    private int max;

    Scanner keyboard = new Scanner(System.in);
    
    
    // The MainMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================
    public MainMenuView() {
        mainMenu = "\n"
                + "**********************************\n"
                + "* CITY OF AARON: Feed People Menu  *\n"
                + "**********************************\n"
                + " 1 - Start new game\n"
                + " 2 - Get and start a saved game\n"
                + " 3 - Get help on playing the game\n"
                + " 4 - Save game\n"
                + " 5 - Quit\n";
        max = 5;
    }
    
    
    // The feedPeopleView method
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

    
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
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
        
        theGame = new Game();
        thePlayer = new Player();
        
         // Display the Banner Page.
        System.out.println("\nWelcome to the city of Aaron.");
    
        // Prompt for and get the user’s name.
        String name;
        System.out.println("\nPlease type in your first name: ");
        name = keyboard.next();

        // Save the user's name in the Player object
        thePlayer.setName(name);

        // Save a reference to the player object in the Game object
        theGame.setThePlayer(thePlayer);

        // Display a welcome message
        System.out.println("\nWelcome " + name + " have fun.");
        
        // Display the Game menu
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenuView();
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
