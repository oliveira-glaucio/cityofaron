package cityofaron;

import cityofaron.model.CropData;
import cityofaron.model.Game;
import cityofaron.model.ListItem;
import cityofaron.model.Map;
import cityofaron.model.Player;
import cityofaron.model.TeamMember;
import java.util.ArrayList;
import cityofaron.view.*;
import java.util.Scanner;

/**
 *
 * @author glaucio
 */
public class CityOfAron {
    
    private static Game theGame = null;
    private static Player thePlayer = null;
    Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        CityOfAron city = new CityOfAron();
        city.startNewGame();
    }

    public void startNewGame() {
        
        theGame = new Game();
        thePlayer = new Player();
        
         // Display the Banner Page.
        System.out.println("\nWelcome to the city of Aaron.");
    
        // Prompt for and get the user’s name.
        String name;
        System.out.println("\nPlease type in your first name: ");
        name = keyboard.next();

        // Save the user’s name in the Player object
        thePlayer.setName(name);

        // Save a reference to the player object in the Game object
        theGame.setThePlayer(thePlayer);

        // Display a welcome message
        System.out.println("\nWelcome “ + name + “ have fun.");
        
        // Display the Game menu
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenuView();
 }
}
