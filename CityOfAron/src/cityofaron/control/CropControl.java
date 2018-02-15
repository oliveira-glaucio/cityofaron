package cityofaron.control;

import cityofaron.model.CropData;
import java.util.Random;

/**
 *
 * @author glaucio
 */

public class CropControl {
private static Random random = new Random();    
    
    
// The sellLand method
// Purpose: To sell land
// Parameters: the price of land, the number of acres to sell, and a 
// reference to a CropData object
// Returns: the acres owned after the sale
// Pre-conditions: acres to sell must be positive
// and <= acresOwned
 public static int sellLand(int landPrice, int acresToSell, CropData cropData)
 { 
    //if acresToSell < 0, return -1
    if(acresToSell < 0)
        return -1;

    //if acresToSell > acresOwned, return -1
    int owned = cropData.getAcresOwned();
    if(acresToSell > owned)
         return -1;

   
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
 public static int calcLandCost(){
     int landPrice = random.nextInt(10) + 17;
     return landPrice;
 }
 
 
}
