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

}

//Five tests for feed people
//Test #1
import org.junit.Test;
import static org.junit.Assert.*;


    public feedPeopleTest() {
    }

    /**
     * Test of feedPeople method, of class cropControl.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        int wheatInStore = 2000;
        int wheatAllocated = 1000;
        int expResult = 1000;
        int result = feedPeople.feedPeople(wheatInStore, wheatAllocated);
        assertEquals(expResult, result);
        
        
    } 
}
//Test #2

    /**
     * Test of feedPeople method, of class feedPeople.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        int wheatInStore = 0;
        int wheatAllocated = 1000;
        int expResult = -1;
        int result = feedPeople.feedPeople(wheatInStore, wheatAllocated);
        assertEquals(expResult, result);
        
        
    } 
}

//Test #3

    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        int wheatInStore = 1000;
        int wheatAllocated = 2000;
        int expResult = -1;
        int result = feedPeople.feedPeople(wheatInStore, wheatAllocated);
        assertEquals(expResult, result);
        
        
    } 
}
//Test #4

    /**
     * Test of feedPeople method, of class feedPeople.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        int wheatInStore = 2000;
        int wheatAllocated = 2000;
        int expResult = 0;
        int result = feedPeople.feedPeople(wheatInStore, wheatAllocated);
        assertEquals(expResult, result);
        
        
    } 
}
//Test #5
    public feedPeopleTest() {
    }

    /**
     * Test of feedPeople method, of class feedPeople.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        int wheatInStore = 4000;
        int wheatAllocated = 2000;
        int expResult = 2000;
        int result = feedPeople.feedPeople(wheatInStore, wheatAllocated);
        assertEquals(expResult, result);
        
        
    } 
}

//Fifve tests for buyLand
//Test #1
/*
 * Just a series of tests.
 */


    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        int acresToBuy = 10;
        int wheatInStore = 2500;
        int landPrice = 20;
        int workers = 300;
        int acresOwned = 2810;
        int expResult = 2820;
        int result = buyLand.buyLand(acresToBuy, wheatInStore, landPrice, workers, acresOwned);
        assertEquals(expResult, result);
    }


//Test #2
/*
 * Just a series of tests.
 */


    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        int acresToBuy = -5;
        int wheatInStore = 2500;
        int landPrice = 20;
        int workers = 150;
        int acresOwned = 2000;
        int expResult = -1;
        int result = buyLand.buyLand(acresToBuy, wheatInStore, landPrice, workers, acresOwned);
        assertEquals(expResult, result);
    }

}
//Test #3


    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        int acresToBuy = 100;
        int wheatInStore = 20;
        int landPrice = 20;
        int workers = 100;
        int acresOwned = 2000;
        int expResult = -1;
        int result = buyLand.buyLand(acresToBuy, wheatInStore, landPrice, workers, acresOwned);
        assertEquals(expResult, result);
    }
}
//Test #4

    @Test
    public void testBuyLand() {
        System.out.println("buyLand");
        int acresToBuy = 1;
        int wheatInStore = 1;
        int landPrice = 1;
        int workers = 10;
        int acresOwned = 0;
        int expResult = 1;
        int result = buyLand.buyLand(acresToBuy, wheatInStore, landPrice, workers, acresOwned);
        assertEquals(expResult, result);
    }

}
//Test #5
/*
 * Just a series of tests.
 */
    public void testBuyLand() {
        System.out.println("buyLand");
        int acresToBuy = 1000;
        int wheatInStore = 1000;
        int landPrice = 1;
        int workers = 300;
        int acresOwned = 1000;
        int expResult = 2000;
        int result = buyLand.buyLand(acresToBuy, wheatInStore, landPrice, workers, acresOwned);
        assertEquals(expResult, result);
    }

}

