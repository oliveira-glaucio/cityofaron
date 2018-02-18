package cityofaron.control;

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
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) {
        //if acresToSell < 0, return -1
        if (acresToSell < 0) {
            return -1;
        }

        //if acresToSell > acresOwned, return -1
        int owned = cropData.getAcresOwned();
        if (acresToSell > owned) {
            return -1;
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
        int randomValue = randInt(1,100);

//if randomValue > 30 then wheatEatenByRats = 0, return 0
        if (randomValue > 30) {
            return 0;
        }

//if offeringPercentage > 12
//    wheatEatenByRats = get random value between 3 and 5 of wheat in store
        if (cropData.getOffering() > 12) {
            wheatEatenByRats = (int)((randInt(3, 5) / 100.0) * cropData.getWheatInStore());
        } //else if offeringPercentage >= 8 and offeringPercentage <= 12
        //    wheatEatenByRats = get random value between 3 and 7 of wheat in store
        else if (cropData.getOffering() >= 8 && cropData.getOffering() <= 12) {
            wheatEatenByRats = (int)((randInt(3, 7) / 100.0) * cropData.getWheatInStore());
        } //else if offeringPercentage < 8
        //    wheatEatenByRats = get random value between 6 and 10 of wheat in store
        else if (cropData.getOffering() < 8) {
            wheatEatenByRats = (int)((randInt(6, 10) / 100.0) * cropData.getWheatInStore());
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
        int peopleMovedToTheCity = (int)((randomValue / 100.0) * cropData.getPopulation());
        cropData.setPopulation(cropData.getPopulation() + peopleMovedToTheCity);

//return peopleMovedToTheCity  
        return peopleMovedToTheCity;
    }

//The calcStarved method
//Purpose: to calculate the amount of people who starved during a year.
//Parameters: none
//Returns: must return a positive value with the number of people who starved. Returns 0 if no people starved.
//Pre-conditions: people in the city must be positive; 
    public static int calcStarved() {

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
}
