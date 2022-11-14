/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import static Beans.RestaurantSenzu.findByRestaurantName;
import Exceptions.DoesNotExistException;
import Database.MockDatabase;
import Models.Restaurant;
import java.util.ArrayList;
import Exceptions.NoRestaurantCorrespondingException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author chris
 */
@Named(value = "restaurantSenzu")
@SessionScoped
public class RestaurantSenzu implements Serializable {

   private static String restaurantname = "";
    private static String owner = "";
    private static String address = "";
    private static String datetime = "";
    private static String price = "";
    private static String cookingtype = "";
    private static String contact = "";
    private static String menu = "";
    private static String specialdiet = "";
    

    public static Restaurant findByRestaurantName(String restaurantname) throws DoesNotExistException {
        for (Restaurant restaurant : MockDatabase.getInstance().getRestaurant()) {
            if (restaurant.getRestaurantname().equals(restaurantname)) {
                return restaurant;
            }    
        }
        throw new DoesNotExistException("The restaurant " + restaurantname + " does not exist.");
        
     }
    
    
    public static ArrayList<Restaurant> getRestaurant() {
        return MockDatabase.getInstance().getRestaurant();
       
    }
    
    public static String getRestaurantName() {
        return restaurantname;
        
    }
    
    public static void setRestaurantName(String restaurantname) {
        RestaurantSenzu.restaurantname = restaurantname;
    }
    
    public static String getOwnerName() {
        return owner;
    }
    
    public static String getAddress() {
        return address;
    }
    
    public static String getDatetime() {
        return datetime;
    }
    
    public static String getPrice() {
        return price;
    }
    
    public static String getCookingtype() {
        return cookingtype;
    }
    
    public static String getContact() {
        return contact;
    }
    
    public static String getMenu() {
        return menu;
    }
    
    public static String getSpecialdiet() {
        return specialdiet;
    }
    
}
