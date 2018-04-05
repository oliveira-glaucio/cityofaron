    // The createMap method
    // Purpose: creates the location objects and the map
    // Parameters: none
    // Returns: none
    public static void createMap(){
        //create the Map object, it is 5 x 5
        //refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
        // define the string for a hills  location                      
       System.out.println("creating hills");
       String  hills= "\nYou are the hills. The hills are natural barrier and defense of the city." +
       "\nIt is also mined and provides much of resources used in the city." +
       "\nBeyond it lies the wilderness that belongs to the Lamanites..";
                       
       // set a hill location with a hint
        loc = new Location();       
        loc.setDescription(hills + "\nTwenty bushels of wheat can feed one person for a year.");
        loc.setSymbol("/\/\");
  
        //set this location object in each cell of the array in column 4
       for(int i = 0; i <  MAX_ROW; i++)
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
       theMap.setLocation(i, 3, loc);
       
       //create a string that will go in the Location objects
       //that contain the river
       String river = "\nYou are on the River. The river is the source" +
       "\nof life for our city. The river marks the eastern " +
       "\nboundary of the city - it is wilderness to the East.";
       //create a new Location object
       Location loc = new Location();
       //use setters in the Location class to set the description and symbol
       loc.setDescription(river + "\nWhile the city of Aaron enjoys year round summer, harvest may wary. Always maintain some wheat in store.");
       loc.setSymbol("~~~");  
       theMap.setLocation(i, 2, loc);
       
       
       //define the string for a port location
       System.out.println("creating port");
       String  port= "\nYou are at the river port." +
       "\nThe port is major trading center and source of much wealth of the city" +
       "\nHere the citisens of the city do much of their trade and bussiness with the outside world.";
       
        // set a port location with a hint
        loc = new Location();
        loc.setDescription(port + "\nBuy and sell land to acumulate aditional wheat. Be carefull not gable to much of wheat or people will starve!.");
        loc.setSymbol("$+$");
        theMap.setLocation(i, 1, loc);
        
        
        //define the string for a forest  location                        
        System.out.println("creating forest");
       String  forest= "\nYou are in the forest of Lehi" +
       "\nThe forest of Lehi is ancient and untainted." +
       "\nThe only mark of civilisation here is an equally  old road that connects the City of Nephi with the rest of Nephite city-states.";
        // set a forest location with a hint
       loc = new Location();
       loc.setDescription(forest + "\nAlways try to balance population growth and food surpluss. Never lose track of neither.");
       loc.setSymbol("^^^");
       theMap.setLocation(i, 0, loc);
       theGame.setTheMap(theMap);
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
        
        
        
        
