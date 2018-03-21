    package cityofaron.view;

import cityofaron.MenuView;
import cityofaron.model.Game;
import java.util.Scanner;
import cityofaron.model.Player;

// The HelpMenuView class - part of the view layer
// Object of this class manage the help menu
// Author: Arunas
// Date last modified: February 2018
//-------------------------------------------------------------
public class HelpMenuView extends MenuView {
     
    // The HelpMenuView constructor
    // Purpose: Initialize the help menu data
    // Parameters: none
    // Returns: none
    // ===================================
    public HelpMenuView() {
        super("\n"
                + "**********************************\n"
                + "* CITY OF AARON: Help Menu  *\n"
                + "**********************************\n"
                + " 1 - What are the goals of the game?\n"
                + " 2 - Where is the city of Aaron?\n"
                + " 3 - How do I view the map?\n"
                + " 4 - How do I move to another location?\n"
                + " 5 - How do I display a list of animals, provisions and tools in the city storehouse?"
                + " 6 - Back to the Main Menu.\n"
                ,6);        
    }


    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    @Override
    public void doAction(int option)
    {
        switch(option) {
            case 1: // display goals of the game
                displayGameGoals();
                break;
            case 2: // display where the city of Aaron is
                displayLocation();
                break;
            case 3: // display how to view map
                displayMapHelp();
                break;
            case 4: // display how to move to another location
                displayMoveHelp();
                break;
            case 5: // display animals, provisions, and tools in storehouse
                displayResources();
                break;
            case 6: // back to main menu
                break;
        }
 

    
    }
    // The displayGameGoals method
    // Purpose: displays the goals of the game
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayGameGoals()
    {
        System.out.println("*Game goals*");
    }
    
    // The displayLocation method
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
    public void displayMapHelp()
    {
        System.out.println("*How to view the Map*");
    }
    
    // The displayHelpMoveLocation method
    // Purpose: explains how to move to another location
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayMoveHelp()
    {
        System.out.println("*Move to another location*.");
    }
    // The displayHelpWhatInStorehouse method
    // Purpose: Shows resources
    // Parameters: none
    // Returns: none
    // ===================================   
    public void displayResources()
    {
        System.out.println("*Animals, Provisions, and Tools*.");
    }
  }
