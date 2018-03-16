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
    
    public Map(int _rows, int _cols){        
        rowCount = _rows;
        colCount = _cols;
        
        locations = new Location[_rows][_cols];
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    
    public Location getLocation(int row, int col) {
        return locations[row][col];
    }

    public void setLocation(int row, int col, Location _location) {
        locations[row][col] = _location;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", colCount=" + colCount + ", locations=" + locations + '}';
    }
    
    
    
}
