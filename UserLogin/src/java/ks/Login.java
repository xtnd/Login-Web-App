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


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      UserDatabase db = new UserDatabase();
      
      //get parameters
      String userId = request.getParameter("userId");
      String password = request.getParameter("password");
      
      //if authenication succeeds,
      if(db.isValid(userId, password)) {
       
          
          //create a session and session attribute
          HttpSession session = request.getSession(true);
          
          //how long will the session be active in seconds (10min)
          session.setMaxInactiveInterval(10*60);
          User user = db.getUser(userId);
          
          
          
          session.setAttribute("user", user);
          
         
          
          //redirect to main page servlet
          response.sendRedirect("MainPage");
          
          
        //otherwise, forward to login.jsp
      } else {
          
          //set error message
          String loginMessage = "Invalid User ID or Password";
          request.setAttribute("loginMessage", loginMessage);
          
          RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
          rd.forward(request, response);
          
      }
        
       
    }

   
}
