/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.LoginController;
import Controllers.RestaurantUserController;
import Controllers.RestaurantController;
import Controllers.UserController;
import Exceptions.DoesNotExistException;
import Models.Restaurant;
//import Controllers.ReviewController;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
   
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to TripAdviSOAR!");
        homePage();
    }

    private static void homePage() {
        String choice, subChoice,username, password, firstname, lastname, email, owner,address, cookingtype, contact, restaurantname, datetime, price;
        ArrayList<String>menu=new ArrayList<String>();
        ArrayList<String>specialdiet=new ArrayList<String>(); 
        do {
            System.out.println("Enter:"
                    + "\n[q] to quit the application"
                    + "\n[1] to login as a User"
                    + "\n[2] to login as a Restaurant"
                    + "\n[3] to create a Customer account"
                    + "\n[4] to create a Restaurant account"
                    + "\n[5] to search for a Restaurant"
                    + "\n[6] to see the Restaurants");
                   
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter your username:");
                    username = sc.nextLine();
                    System.out.println("Enter your password:");
                    password = sc.nextLine();
                    LoginController.setUsername(username);
                    LoginController.setPassword(password);
                    LoginController.userLogsIn();
                    if (LoginController.getUserLoggedIn() != null) {
                        userHomePage();  
                    } 
                    break;
                    
                case "2":
                    System.out.println("Enter your username:");
                    username = sc.nextLine();
                    System.out.println("Enter your password:");
                    password = sc.nextLine();
                    LoginController.setUsername(username);
                    LoginController.setPassword(password);
                    LoginController.userLogsIn();
                    if (LoginController.getUserLoggedIn() != null) {
                        RestaurantHomePage();  
                    }  
                    break;
                    
                case "3":
                    System.out.println("Enter a username:");
                    username = sc.nextLine();
                    System.out.println("Enter a first name:");
                    firstname = sc.nextLine();
                    System.out.println("Enter a last name:");
                    lastname = sc.nextLine();
                    System.out.println("Enter an email:");
                    email = sc.nextLine();
                    System.out.println("Enter a password:");
                    password = sc.nextLine();
                    UserController.setUsername(username);
                    UserController.setFirstName(firstname);
                    UserController.setLastName(lastname);
                    UserController.setEmail(email);
                    UserController.setPassword(password);
                    UserController.createAUser();
                    break;
                    
                case "4":
                    System.out.println("Enter a username:");
                    username = sc.nextLine();
                    System.out.println("Enter the Restaurant name:");
                    restaurantname = sc.nextLine();
                    System.out.println("Enter an email:");
                    email = sc.nextLine();
                    System.out.println("Enter a password:");
                    password = sc.nextLine();
                    System.out.println("Enter the owners name:");
                    owner = sc.nextLine();
                    System.out.println("Enter the restaurant's Adress:");
                    address = sc.nextLine();
                    System.out.println("Enter a cookingtype:");
                    cookingtype = sc.nextLine();
                    System.out.println("Enter a phone number:");
                    contact = sc.nextLine();
                    System.out.println("Enter opening hours with that format (hh:mm-hh:mm): ");
                    datetime = sc.nextLine();
                    System.out.println("Enter the global price that way (cheap : $, average : $$, expensive : $$$ : ");
                    price = sc.nextLine();
                    do {
                        System.out.println("Make a choice: "
                                + "\n[q] to go back"
                                + "\n[1] to add a dish");
                        subChoice = sc.nextLine();
                        switch (subChoice) {
                            case "1":
                                System.out.println("Enter the name of the dish:");  
                                menu = new ArrayList<>();
                                menu.add(sc.nextLine());
                                break;
                            case "q":  
                                break;
                            default:
                                System.out.println("Choice = " + subChoice + " does not exist.");
                                break;
                        }
                    } while (!subChoice.equals("q"));
                                        
                    //SpecialDiet 
                    System.out.println(RestaurantUserController.getSpecialdiet());
                    do {
                        System.out.println("Enter a choice: "
                                + "\n[q] to go back"
                                + "\n[1] to add a special diet");
                        subChoice = sc.nextLine();
                        switch (subChoice) {
                            case "1":
                                System.out.println("Enter a special Diet:"); 
                                specialdiet = new ArrayList<>();
                                specialdiet.add(sc.nextLine());
                                break;
                            case "q":
                                break;
                            default:
                                System.out.println("Choice = " + subChoice + " does not exist.");
                                break;
                        }
                    } while (!subChoice.equals("q"));
                                                            
                    
                    RestaurantUserController.setUsername(username);
                    RestaurantUserController.setRestaurantname(restaurantname);
                    RestaurantUserController.setEmail(email);
                    RestaurantUserController.setPassword(password);
                    RestaurantUserController.setOwner(owner);
                    RestaurantUserController.setAddress(address);
                    RestaurantUserController.setCookingtype(cookingtype);
                    RestaurantUserController.setContact(contact);
                    RestaurantUserController.setDatetime(datetime);
                    RestaurantUserController.setPrice(price);
                    RestaurantUserController.setMenu(menu);
                    RestaurantUserController.setSpecialdiet(specialdiet);
                    RestaurantUserController.createARestaurantUser();
                    
                    break;
                case "5":
                    System.out.println("Write a Restaurant name : ");
                    restaurantname = sc.nextLine();
                    LoginController.setRestaurantName(restaurantname);
                    LoginController.restaurantLogsIn();
                    break;                   
                case "6":               
                    System.out.println(RestaurantController.getRestaurant().toString());
                    break;
                case "q":
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
    }

    public static void userHomePage() {
        String choice, subChoice, restaurantname;
        do {
            System.out.println("Enter:"
                    + "\n[q] to log out"
                    + "\n[1] to see Restaurants"                    
                    + "\n[2] to search for a Restaurant" 
                    + "\n[3] to show user information");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println(RestaurantController.getRestaurant().toString());
                    break;
              // I modified that to test the research (see modification in LoginController / chris November 8th
                case "2":
                    System.out.println("Write a Restaurant name : ");
                    restaurantname = sc.nextLine();
                    LoginController.setRestaurantName(restaurantname);
                    LoginController.restaurantLogsIn();
                        System.out.println("Enter: "
                                    + "\n[q] to go back"
                                    + "\n[1] to rate the Restaurant");
                        subChoice = sc.nextLine();
                        switch (subChoice) {
                            case "1":
                                System.out.println("Enter the rating of the Restaurant (from 1 to 5):"); 
                                RestaurantController.setRatingList(sc.nextInt());
                                break;
                            case "q":
                                break;
                            default:
                                System.out.println("Choice = " + subChoice + " does not exist.");
                                break;
                            }
                        break;
                case "3":
                    System.out.println(LoginController.getUserLoggedIn().toString());
                    break;
                case "q":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
           }
        } while (!choice.equals("q"));
        LoginController.userLogsout();
    }
    
    
    public static void RestaurantHomePage() {
        String choice, subChoice, restaurantname;
        do {
            System.out.println("Enter:"
                    + "\n[q] to log out"
                    + "\n[1] to see Comments"
                    + "\n[2] to see Ratings"
                    + "\n[3] to show (Restaurant) User information");
            choice = sc.nextLine();
            switch (choice) {
//                case "1":
//                    System.out.println(ReviewController.getComment());
//                    do {
//                        System.out.println("Enter: "
//                                + "\n[q] to go back"
//                                + "\n[1] to add food from store to the shopping cart");
//                        subChoice = sc.nextLine();
//                        switch (subChoice) {
//                            case "1":
//                                System.out.println("Enter the name of the food:");
//                                foodName = sc.nextLine();
//                                FoodController.setFoodName(foodName);
//                                FoodController.addFoodToShoppingCart();
//                                break;
//                            case "q":
//                                break;
//                            default:
//                                System.out.println("Choice = " + subChoice + " does not exist.");
//                                break;
//                        }
//                    } while (!subChoice.equals("q"));
//                    break;
//                case "2":
//                    System.out.println("Here are the products in the shopping cart, write the name of the food you want to remove.");
//                    System.out.println(LoginController.getUserLoggedIn().getShoppingCart().toString());
//                    System.out.println("Food name:");
//                    foodName = sc.nextLine();
//                    FoodController.setFoodName(foodName);
//                    FoodController.removeFoodFromShoppingCart();
//                    break;
//                //case "3":
//                  //  System.out.println(LoginController.getUserLoggedIn().getShoppingCart().toString());          
//                   // break;
                case "3":
                    System.out.println(LoginController.getUserLoggedIn().toString());
                   
                    break;

                case "q":
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
        LoginController.userLogsout();
    }
}