package cityofaron.model;

import java.io.Serializable;

/**
 *
 * @author glaucio
 */
public class Map implements Serializable{
    private int rowCount;
    private int colCount;
    private Location[][] locations;
    
    public Map(){        
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
    
    
}
