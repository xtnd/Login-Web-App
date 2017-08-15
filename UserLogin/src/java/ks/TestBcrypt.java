// Kody Scharf
// August 1, 2017
package ks;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Kodyscharf
 */
public class TestBcrypt {
    
    public static void main(String[] args) {
        
        //has password with jBcrypt
        String origPassword = "1234";
        String hashedPassword = BCrypt.hashpw(origPassword, BCrypt.gensalt());
        
        System.out.println("Original: " + origPassword);
        System.out.println("Hashed: " + hashedPassword);
        
        //check password
        boolean check = BCrypt.checkpw(origPassword, hashedPassword);
        System.out.println(check);
        
    }
}
