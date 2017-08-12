// Assignment 4
// Kody Scharf
// July 30, 2017
package ks;

/**
 *
 * @author Kodyscharf
 */
public class User {
    
    private String id;
    private String password;
    private String email;
    
    
    
    
    public User() {
    
    }
    
    public User(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString(){
        return "Users ID: " + id + ", " + "password: " + password + 
                ", " +  " email: " + email;
    }
}
