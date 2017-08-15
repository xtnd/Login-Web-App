// Kody Scharf
// July 30, 2017
package ks;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Kodyscharf
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDatabase db = new UserDatabase();
        RequestDispatcher rd;
     
        //get parameters
        String userId = request.getParameter("userId");
        String password = request.getParameter("userPass");
        String email = request.getParameter("userEmail");
        
        //first request
        if(userId == null && password == null && email == null) {
        
            rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;
        } 
        
        //return message to jsp.
        String registerMessage = null;
        
        //input validation
        if(userId == null || userId.isEmpty()) {
        
            registerMessage = "User ID can't be empty.";
        
        } else if(!db.isUnique(userId)) {
        
            registerMessage = "User ID already exists. Use a different ID. ";
        
        } else if(password == null || password.isEmpty()) {
        
            registerMessage = "Password can't be empty. ";
        
        } else if(email == null || email.isEmpty()) {
        
            registerMessage = "Email can't be empty. ";
        
        } 
        
        if (registerMessage == null) {
        
            //if every input is validated
            int result = db.addUser(userId, password, email);
            if(result >= 0) {
            
                //success, forward to registerResult
                registerMessage = "Successfully registered.";     
                
            } else {
            
                registerMessage = "Failed to register.";
 
            }
            
            request.setAttribute("registerMessage", registerMessage);
            
            //forward to registerResult.jsp
            rd = request.getRequestDispatcher("registerResult.jsp");
            rd.forward(request, response);
            
        } else {
        
            //invalid input, forward to register.jsp
            request.setAttribute("registerMessage", registerMessage);
            //forward
            rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }
      
    }

  

}
