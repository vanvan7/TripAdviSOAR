/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Exceptions.DoesNotExistException;
import Exceptions.AlreadyExistsException;
import Database.MockDatabase;
import Models.User;
import java.util.ArrayList;
/**
 *
 * @author chris
 */
public class UserController {
    
    private static String username = "";
    private static String firstName = "";
    private static String lastName = "";
    private static String email = "";
    private static String password = "";
    
    
    
    public static void createAUser() {
        try {
            if (!emailExists() && !usernameExists()) {
                MockDatabase.getInstance().addAUser(new User(username, firstName, lastName, email, password));
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
    
        public static String getEmail() {
        return email;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }

    public static void setEmail(String email) {
        UserController.email = email;
    }

    public static void setFirstName(String firstName) {
        UserController.firstName = firstName;
    }

    public static void setLastName(String lastName) {
        UserController.lastName = lastName;
    }

    public static void setPassword(String password) {
        UserController.password = password;
    }

    public static void setUsername(String username) {
        UserController.username = username;
    }

    
 
}

 