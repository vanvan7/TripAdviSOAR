/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.UserController.findByUsername;
import Exceptions.DoesNotExistException;
import Models.User;
import Models.Restaurant;
import static Controllers.RestaurantController.findByRestaurantName;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Chris
 */
public class LoginController {

    private static String username = "";
    private static String password = "";
    private static String restaurantname = "";
    private static User currentUser;
    private static Restaurant currentRestaurant;

    public static void userLogsIn() {
        try {
            User user = findByUsername(username);
            if (user != null && user.isPasswordCorrect(password)) {
                currentUser = user;
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public static void restaurantLogsIn(){
        try {
            Restaurant restaurant = findByRestaurantName (restaurantname);
            if (restaurant != null){
                currentRestaurant = restaurant;
                System.out.println(LoginController.getCurrentRestaurant().toString());

            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void userLogsout() {
        currentUser = null;
    }

    public static User getUserLoggedIn() {
        return currentUser;
    }
    
    //----------------------------------------
//    public static void RestaurantLogsIn() {
    
//        try {
//            User user = findByUsername(username);
//            if (user != null && user.isPasswordCorrect(password)) {
//                currentRestaurantUser = user;
//            }
//        } catch (DoesNotExistException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//    
//        public static void RestaurantLogsIn(){
//            try {
//                Restaurant restaurant = findByRestaurantName (restaurantname);
//                if (restaurant != null && restaurant.isPasswordCorrect(password)){
//                    currentRestaurant = restaurant;
//
//                }
//            } catch (DoesNotExistException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
    //----------------------------------------
    
    public static Restaurant getCurrentRestaurant(){
        return currentRestaurant;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }

    public static void setCurrentUser(User currentUser) {
        LoginController.currentUser = currentUser;
    }

    public static void setPassword(String password) {
        LoginController.password = password;
    }

    public static void setUsername(String username) {
        LoginController.username = username;
    }
    
    public static void setRestaurantName(String restaurantname){
        LoginController.restaurantname = restaurantname;
    }

}
