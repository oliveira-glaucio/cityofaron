/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaron.view;

import cityofaron.MenuView;
import cityofaron.model.Game;
import cityofaron.model.ListItem;
import java.util.ArrayList;

/**
 *
 * @author glaucio
 */
public class ListView extends MenuView {
    
private static Game theGame = cityofaron.CityOfAron.getTheGame();
    
    public ListView(){
        super("\n" +
                   "**********************************\n" +
                   "* CITY OF AARON:      LIST MENU  *\n" +
                   "**********************************\n" +
                   " 1 - View the development team\n" +
                   " 2 - View a list of animals\n" +
                   " 3 - View a list of tools\n" +
                   " 4 - View a list of provisions\n" +
                   " 5 - Save a Report of provisions\n" +
                   " 6 - Save a Report of Animals\n" +
                   " 7 - Return to the game menu\n"
             , 7);
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
            case 1: // display the Devlopment Team
                viewDevelopmentTeam();
                break;
            case 2: // display a list of animals
                viewListOfAnimals();
                break;
            case 3: // display a list of tools
                viewListOfTools();
                break;
            case 4: // display a list of provisions
                viewListOfProvisions();
                break;
            case 5: // save a report of provisions
                saveReportProvisions();
                break;
            case 6: // save a report of animals
                saveReportAnimals();
                break;
            case 7: // return to the game menu
                break;
        }
    }
    
    
    public void viewDevelopmentTeam()
    {
        System.out.println("City of Aron\nA game brought to you by Arunas and Gláucio.\nHope you enjoy it!");
    }

    
    public void viewListOfAnimals()
    {
        System.out.println("List of Animals inside the game:\n\n");        
        ArrayList<ListItem> listOfAnimals = theGame.getAnimals();
        
        for(int i = 0; i < listOfAnimals.size(); i++ )
        {
            ListItem currentAnimal = listOfAnimals.get(i);  
            System.out.println("Animal: " + currentAnimal.getName() + ", Worth: " + currentAnimal.getNumber());
        }    
    }


    public void viewListOfTools()
    {
        System.out.println("List of Tools inside the game:\n\n");        
        ArrayList<ListItem> listOfTools = theGame.getTools();
        
        for(int i = 0; i < listOfTools.size(); i++ )
        {
            ListItem currentTool = listOfTools.get(i);  
            System.out.println("Tool: " + currentTool.getName() + ", Worth: " + currentTool.getNumber());
        }       
    }


    public void viewListOfProvisions()
    {
        System.out.println("List of Provisions inside the game:\n\n");        
        ArrayList<ListItem> listOfProvisions = theGame.getProvisions();
        
        for(int i = 0; i < listOfProvisions.size(); i++ )
        {
            ListItem currentProvision = listOfProvisions.get(i);  
            System.out.println("Provision: " + currentProvision.getName() + ", Worth: " + currentProvision.getNumber());
        }      
    }

    private void saveReportProvisions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*  //Please check if this is ok?
      private void saveReportAnimals() {
      String saveAnimals;
      System.out.println("\nPlease enther the name of your saved file.");
      keyboard.nextLine();
      saveAnimals = keyboard.nextLine();
      GameControl.saveReportAnimals(saveAnimal);.
    }
    */

}
