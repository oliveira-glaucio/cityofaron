    package cityofaron.view;

import cityofaron.model.Game;
import java.util.Scanner;
import cityofaron.model.Player;

// The HelpMenuView class - part of the view layer
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
    
    
    // The HelpMenuView constructor
    // Purpose: Initialize the feed people data
    // Parameters: none
    // Returns: none
    // ===================================
    public HelpMenuView() {
        helpMenu = "\n"
                + "**********************************\n"
                + "* CITY OF AARON: Help Menu  *\n"
                + "**********************************\n"
                + " 1 - Option #1"
                + " 2 - Option #2n"
                + " 3 - Option #3n"
                + " 4 - Option #4\n"
                + " 5 - Option #5\n"
                + " 6 - Menu\n";
        max = 6;
    }
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
      //The doAction method
      //Purpose: performs the selection action
      //Parameters: none
      //Returns: none
      // =========================================================

  public void doAction(int option){
    switch (option) {
        //if the option is 1
      case 1: System.out.println("\n Message #1.");
        break;
        //if the option is 2
      case 2: System.out.println("\n Message #2.");
        break;
        //if the option is 3
      case 3: System.out.println("\n Message #3.");
        break;
        //if the option is 4
      case 4: System.out.println("\n Message #4.");
        break;
        //if option is 5, 
      case 5: System.out.println("\n Message #5.");
        break;
        //if option is 6, return to Main Menu
      case 6: System.out.println("\n Message #6.");
          MainMenuView mainMenuView = new MainMenuView();
          mainMenuView.displayMenuView();
                break;
    }
  }


}
