package cityofaron.model;

import java.io.Serializable;

/**
 *
 * @author glaucio
 */
public class Game implements Serializable{
    private Map theMap;
    private Player thePlayer;
    private int cropData;
    private int team;
    private int animals;
    private int tools;
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
