/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.ArrayList;
        
/**
 *
 * @author User
 */
public class RestaurantUser {
    private String username;
    private String restaurantname;
    private String email;
    private int password;    
    //constructor
   
    public RestaurantUser (String username, String restaurantname, String email, String password){
        this.username = username;
        this.restaurantname= restaurantname;
        this.email = email;
        this.password = password.hashCode();
               
    }
   

    //Accessor
    public String getUsername(){
        return username;
    }
    
    public String getRestaurantname(){
        return restaurantname;
    }
    
    public String getEmail(){
        return email;
    }
   
    // mutators
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setRestaurantname (String restaurantname){
        this.restaurantname = restaurantname;
    }
    
    public void setEmail (String email){
        this.email = email;
    }
    
    public void setPassword (String password){
        this.password = password.hashCode(); 
    }
    
   
    
    public boolean isPasswordCorrect(String password) {
        return password.hashCode() == this.password;
    }
} 

