/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.RestaurantUserController.findByUsername;
import Exceptions.DoesNotExistException;
import Database.MockDatabase;
import Exceptions.AlreadyExistsException;
import Models.Restaurant;
import Models.User;
import java.util.ArrayList;


/**
 *
 * @author chris
 */
public class RestaurantUserController {
    private static String username = "";
    private static String password = "";
    private static String email = "";
    private static String restaurantname = "";
    private static String owner = "";
    private static String address = "";
    private static String datetime = "";
    private static String price = "";
    private static String cookingtype = "";
    private static String contact = "";
    //private static String menu = "";
    //private static String specialdiet = "";

    private static ArrayList<String> menu;
    private static ArrayList<String> specialdiet;
    private static ArrayList<Integer> ratings;

    public static void createARestaurantUser() {
        try {
            if (!emailExists() && !usernameExists()) {
                MockDatabase.getInstance().addAUser(new User(username, restaurantname, email, password));
                MockDatabase.getInstance().addARestaurant
                (new Restaurant(username, password, email, restaurantname, owner, address, datetime, price, cookingtype, contact, menu, specialdiet, ratings));
            } //add to mock databese if User created
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    protected static User findByUsername(String username) throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }
    
    protected static boolean emailExists() throws AlreadyExistsException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getEmail().equals(email)) {
                throw new AlreadyExistsException("The email " + email + " already in use.");
            }
        }
        return false;
     }     
    
    protected static boolean usernameExists() throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
   
    //GET
    public static String getEmail() {
        return email;
    }

    public static String getRestaurantname() {
        return restaurantname;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }
    
    public static String getOwner() {
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


    
    //public static ArrayList<Menu> getMenu() {
    //    return MockDatabase.getInstance().getMenu();
    //}
    
    //public static ArrayList<SpecialDiet> getSpecialdiet() {
    //    return MockDatabase.getInstance().getSpecialdiet();
    //}
   
   //----------------------------------------------added => don't return error on NEtbeans
   public static ArrayList<String> getMenu(){
        return menu;
    }
   public static ArrayList<String> getSpecialdiet(){
        return specialdiet;
    }
    

    //---------------------------------------------------added
    
    //SET

    public static void setEmail(String email) {
        RestaurantUserController.email = email;
    }
    
    public static void setRestaurantname(String restaurantname) {
        RestaurantUserController.restaurantname = restaurantname;
    }
    
    public static void setPassword(String password) {
        RestaurantUserController.password = password;
    }

    public static void setUsername(String username) {
        RestaurantUserController.username = username;
    }
    
    public static void setOwner(String owner) {
        RestaurantUserController.owner = owner;
    }

    public static void setAddress(String address) {
        RestaurantUserController.address = address;
    }

    public static void setDatetime(String datetime) {
        RestaurantUserController.datetime = datetime;
    }

    public static void setPrice(String price) {
        RestaurantUserController.price = price;
    }

    public static void setCookingtype(String cookingtype) {
        RestaurantUserController.cookingtype = cookingtype;
    }
    
    
    public static void setContact(String contact) {
        RestaurantUserController.contact = contact;
    }

    // Not sure if the following two are correct, because there are a list 
//    public static void setMenu(String menu) {
//        RestaurantUserController.menu = menu;
//    }
//    
    
    //public static void setSpecialdiet(String specialdiet) {
    //    RestaurantUserController.specialdiet = specialdiet;
    //}

   
    public static void setMenu(ArrayList<String> menu) {
        RestaurantUserController.menu = menu;
    }
    
    
    public static void setSpecialdiet(ArrayList<String> specialdiet){
        RestaurantUserController.specialdiet = specialdiet;
    }

}
