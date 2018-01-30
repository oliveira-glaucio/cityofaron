package cityofaron;

import cityofaron.model.Game;
import cityofaron.model.Map;
import cityofaron.model.Player;


/**
 *
 * @author glaucio
 */
public class CityOfAron {
    public static void main(String[] args) {
        Game game = new Game();
     
       
        //creation of player1
        Player player1 = new Player();
        player1.setName("Joãozinho da Silva");

        //creation of the map
        Map map = new Map();         
        map.setColCount(300);
        map.setRowCount(200);
        
        
        //assigning the play and the map to the game...
        game.setThePlayer(player1);
        game.setTheMap(map);
        
        
        
        //printing out the classes values        
        System.out.println(game.toString());
        System.out.println(map.toString());
        System.out.println(player1.toString());        
    }       
}
