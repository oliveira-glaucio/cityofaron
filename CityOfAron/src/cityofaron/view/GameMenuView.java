
package cityofaron.view;

import cityofaron.MenuView;
import cityofaron.model.CropData;
import cityofaron.model.Game;
import java.util.Scanner;
import cityofaron.model.Player;

// The GameMenuView class - part of the view layer
// Author: Glaucio
// Date last modified: February 2018
//-------------------------------------------------------------
public class GameMenuView extends MenuView {
    private static Game theGame = null;
    private static Player thePlayer = null;
    
    
    // The MainMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================
    public GameMenuView() {
        super( "\n"
                + "**********************************\n"
                + "* CITY OF AARON: GAME MENU       *\n"
                + "**********************************\n"
                + " 1 - View the map\n"
                + " 2 - View/Print a list\n"
                + " 3 - Move to a new location\n"
                + " 4 - Manage the Crops\n"
                + " 5 - Return to the Main menu\n",5);
    }
    
    

    
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    @Override public void doAction(int option) {
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

    
}
