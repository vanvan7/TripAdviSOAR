/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Controllers.LoginController;
import Database.MockDatabase;
import static Views.Main.userHomePage;
import java.util.ArrayList;
import java.util.Arrays;
import Models.Restaurant;

/**
 *
 * @author chris
 */
public class User {
    private String firstname;
    private String lastname;
    protected String username;
    protected String email;
    private String restaurantname; 
    protected int password;

    
    //constructor
   
    public User (String username, String firstname, String lastname, String email, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password.hashCode();
//        this.commentsratings = new CommentsRatings();
   
    }
    
    //2nd constructor
        
    public User (String username, String restaurantname, String email, String password){
        this.username = username;
        this.restaurantname = restaurantname;
        this.email = email;
        this.password = password.hashCode();
    }
    

    //Accessor
    public String getFirstname(){
        return firstname;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getRestaurantname(){
        return restaurantname;
    }
    
    // mutators
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public void setLastname (String lastname){
        this.lastname = lastname;
    }
    
    public void setUsername (String username){
        this.username = username;
    }
    
    public void setEmail (String email){
        this.email = email;
    }
    
    public void setRestaurantname  (String restaurantname){
        this.restaurantname = restaurantname;
    }
    
       public void setPassword (String password){
        this.password = password.hashCode(); 
    }
    
    
    
    public boolean isPasswordCorrect(String password) {
        return password.hashCode() == this.password;
    }
    
    

    @Override
    public String toString() {
        String S="";
        if (restaurantname==null){
            S=  "Username: " + this.username
                    + "\nFirst name: " + this.firstname
                    + "\nLast name: " + this.lastname
                    + "\nEmail: " + this.email;    
        } else{
            S= "Username: " + this.username
                    + "\nRestaurant Name: " + this.restaurantname
                    + "\nEmail: " + this.email;   
          
            for (int r=0; r<MockDatabase.restaurants.size();r++){
                       if (restaurantname == MockDatabase.restaurants.get(r).getRestaurantname()){
                           S = S + MockDatabase.restaurants.get(r).toString();
                       }                      
            }              
        }
        return S;
    }
}
       


