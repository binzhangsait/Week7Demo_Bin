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
import javax.servlet.http.HttpSession;
import services.AccountService;

/**
 *
 * @author 798419
 */
public class LoginServlet extends HttpServlet {

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
        System.out.println("do GET in LoginServlet");

        HttpSession session = request.getSession();
        if ("logout".equals(request.getParameter("logout"))) {
            session.removeAttribute("error");
            System.out.println("remove error");
        }

        request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        // response.sendRedirect("shoppingList");
        //HttpSession session = request.getSession();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("guestcount", "<p> you are visitor #" + counter + "!</p>");
        counter++;
        System.out.println("do Post in LoginServlet");

//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        AccountService as = new AccountService();
        boolean login = as.login(request);
        boolean loginAsAdmin = as.loginAsAdmin(request);
        if (login && loginAsAdmin) {
            request.getServletContext().getRequestDispatcher("/users").forward(request, response);
            System.out.println("homepage.............");
        } else if (login) {
            request.getServletContext().getRequestDispatcher("/home").forward(request, response);
            System.out.println("homepage.............");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("error", "Invalid user name or password.");
            System.out.println("redirect to login page");
            response.sendRedirect("/Week7Demo_Bin/login");
        }

        // response.sendRedirect("ShoppingList");
        //HttpSession session = request.getSession();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
