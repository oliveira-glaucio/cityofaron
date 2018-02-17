/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaron.control;

/**
 *
 * @author macbook
 */
public class plantCrops {
    
// The plantCrops method.
// Purpose: plant the crops.
// Parameters: the number of acres of land that the player wants to plant.
// Returns: must return a positive number. Returns the remaining number of wheat in store. If there's an error, return -1.
// Pre-conditions: number of wheat in store and acres must be enough for user to plant the crops.

    public static int plantCrops() {

    //If plantCrops > acresOwned then, return -1
    if(plantCrops > acresOwned)
        return -1;
    //Also, if plantCrops > wheatInStore then, return -1
        if(plantCrops > wheatInStore) 
            return -1;
    }
    

}
