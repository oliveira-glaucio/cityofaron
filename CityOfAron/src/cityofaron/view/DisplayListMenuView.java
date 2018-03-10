    package cityofaron.view;

import cityofaron.MenuView;
import cityofaron.model.Game;
import java.util.Scanner;
import cityofaron.model.Player;

/*The ListMenuView class - part of the view layer
 * Object: Manage the list menu
 * @author Arunas Rancevas
 * Date last modified: February 2018
 */

public class ListMenuView extends MenuView{
    

public ListMenuView(){
    //Display the menu
    //Prompt user and get user's input
    //Perform the desired action
    //determine and display the next view
    
        super("\n"
                + "**********************************\n"
                + "* CITY OF AARON: LIST MENU   *\n"
                + "**********************************\n"
                + " 1 - List or View the animals in the storehouse\n"
                + " 2 - List or View the tools in the storehouse\n"
                + " 3 - List or View the provisions in the storehouse\n"
                + " 4 - List or View the authors of this game\n"
                + " 5 - Return to the Main Menu\n"
                ,5);        
    }
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ==================================
@Override public void doAction(int option){
    switch (option) {
      case 1: // display Animals List
        displayAnimalsList();
        break;
      case 2:// display Tools list
        displayToolsList();
        break;
      case 3: // display Provisions list
        displayProvisionsList();
        break;
      case 4: // display the Authors list
        displayAuthorsList();
        break;
       case 6: // back to main menu
         break;
        
    }
  }
   // The displayAnimalsList method
    // Purpose: Displays a list of Animals
    // Parameters: none
    // Returns: none
    // ===================================
 public void displayAnimalsList(){
    System.out.println("\n *Displays Animals List*");
  }
   // The displayToolsList method
    // Purpose: Displays a list of Tools
    // Parameters: none
    // Returns: none
    // ===================================
 public void displayToolsList(){
    System.out.println("\n *Displays a List of Tools*");
  }
   // The displayProvisionsList method
    // Purpose: Displays a list of Provision
    // Parameters: none
    // Returns: none
    // ===================================
 public void displayProvisionsList(){
    System.out.println("\n *Displays Provision List*.");
  }
     // The displayAuthorsList method
    // Purpose: Displays a list of Authors
    // Parameters: none
    // Returns: none
    // =================================== 
 public void displayAuthorsList(){
    System.out.println("\n *Displays a List of Authors*");
  }
}
