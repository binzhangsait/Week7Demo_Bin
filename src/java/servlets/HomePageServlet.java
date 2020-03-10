/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

/**
 *
 * @author 798419
 */
public class HomePageServlet extends HttpServlet {

    private int counter;

    @Override
    public void init() throws ServletException {
        counter = 0;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("do GET in homepageServlet");

        request.getServletContext().getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
        // response.sendRedirect("shoppingList");
        //HttpSession session = request.getSession();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("do Post in homepageServlet");

//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        AccountService as = new AccountService();
        boolean login = as.login(request);
        if (login) {
            request.getServletContext().getRequestDispatcher("/WEB-INF/homepage.jsp").forward(request, response);
        } else {
            response.sendRedirect("/Week7Demo_Bin/login");
        }

        //request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        // response.sendRedirect("ShoppingList");
        //HttpSession session = request.getSession();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
