package cityofaron.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author glaucio
 */
public class Game implements Serializable{
    private Map theMap;
    private Player thePlayer;
    private CropData cropData;
    private TeamMember[] team;
    private ArrayList<ListItem> animals;
    private ArrayList<ListItem> tools;
    private ListItem provisions;
    
    
    public Game(){
        
    }

    public Map getTheMap() {
        return theMap;
    }

    public void setTheMap(Map theMap) {
        this.theMap = theMap;
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
}
