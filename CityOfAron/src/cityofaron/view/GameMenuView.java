
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

    // The viewList() method
    // Purpose: Creates a ViewList object and calls its
    //    displayMenuView ( ) method       
    // Parameters: none
    // Returns: none
    public void viewList()
    {
        ListView lv = new ListView();
        lv.displayMenu();                
    } 


    public void moveToNewLocation() {
        int rowPosition, colPosition;
        
        System.out.println("\nEnter the coordinates of the location you want to move to.\n");
        
        System.out.print("\nEnter the x-coordinate: ");
        colPosition = getNextValidInt(5) - 1;
        
        System.out.print("\nEnter the y-coordinate: ");
        rowPosition = getNextValidInt(5) - 1;
        
        cityofaron.control.GameControl.setPlayerPosition(rowPosition, colPosition);
        
        Game theGame = cityofaron.CityOfAron.getTheGame();
        
        String DescriptionLocation = theGame.getTheMap().getLocation(rowPosition, colPosition).getDescription();
        
        System.out.println("\n" + DescriptionLocation);
    }

    
    public int getNextValidInt(int maxValue){
        int inputValue = 0;
        do
        {
          inputValue = keyboard.nextInt();
          if(inputValue < 1 || inputValue > maxValue)
          {
              System.out.format("\nError: input value must be between 1 and " + maxValue + ". try again: ", max);
          }
        } while(inputValue < 1 || inputValue > maxValue);
        
        return inputValue;
    }
    
    public void manageCrops() {
        System.out.println("\nManage the Crops.");
    }
}
