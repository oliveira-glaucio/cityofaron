/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaron.control;

import cityofaron.model.CropData;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author glaucio
 */
public class CropControlTest {
    
    public CropControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

   
@Test
    public void testSellLand()
    {
        System.out.println("sellLand");
        CropData theCrops = new CropData();
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        int toSell = 10;
        int landCost = 15;
        int expResult = 2790;
        int result = CropControl.sellLand(landCost, toSell, theCrops);
        assertEquals(expResult, result);
    }
    
    
}
