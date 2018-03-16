/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaron.view;

import cityofaron.MenuView;

/**
 *
 * @author glaucio
 */
public class ListView extends MenuView {
    
    
    public ListView() {
        super("\n" +
                   "**********************************\n" +
                   "* CITY OF AARON:      LIST MENU  *\n" +
                   "**********************************\n" +
                   " 1 - View the development team\n" +
                   " 2 - View a list of animals\n" +
                   " 3 - View a list of tools\n" +
                   " 4 - View a list of provisions\n" +
                   " 5 - Return to the game menu\n"
             , 5);
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
            case 5: // return to the game menu
                break;
        }
    }
    
    
    public void viewDevelopmentTeam()
    {
        System.out.println("City of Aron\nA game brought to you by Arunas and Gláucio.\nHope you enjoy it!");
    }

    
    public void viewListOfAnimals()
    {
        System.out.println("*Location*");
    }

    public void viewListOfTools()
    {
        System.out.println("*Location*");
    }

    public void viewListOfProvisions()
    {
        System.out.println("*Location*");
    }    
}
