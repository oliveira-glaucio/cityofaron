/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaron.control;

import java.util.ArrayList;
import cityofaron.CityOfAron;
import cityofaron.model.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWrite;// week-12

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
    
    public static void createNewGame(String pName)
    {
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

    public static void createCropDataObject()
    {
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

    public static void createAnimalList()
    {
        ArrayList<ListItem> animals = new ArrayList<ListItem>();
        
        animals.add(new ListItem("cows", 15));
        animals.add(new ListItem("horses", 2));
        animals.add(new ListItem("pigs", 9));
        animals.add(new ListItem("goats", 6));
       
        theGame.setAnimals(animals);
    }

    public static void createToolList()
    {
        ArrayList<ListItem> tools = new ArrayList<ListItem>();
        
        tools.add(new ListItem("Axe", 12));
        tools.add(new ListItem("Shovel", 7));
        tools.add(new ListItem("Hammer",22));
        tools.add(new ListItem("Pitchfork", 12));
       
        theGame.setTools(tools);
    }
        
    public static void createProvisionList()
    {
        ArrayList<ListItem> provisions = new ArrayList<ListItem>();
        
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
    public static void createMap(){
        //create the Map object, it is 5 x 5
        //refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);

       //create a string that will go in the Location objects
       //that contain the river
       String river = "\nYou are on the River. The river is the source" +
       "\nof life for our city. The river marks the eastern " +
       "\nboundary of the city - it is wilderness to the East.";

       //create a new Location object
       Location loc = new Location();

       //use setters in the Location class to set the description and symbol
       loc.setDescription(river);
       loc.setSymbol("~~~");  

       //set this location object in each cell of the array in column 4      
       for(int i = 0; i < MAX_ROW; i++)
       {
           theMap.setLocation(i, 4, loc);
       }

       //define the string for a farm land location
       String farmland = "\nYou are on the fertile banks of the River." +
       "\nIn the springthis low farmland floods and is covered with rich" +
       "\nnew soil. Wheat is planted as far as you can see."; 

       //set a farmland location with a hint
       loc = new Location();
       loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
       loc.setSymbol("!!!");
        
        //set this location object in each cell of the array in column 2
        //theMap.setLocation(i , 2, loc);

       //Put the other locations here (TODO / UPDATE this function...)
        
        /*
                   //define the string for a port location
       System.out.println("creating port");
       String  port= "\nYou are at the river port." +
       "\nThe port is major trading center and source of much wealth of the city" +
       "\nHere the citisens of the city do much of their trade and bussiness with the outside world.";
       
        // set a port location with a hint
        loc = new Location();
        loc.setDescription(port + "\nBuy and sell land to acumulate aditional wheat. Be carefull not gable to much of wheat or people will starve!.");
        loc.setSymbol("$+$");
        theMap.setLocation(i, 2, loc);
        
               //define the string for a court location
       System.out.println("creating court");
       String  hall= "\nYou are at the city court." +
       "\nThe city court serves as your court and is a seat of local government." +
       "\nHere decisions to sell or buy new land are made and provision for a year are planed.";
       
        // set a hall location with a hint
        loc = new Location();
        loc.setDescription(port + "\nBuy and sell land to acumulate aditional wheat. Be carefull not gable to much of wheat or people will starve!.");
        loc.setSymbol("$+$");
        theMap.setLocation(i, 1, loc);
        
       //define the string for a court location
       System.out.println("creating Temple");
       String  hall= "\nYou are at the city Temple." +
       "\nYou are in the main temple of the city which located in the city center." +
       "\nThe temple is a sacred place of Worship and is the House of the lord.";
       
        // set a temple location with a hint
        loc = new Location();
        loc.setDescription(port + "\nAlways remember to pay tithing!");
        loc.setSymbol("$+$");
        theMap.setLocation(i, 0, loc);
        
        
 */
        
       
       theGame.setTheMap(theMap);
    }
    
    
    // the getSavedGame method
    // Purpose: load a saved game from disk
    // Parameters: the file path
    // Returns: none
    // Side Effect: the game reference in the driver is updated
    public static void getSavedGame(String filePath)
    {       
        try (FileInputStream fips = new FileInputStream(filePath))
        {
            ObjectInputStream input = new ObjectInputStream(fips);
            theGame = (Game)  input.readObject();
        }
        catch(Exception e)
        {
            System.out.println("\nOops :(\nSomething went wrong while reading the saved game file");
        }
    }   
    
    
    // SaveGame method
    // Purpose: Save the Game to the disk
    // Parameters: the file path
    // Returns: none
    // Side Effect: the game reference in the driver is updated
    public static void SaveGame(String filePath)
    {
        //Game theGame = null;
        
        try (FileOutputStream fips = new FileOutputStream(filePath))
        {
            ObjectOutputStream output = new ObjectOutputStream(fips);
            output.writeObject(theGame);
            output.flush();
        }
        catch(Exception e)
        {
            System.out.println("\nOops :(\nSomething went wrong while trying to save the game file.");
        }
    }   
    
    
      public static void saveReportAnimals(String outputLocation)  {
      
      ArrayList<ListItem> animals = theGame.getAnimals();
      try (PrintWriter out = new PrintWriter(outputLocation)) 
   {
      out.println("\n\n **********Animal List Report**********");
      out.printf("%n%-10s%10s","  Animal  ","Quantity");
      out.printf("%n%-10s%10s","**********","**********");
      
          for (ListItem item : animals) {
      out.printf("%n%-10s%10d", item.getName(), item.getNumber());
      
      }
      } catch (Exception e) {
          System.out.println("Sorry there was an error.");
      }
  }
}
