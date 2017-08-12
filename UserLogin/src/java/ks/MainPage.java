// Assignment 4
// Kody Scharf
// July 30, 2017
package ks;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kodyscharf
 */
@WebServlet(name = "MainPage", urlPatterns = {"/MainPage"})
public class MainPage extends HttpServlet {

    
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false); //false makes it so no new session is created.
        
        //if session isn't set (not logged in), then redirect to login servlet
        if(session == null) {
            response.sendRedirect("Login");
        } 
        
        //if logged in, forward to mainPage.jsp
        else {
            
            
            User user = (User) session.getAttribute("user");
            
          //  System.out.println(user.toString()); prints correct id,pw,email
            
            
            //if user attribute is not set, redirect to login
            if(user == null) {
                
                response.sendRedirect("Login");
                
            }
            
            else {
                
                //removes cache
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
                response.setHeader("Pragma", "no-cache"); 
                response.setHeader("Expires", "0"); 
                
                RequestDispatcher rd = request.getRequestDispatcher("mainPage.jsp");
                rd.forward(request, response);
                
            }
            
        }
        
        
        
    }


}
