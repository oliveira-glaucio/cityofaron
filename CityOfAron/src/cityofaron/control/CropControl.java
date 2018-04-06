package cityofaron.control;

import cityofaron.exceptions.CropException;
import cityofaron.model.CropData;
import java.util.Random;

/**
 *
 * @author glaucio
 */
public class CropControl {

// constants
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;

    private static Random random = new Random();
    private static CropData cropData;

    public CropControl(CropData cropData) {
        setCropData(cropData);
    }

// The sellLand method
// Purpose: To sell land
// Parameters: the price of land, the number of acres to sell, and a 
// reference to a CropData object
// Returns: the acres owned after the sale
// Pre-conditions: acres to sell must be positive
// and <= acresOwned
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException {
        //if acresToSell < 0, return -1
        if (acresToSell < 0) {
        throw new CropException("Unofrtunetly, you do not own any land at this momment. Please buy some and then try to sell later.");
        }

        //if acresToSell > acresOwned, return -1
        int owned = cropData.getAcresOwned();
        if (acresToSell > owned) {
        throw new CropException("You are trying to sell more land than you currentlu have,only banks exhibit this type of behaviour. Please insert smaller number");

        }

        //acresOwned = acresOwned - acresToSell
        owned -= acresToSell;
        cropData.setAcresOwned(owned);

        //wheatInStore = wheatInStore + acresToSell * landPrice
        int wheat = cropData.getWheatInStore();
        wheat *= (acresToSell * landPrice);

        cropData.setWheatInStore(wheat);

        //return acresOwned
        return owned;
    }

// calcLandCost() method
// Purpose: Calculate a random land cost between 17 and 26 bushels/acre
// Parameters: none
// Returns: the land cost
    public static int calcLandCost() {
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;
        return landPrice;
    }

    /**
     * Returns a pseudo-random number between min and max, inclusive. The
     * difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value. Must be greater than min.
     * @return Integer between min and max, inclusive.
     */
    public static int randInt(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = random.nextInt((max - min) + 1) + min;

        return randomNum;
    }

//The calcEatenByRats method
//Purpose: to calculate the amount of wheat eaten by rats during a year.
//Parameters: none
//Returns: must return a positive value with the number of wheat eaten by rats. Returns 0 if no wheat were eaten.
//Pre-conditions: wheat in store must be positive; 
    public static int calcEatenByRats() {
        int wheatEatenByRats = 0;

//If wheatInStore = 0 then, return -1
        if (cropData.getWheatInStore() == 0) {
            return -1;
        }

//randomValue = get random value between 1 and 100
        int randomValue = randInt(1, 100);

//if randomValue > 30 then wheatEatenByRats = 0, return 0
        if (randomValue > 30) {
            return 0;
        }

//if offeringPercentage > 12
//    wheatEatenByRats = get random value between 3 and 5 of wheat in store
        if (cropData.getOffering() > 12) {
            wheatEatenByRats = (int) ((randInt(3, 5) / 100.0) * cropData.getWheatInStore());
        } //else if offeringPercentage >= 8 and offeringPercentage <= 12
        //    wheatEatenByRats = get random value between 3 and 7 of wheat in store
        else if (cropData.getOffering() >= 8 && cropData.getOffering() <= 12) {
            wheatEatenByRats = (int) ((randInt(3, 7) / 100.0) * cropData.getWheatInStore());
        } //else if offeringPercentage < 8
        //    wheatEatenByRats = get random value between 6 and 10 of wheat in store
        else if (cropData.getOffering() < 8) {
            wheatEatenByRats = (int) ((randInt(6, 10) / 100.0) * cropData.getWheatInStore());
        }
//wheatInStore = wheatInStore - wheatEatenByRats
        cropData.setWheatInStore(cropData.getWheatInStore() - wheatEatenByRats);
//return wheatEatenByRats

        return wheatEatenByRats;

    }

//The growPopulation method
//Purpose: to calculate the amount to grow the population during a year.
//Parameters: none
//Returns: must return a positive value and > 0.
//Pre-conditions: people living in the city must be positive; 
    public static int growPopulation() {

//If populationInCity = 0, return 0
        if (cropData.getPopulation() == 0) {
            return 0;
        }

//randomValue = get random value between 1 and 5
        int randomValue = randInt(1, 5);

//peopleMovedToTheCity = (randomValue / 100) * populationInCity
        int peopleMovedToTheCity = (int) ((randomValue / 100.0) * cropData.getPopulation());
        cropData.setPopulation(cropData.getPopulation() + peopleMovedToTheCity);

//return peopleMovedToTheCity  
        return peopleMovedToTheCity;
    }

//The calcStarved method
//Purpose: to calculate the amount of people who starved during a year.
//Parameters: none
//Returns: must return a positive value with the number of people who starved. Returns 0 if no people starved.
//Pre-conditions: people in the city must be positive; 
    public static int calcStarved() throws CropException{

        //peopleAdequatelyFed = wheatSeparatedForFood * 20
        int peopleFed = cropData.getWheatForPeople() * 20;

        //peopleStarved = 0
        int peopleStarved = 0;

        //if peopleAdequatelyFed < populationInCity
        //   peopleStarved = populationInCity – peopleAdequatelyFed
        //   populationInCity = populationInCity – peopleStarved
        if (peopleFed < cropData.getPopulation()) {
            peopleStarved = cropData.getPopulation() - peopleFed;
        }
      // As part of week-13 added function what would happen if people would starve to death
        if (cropData.getPopulation() * .50 < peopleStarved) throw new CropException
            ("Your actions have cost the lives of your people! You have coused femine and the city has perished! Game over.");
      
        cropData.setPopulation(cropData.getPopulation() - peopleStarved);

        //return peopleStarved 
        return peopleStarved;
    }

    public static CropData getCropData() {
        return cropData;
    }

    public static void setCropData(CropData cropData) {
        CropControl.cropData = cropData;
    }

// The feedPeople method
// Purpose: To feed the people
// Parameters: Wheat Allocated
// Returns: Wheat Stored.
// Pre-conditions: Wheat must be positive, and cannot exceed the amount that is stored
    public static int feedPeople(CropData cropData, int wheatAllocated) throws CropException{
        // if wheatInStore < 0, return -1
        int wheatInStore = cropData.getWheatInStore();
        if (wheatInStore < 0) {
            throw new CropException("Unofrtunetly, your wheat reserves are empty!");
        }
        
        //if wheatAllocated > wheatInStore,  return -1
        if (wheatAllocated > wheatInStore) {
            throw new CropException("You do not have that much  wheat in store to allocate. Please insert smaller number.");
        }
          //if wheatAllocated > -1,  return -1
        if(wheatAllocated <= -1) {
            throw new CropException("You are trying to allocate a negative number of wheat, which is impossible. Please type in positive number.");
        }
        // wheatInStore = wheatInStore– wheatAllocated
        wheatInStore = wheatInStore - wheatAllocated;
        //return wheatInStore
        return wheatInStore;
    }

// The buylLand method
// Purpose: To buy land
// Parameters: the price of land and the number of acres to buy
// Returns: the acres of owned land
// Pre-conditions: acres to buy must be positive, but cannot exceed Bushels Of Wheat that is had at the moment.
    public static int buyLand(int acresToBuy, CropData cropData, int landPrice, int workers) throws CropException {
        int acresOwned = cropData.getAcresOwned();
        int wheatInStore = cropData.getWheatInStore();
        //if acresToBuy < 0, return -1
        if (acresToBuy < 0) {
            throw new CropException("A negative value was input. Please insert possitive number.");
        }
        //if wheatInStore < landPrice, return -1
        if (wheatInStore < landPrice) {
            throw new CropException("The price of land cannot be greater than ammount of wheat in store. Please insert smaller number");
        }
        //if workers < (acresOwned / 10)
        if (workers < (acresOwned / 10)) {
            throw new CropException("There is not enought workers to work on that much land. Please insert smaller number");
        }
        //if acresToBuy * landPrice > wheatInStore, return -1
        if (acresToBuy * landPrice > wheatInStore) {
            throw new CropException("There is not enought wheat in store to buy this ammount of land. Please insert smaller number");
        }
        //wheatInStore = wheatInStore - (acresToBuy * landPrice)
        wheatInStore = wheatInStore - (acresToBuy * landPrice);
        //acresOwned = acresOwned + acresToBuy
        acresOwned = acresOwned + acresToBuy;
        //return acresOwned
        return acresOwned;
    }
    
    
// The plantCrops method.
// Purpose: plant the crops.
// Parameters: the number of acres of land that the player wants to plant.
// Returns: must return a positive number. Returns the remaining number
// of wheat in store. If there's an error, an exception is throw.
// Pre-conditions: number of wheat in store and acres must be enough for 
// user to plant the crops.
    
    public int plantCrops(int acresToPlant,int acresOwned, int wheatInStore, CropData cropData) throws CropException {

    //If acresToPlant > acresOwned then, return -1
    int owned = cropData.getAcresOwned();
    if(acresToPlant > acresOwned)
        throw new CropException("The amount of acres to plant can't be higher then the acres owned.");
    
    //Also, if acresToPlant > wheatInStore then, return -1
        owned = cropData.getWheatInStore();
        if(acresToPlant > wheatInStore) 
            throw new CropException("the amount of acres to plant can't be higher then the wheats in store.");
        
    //return acresOwned
    return acresOwned;

}
    
    // The payOffering method.
    // Purpose: to subtract the value paid from user's storage.
    // Parameters: the percentage of harvest paid.
    // Returns: '0' if it's a valid value OR '-1' if it's an invalid value
    // Pre-conditions: Offering percentage must be between 0 and 100
    
    public int payOffering(int wheatInStore, int offeringAmount, CropData cropData) throws CropException {
        //If payOffering < 0, then return -1
        
        if(cropData.getOffering() < 0)
            throw new CropException("The percentage of offering must be positive.");
        //If payOffering > 100, then return -1
        if(cropData.getOffering() > 100)
            throw new CropException("The percentage of offering cannot be higher then 100%.");
        
        //wheatInStore - offeringAmount
        cropData.setOffering(cropData.getWheatInStore() - offeringAmount);
        
        //Return wheatInStore
        return wheatInStore;
}
    // The setYewYear method
    // Purpose: To advance year and ens game if and when the 10 years have passed
    // Parameters: none
    // Returns: The new/curent year
    // Pre-conditions: none
public static int setNewYear(int year, CropData cropData) throws Exception{
   int newyear = cropData.getYear();
    if (year <= 10) {
        newyear = year + 1;
        cropData.setYear(newyear);
        return newyear;
    }
    if (newyear > 10) throw new Exception
    ("You have sucesfully governed your people for 10 years your term as the governor has come to an end.Continue as wisely in your future enedeviours! Game over."); 
    // I would like to also make it show a final report,but I don't yet know how to do that.
}
}
