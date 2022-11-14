/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Controllers.LoginController;
import Controllers.RestaurantController;
import static Controllers.RestaurantController.findByRestaurantName;
import Exceptions.DoesNotExistException;
import Database.MockDatabase;
import Models.Restaurant;
import java.util.ArrayList;
import Exceptions.NoRestaurantCorrespondingException;
import Models.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author srivathshanparamalingam
 */
public class RestaurantControllerTest {
    
    public RestaurantControllerTest() {
    System.out.println("RestaurantControllerTest constructor");
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("@BeforeClass setUpClass");
        // we initialize our UserList (database for users) and add users to it
        MockDatabase.getInstance().addAUser(new User("lisa", "lisa", "simpson", "lisa@simpson.com", "1234"));
        MockDatabase.getInstance().addAUser(new User("homer", "homer", "simpson", "homer@simpson.com", "1234"));
        MockDatabase.getInstance().addAUser(new User("marge", "marge", "simpson", "marge@simpson.com", "1234"));
        MockDatabase.getInstance().addAUser(new User("bart", "bart", "simpson", "bart@simpson.com", "1234"));
        MockDatabase.getInstance().addAUser(new User("maggie", "maggie", "simpson", "maggie@simpson.com", "1234"));
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("@AfterClass tearDownClass");
        MockDatabase.getInstance().getUsers().clear();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("@BeforeMethod setUp");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("@AfterMethod tearDown");
    }
    
    // test IndexOutOfBoundsException
    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        System.out.println("@Test testIndexOutOfBoundsException");
        MockDatabase.getInstance().getUsers().get(100);
    }

    // test timeout
    @Test(timeOut = 1000)
    public void testTimeOut() throws InterruptedException {
        System.out.println("@Test testTimeOut");
        Thread.sleep(500);
    }
    
    @Test
    public void testfindByRestaurantName() throws DoesNotExistException {
        
        System.out.println("@Test testfindByRestaurantName");
        // login as a user
        LoginController.setUsername("lisa");
        LoginController.setPassword("1234");
        LoginController.userLogsIn();
        // we need some mock data
        MockDatabase.getInstance().add(new Restaurant("waffle1", "1234", "waffle@gmail.com", "The Real Waffle", "Thoralf", "High Avenue 1",
            "11:00-24:00", "$", "Traditional", "0794731452", new ArrayList<String>(){
                {
                    add("The Authenthic");
                    add("Cheesy Lover");
                    add("Salted Butter Caramel");
                }
            }, new ArrayList<String>(){
                {
                    add("Vegetarian");
                    add("Lactose free");
                }
            }));
        String restaurantname = "Pancake";
        
       //set the restaurantname
       
            RestaurantController.setRestaurantName(restaurantname);
        //test the findbyrestaurantname function
            Restaurant expectedrestaurant = null;
        for (Restaurant r : MockDatabase.getInstance().getRestaurant()) {
            if (r.getRestaurantname().equals(restaurantname)) {
                expectedrestaurant=r;
                }    
            
            }
        // if the restaurantname exists, expectedrestaurant must have a value
        Assert.assertNotNull(expectedrestaurant);
       
    }
    
    
}