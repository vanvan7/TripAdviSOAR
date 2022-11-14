/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Exceptions.DoesNotExistException;
import Models.Restaurant;
import Models.User;
import static Beans.UserSenzu.findByUsername;
import static Beans.RestaurantSenzu.findByRestaurantName;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author chris
 */
@Named(value = "loginSenzu")
@SessionScoped
public class LoginSenzu implements Serializable {

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
                System.out.println(LoginSenzu.getCurrentRestaurant().toString());

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
        LoginSenzu.currentUser = currentUser;
    }

    public static void setPassword(String password) {
        LoginSenzu.password = password;
    }

    public static void setUsername(String username) {
        LoginSenzu.username = username;
    }
    
    public static void setRestaurantName(String restaurantname){
        LoginSenzu.restaurantname = restaurantname;
    }
    
    
}
