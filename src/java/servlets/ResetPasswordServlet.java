/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 679918
 */
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uuid = request.getParameter("uuid");
        if (uuid == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        } else {
            request.setAttribute("uuid", uuid);
            getServletContext().getRequestDispatcher("/WEB-INF/resetNewPassword.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        String path = getServletContext().getRealPath("/WEB-INF");
        String email = (String) request.getParameter("email");
        String uuid = request.getParameter("uuid");
         
        
        AccountService as = new AccountService();
        try {
            if(uuid != null){
                String password = request.getParameter("newpassword");
                as.changePassword(uuid, password);
                request.setAttribute("message", "Password has been successfully changed.");
                response.sendRedirect("login");
            }else{
                as.resetPassword(email,path,url);
                request.setAttribute("message", "Reset link has been sent to your email id");
                getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(ResetPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
