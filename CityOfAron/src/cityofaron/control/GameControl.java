package cityofaron.control;

import java.util.ArrayList;
import cityofaron.CityOfAron;
import cityofaron.model.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author glaucio
 */
public class GameControl {

    // size of the Locations array
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;

    // reference to a Game object
    private static Game theGame;

    public static void createNewGame(String pName) {
        // Created the game object. Save it in the main driver file
        theGame = new Game();
        CityOfAron.setTheGame(theGame);

        // create the player object. Save it in the game object
        Player thePlayer = new Player();
        thePlayer.setName(pName);
        theGame.setThePlayer(thePlayer);

        createCropDataObject();
        createAnimalList();
        createToolList();
        createProvisionList();
        createMap();
    }

    public static void createCropDataObject() {
        CropData theCrops = new CropData();

        theCrops.setYear(0);
        theCrops.setPopulation(100);
        theCrops.setNewPeople(5);
        theCrops.setCropYield(3);
        theCrops.setNumberWhoDied(0);
        theCrops.setOffering(10);
        theCrops.setWheatInStore(2700);
        theCrops.setAcresOwned(1000);
        theCrops.setAcresPlanted(1000);
        theCrops.setHarvest(3000);
        theCrops.setOfferingBushels(300);
        theCrops.setAcresPlanted(1000);

        theGame.setCropData(theCrops);
    }

    public static void createAnimalList() {
        ArrayList<ListItem> animals = new ArrayList<ListItem>();

        animals.add(new ListItem("cows", 15));
        animals.add(new ListItem("horses", 2));
        animals.add(new ListItem("pigs", 9));
        animals.add(new ListItem("goats", 6));

        theGame.setAnimals(animals);
    }

    public static void createToolList() {
        ArrayList<ListItem> tools = new ArrayList<>();

        tools.add(new ListItem("Axe", 12));
        tools.add(new ListItem("Shovel", 7));
        tools.add(new ListItem("Hammer", 22));
        tools.add(new ListItem("Pitchfork", 12));

        theGame.setTools(tools);
    }

    public static void createProvisionList() {
        ArrayList<ListItem> provisions = new ArrayList<>();

        provisions.add(new ListItem("Water", 2));
        provisions.add(new ListItem("Meat", 8));
        provisions.add(new ListItem("Sleeping Bag", 12));
        provisions.add(new ListItem("Candle", 6));

        theGame.setProvisions(provisions);
    }

    // The createMap method
    // Purpose: creates the location objects and the map
    // Parameters: none
    // Returns: none
    public static void createMap() {
        //create the Map object, it is 5 x 5
        //refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);

        //River
        String riverDescription = "\nYou are on the River. The river is the source\nof life for our city. The river marks the eastern\nboundary of the city - it is wilderness to the East.";
        Location locRiver = new Location();
        locRiver.setDescription(riverDescription);
        locRiver.setSymbol("~~~");

        //Farmland/Wheat
        String farmlandDescription = "\nYou are on the fertile banks of the River.\nIn the springthis low farmland floods and is covered with rich\nnew soil. Wheat is planted as far as you can see.";
        Location locFarmLand = new Location();
        locFarmLand.setDescription(farmlandDescription);
        locFarmLand.setSymbol("!!!");

        //Village
        String villageDescription = "\nThis is a village inside the city of aron.";
        Location locVillage = new Location();
        locVillage.setDescription(villageDescription);
        locVillage.setSymbol("oOo");

        //Desert
        String desertDescription = "\nthis is a desert :o";
        Location locDesert = new Location();
        locVillage.setDescription(desertDescription);
        locVillage.setSymbol("...");

        //set this location object in each cell of the array in column 4      
        for (int i = 0; i < MAX_ROW; i++) {
            theMap.setLocation(i, 4, locRiver);
            theMap.setLocation(i, 3, locRiver);
            theMap.setLocation(i, 2, locRiver);

            if (i <= 2) {
                theMap.setLocation(i, 1, locVillage);
                theMap.setLocation(i, 0, locVillage);

            }

            if (i >= 2 && i <= 4) {
                theMap.setLocation(i, 1, locDesert);
                theMap.setLocation(i, 0, locDesert);
            }
        }

        theGame.setTheMap(theMap);
    }

    
    // the getSavedGame method
    // Purpose: load a saved game from disk
    // Parameters: the file path
    // Returns: none
    // Side Effect: the game reference in the driver is updated
    public static void getSavedGame(String filePath) {
        try (FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            theGame = (Game) input.readObject();
        } catch (Exception e) {
            System.out.println("\nOops :(\nSomething went wrong while reading the saved game file");
        }
    }

    // SaveGame method
    // Purpose: Save the Game to the disk
    // Parameters: the file path
    // Returns: none
    // Side Effect: the game reference in the driver is updated
    public static void SaveGame(String filePath) {
        //Game theGame = null;

        try (FileOutputStream fips = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fips);
            output.writeObject(theGame);
            output.flush();
        } catch (Exception e) {
            System.out.println("\nOops :(\nSomething went wrong while trying to save the game file.");
        }
    }

    
    public static void saveReportAnimals(String outputLocation) {
        ArrayList<ListItem> animals = theGame.getAnimals();
        try (PrintWriter out = new PrintWriter(outputLocation)) {
            out.println("\n\n **********Animal List Report**********");
            out.printf("%n%-10s%10s", "  Animal  ", "Quantity");
            out.printf("%n%-10s%10s", "**********", "**********");

            for (ListItem item : animals) {
                out.printf("%n%-10s%10d", item.getName(), item.getNumber());

            }
        } catch (Exception e) {
            System.out.println("Sorry there was an error.");
        }
    }
    
    
    public static void setPlayerPosition(int row, int col)
    {
        Player player = theGame.getThePlayer();
        
        if(player == null) return;
        
        player.setRowPosition(row);
        player.setColPosition(col);
    }
}
