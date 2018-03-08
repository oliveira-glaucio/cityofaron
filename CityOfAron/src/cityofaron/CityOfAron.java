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

    Scanner keyboard = new Scanner(System.in);

    public static Game getTheGame() {
        return theGame;
    }

    public static void setTheGame(Game theGame) {
        CityOfAron.theGame = theGame;
    }
    private static Game theGame;
    
    public static void main(String[] args) {    
        MainMenuView mmv = new MainMenuView();

        mmv.displayMenu();
    }
}