// Kody Scharf
// July 30, 2017
package ks;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kodyscharf
 */
public class UserDatabase {

    //three constants for database access
    public static final String DB_URL = "jdbc:mysql://localhost:3306/ejd";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "Ginger123";
    
    
    //get user
    public User getUser(String userId) {
        
        //validate input
        if(userId == null || userId.isEmpty()) 
            return null;
            
        String sql = "SELECT * FROM ejdUser WHERE id = ?";
        
        //return value
        User user = null;
        
        try {
        
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, userId);
            
            ResultSet rs = ps.executeQuery();
            
            //first row
            if(rs.first()) {
            
                String id = rs.getString(1);
                String password = rs.getString(2);
                String email = rs.getString(3);
                user = new User(id, password, email);
            } 
            
            rs.close();
            ps.close();
            connection.close();
            
        } catch(SQLException e) {
        
        } catch(Exception e) {
        
        }
        
        return user;
    }
    
    //add user
    public int addUser(String userId, String password, String email){
        int result = -1;
        
        if(userId == null || userId.isEmpty() || 
                password == null || password.isEmpty() ||
                email == null || email.isEmpty()) {
            return result;
    
        }
        
        if(!isUnique(userId)) {
                return result;
        }
        
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
 
        try {
            
            //make connection to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS); 
            
            //execute sql statement
            String sql = "INSERT INTO ejdUser VALUE (?, ?, ?)";
            
            //create statement object
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, userId);
            ps.setString(2, hashedPassword);
            ps.setString(3, email);
            
            result = ps.executeUpdate();
                        
            ps.close();
            connection.close();
                    
                    
        } catch (SQLException e) {
                System.err.println(e.getSQLState() + ": " + e.getMessage());
        } catch (Exception e) {
                System.err.println(e.getMessage());
        }
        return result;
    }
    
    //must check if user is already in database
    public boolean isUnique(String userId) {
        User user = getUser(userId);
        
        //if its null, its unique
        if(user == null) {
            
            return true;
            
        } else {
            
            return false;
        }
 
    
    }
    
    //check user ID and PW see if its valid
    public boolean isValid(String userId, String password) {
        
        //get user
        User user = getUser(userId);
        
        if(user == null) {
            
            return false;
            
        } else {
            
            //checking password
            boolean valid = BCrypt.checkpw(password, user.getPassword());
           return valid;
           
        }
        
    }

}
