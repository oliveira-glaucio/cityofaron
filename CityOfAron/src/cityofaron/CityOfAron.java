package cityofaron;

import cityofaron.model.CropData;
import cityofaron.model.Game;
import cityofaron.model.ListItem;
import cityofaron.model.Map;
import cityofaron.model.Player;
import cityofaron.model.TeamMember;
import java.util.ArrayList;


/**
 *
 * @author glaucio
 */
public class CityOfAron {
    public static void main(String[] args) {
        Game game = new Game();
        
        //Team Members
        TeamMember[] teamMembers = new TeamMember[2];

        teamMembers[0].setName("Mariazinha");
        teamMembers[0].setTitle("Domestica");
        
        teamMembers[1].setName("Pedrinho");
        teamMembers[1].setTitle("Lavrador");
        
                
        //creation of cropdata
        CropData cropData = new CropData();
        cropData.setYear(2018);
        cropData.setPopulation(1000);
        
        //creation of player1
        Player player1 = new Player();
        player1.setName("Joãozinho da Silva");

        //creation of the map
        Map map = new Map();         
        map.setColCount(300);
        map.setRowCount(200);
        
        
        //Defining Animals
        ArrayList<ListItem> animals = new ArrayList<ListItem>();
        animals.add(new ListItem("Dog",1));
        animals.add(new ListItem("Cat",2));       
                
        //Defining Tools
        ArrayList<ListItem> tools = new ArrayList<ListItem>();
        tools.add(new ListItem("Axe",12));
        tools.add(new ListItem("Shovel",2));       
           
        
        
        //assigning the play and the map to the game...
        game.setThePlayer(player1);
        game.setTheMap(map);
        game.setCropData(cropData);
        game.setTeam(teamMembers);
        game.setAnimals(animals);
        game.setTools(tools);
        
        //printing out the classes values        
        System.out.println(game.toString());
        System.out.println(teamMembers.toString());
        System.out.println(cropData.toString());
        System.out.println(animals.toString());
        System.out.println(tools.toString());
        System.out.println(map.toString());
        System.out.println(player1.toString());        
    }       
}
