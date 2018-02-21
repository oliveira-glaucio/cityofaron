package cityofaron.control;


import cityofaron.model.CropData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/*
 * @author glaucio
 */
public class CropControlTest {
    
    public CropControlTest(){
    }
    
    @BeforeClass
    public static void setUpClass(){
    }
    
    @AfterClass
    public static void tearDownClass(){
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
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

    @Test
    public void testCalcEatenByRatsInvalidReturn() {
        System.out.println("calcEatenByRats");
        int expResult = -1;
        
        CropData cropData = new CropData();
        cropData.setWheatInStore(0);        
        CropControl.setCropData(cropData);
        
        int result = CropControl.calcEatenByRats();
        assertEquals(expResult, result);
    }

    @Test
    public void testCalcEatenByRatsWithHighestOffering() {
        System.out.println("calcEatenByRats");

        
        CropData cropData = new CropData();
        cropData.setWheatInStore(100);
        cropData.setOffering(13);
        
        CropControl.setCropData(cropData);
        
        int result = CropControl.calcEatenByRats();
        
        assertTrue((result >= 3 && result <= 5) || result == 0);
    }
    
    @Test
    public void testCalcEatenByRatsWithOfferingBetweenEightAndTwelvePercent() {
        System.out.println("calcEatenByRats");

        
        CropData cropData = new CropData();
        cropData.setWheatInStore(100);
        cropData.setOffering(8);
        
        CropControl.setCropData(cropData);
        
        int result = CropControl.calcEatenByRats();
        
        assertTrue((result >= 3 && result <= 7) || result == 0);
    }

    @Test
    public void testCalcEatenByRatsWithOfferingBelowEightPercent() {
        System.out.println("calcEatenByRats");

        
        CropData cropData = new CropData();
        cropData.setWheatInStore(100);
        cropData.setOffering(7);
        
        CropControl.setCropData(cropData);
        
        int result = CropControl.calcEatenByRats();
        
        assertTrue((result >= 6 && result <= 10) || result == 0);
    }
    
    
    @Test
    public void testGrowPopulationPeopleMovedToTheCity() {
        System.out.println("growPopulation");

        
        CropData cropData = new CropData();
        cropData.setPopulation(100);        
        CropControl.setCropData(cropData);
                
        int result = CropControl.growPopulation();

        assertTrue(result >= 0 && result <= 5);
    }
  
    
    @Test
    public void testGrowPopulationPeopleMovedToTheCityInvalidAmount() {
        System.out.println("growPopulation");
        int expResult = 0;
        
        CropData cropData = new CropData();
        cropData.setPopulation(0);        
        CropControl.setCropData(cropData);
                
        int result = CropControl.growPopulation();
        assertEquals(result, expResult);
    }
    
    
    @Test
    public void testCalcStarvedNobodyStarved() {
        System.out.println("calcStarved");
        int expResult = 0;
        
        CropData cropData = new CropData();
        cropData.setWheatForPeople(10);
        cropData.setPopulation(200);
        
        CropControl.setCropData(cropData);
                
        int result = CropControl.calcStarved();
        assertEquals(expResult, result);
    }  
    
    
    @Test
    public void testCalcStarvedFivePeopleStarved() {
        System.out.println("calcStarved");
        int expResult = 5;
        
        CropData cropData = new CropData();
        cropData.setWheatForPeople(10);
        cropData.setPopulation(205);
        
        CropControl.setCropData(cropData);
                
        int result = CropControl.calcStarved();
        assertEquals(expResult, result);
    }  

    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        CropData cropData = new CropData(); 
        cropData.setWheatInStore(2000);;
        int wheatAllocated = 1000;
        int expResult = 1000;
        int result = CropControl.feedPeople(CropData cropData, wheatAllocated);
        assertEquals(expResult, result); 
    } 
    
    @Test
    public void testFeedPeople2() {
        System.out.println("feedPeople");
        CropData cropData = new CropData(); 
        cropData.setWheatInStore(0);
        int wheatAllocated = 1000;
        int expResult = -1;
        int result = CropControl.feedPeople(CropData cropData, wheatAllocated);
        assertEquals(expResult, result);
    }

    @Test
    public void testFeedPeople3() {
        System.out.println("feedPeople");
        CropData cropData = new CropData(); 
        cropData.setWheatInStore(1000);
        int wheatAllocated = 2000;
        int expResult = -1;
        int result = CropControl.feedPeople(CropData cropData, wheatAllocated);
        assertEquals(expResult, result);       
    }
    
    @Test
    public void testFeedPeople4() {
        System.out.println("feedPeople");
        CropData cropData = new CropData(); 
        cropData.setWheatInStore(2000);
        int wheatAllocated = 2000;
        int expResult = 0;
        int result = CropControl.feedPeople(CropData cropData, wheatAllocated);
        assertEquals(expResult, result);
    }


    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        int acresToBuy = 10;
        CropData cropData = new CropData(); 
        cropData.setWheatInStore(2500);
        int landPrice = 20;
        int workers = 300;
        theCrops.setAcresOwned (2810);
        int expResult = 2820;
        int result = CropControl.buyLand(acresToBuy, CropData cropData, landPrice, workers);
        assertEquals(expResult, result);
    }

    @Test
    public void testBuyLand2(){
        System.out.println("buyLand");
        int acresToBuy = -5;
        CropData cropData = new CropData(); 
        cropData.setWheatInStore(2500);
        int landPrice = 20;
        int workers = 150;
        theCrops.setAcresOwned (2000);
        int expResult = -1;
        int result = CropControl.buyLand(acresToBuy, CropData cropData, landPrice, workers);
        assertEquals(expResult, result);
    }

    @Test
    public void testBuyLand3() {
        System.out.println("buyLand");
        int acresToBuy = 100;
        CropData cropData = new CropData(); 
        cropData.setWheatInStore(20);
        int landPrice = 20;
        int workers = 100;
        theCrops.setAcresOwned (2000);
        int expResult = -1;
        int result = CropControl.buyLand(acresToBuy, CropData cropData, landPrice, workers);
        assertEquals(expResult, result);
    }

    @Test
    public void testBuyLand4() {
        System.out.println("buyLand");
        int acresToBuy = 1;
        CropData cropData = new CropData(); 
        cropData.setWheatInStore(1);
        int landPrice = 1;
        int workers = 10;
        theCrops.setAcresOwned (0);
        int expResult = 1;
        int result = CropControl.buyLand(acresToBuy, CropData cropData, landPrice, workers);
        assertEquals(expResult, result);
    }

    @Test
    public void testBuyLand5() {
        System.out.println("buyLand");
        int acresToBuy = 1000;
        CropData cropData = new CropData(); 
        cropData.setWheatInStore(1000);
        int landPrice = 1;
        int workers = 300;
        theCrops.setAcresOwned(1000);
        int expResult = 2000;
        int result = CropControl.buyLand(acresToBuy, CropData cropData, landPrice, workers);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcLandCost method, of class CropControl.
     */
    @Test
    public void testCalcLandCost() {
        System.out.println("calcLandCost");
        int expResult = 0;
        int result = CropControl.calcLandCost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of randInt method, of class CropControl.
     */
    @Test
    public void testRandInt() {
        System.out.println("randInt");
        int min = 0;
        int max = 0;
        int expResult = 0;
        int result = CropControl.randInt(min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcEatenByRats method, of class CropControl.
     */
    @Test
    public void testCalcEatenByRats() {
        System.out.println("calcEatenByRats");
        int expResult = 0;
        int result = CropControl.calcEatenByRats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of growPopulation method, of class CropControl.
     */
    @Test
    public void testGrowPopulation() {
        System.out.println("growPopulation");
        int expResult = 0;
        int result = CropControl.growPopulation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcStarved method, of class CropControl.
     */
    @Test
    public void testCalcStarved() {
        System.out.println("calcStarved");
        int expResult = 0;
        int result = CropControl.calcStarved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCropData method, of class CropControl.
     */
    @Test
    public void testGetCropData() {
        System.out.println("getCropData");
        CropData expResult = null;
        CropData result = CropControl.getCropData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCropData method, of class CropControl.
     */
    @Test
    public void testSetCropData() {
        System.out.println("setCropData");
        CropData cropData = null;
        CropControl.setCropData(cropData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plantCrops method, of class CropControl.
     */
    @Test
    public void testPlantCrops() {
        System.out.println("plantCrops");
        int acresToPlant = 0;
        int acresOwned = 0;
        int wheatInStore = 0;
        CropData cropData = null;
        CropControl instance = null;
        int expResult = 0;
        int result = instance.plantCrops(acresToPlant, acresOwned, wheatInStore, cropData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of payOffering method, of class CropControl.
     */
    @Test
    public void testPayOffering() {
        System.out.println("payOffering");
        int wheatInStore = 0;
        int offeringAmount = 0;
        CropData cropData = null;
        CropControl instance = null;
        int expResult = 0;
        int result = instance.payOffering(wheatInStore, offeringAmount, cropData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

