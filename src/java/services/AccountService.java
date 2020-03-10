/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.User;

public class AccountService {

//    public void login(HttpServletRequest request, String username, String password) {
    public boolean login(HttpServletRequest request) {
        UserService us = new UserService();
//            User user = us.get(username);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            User user = us.get(username);
            System.out.println("before if: user:   " + user);
//            if (user.getPassword().equals(password)) {
            if (user != null && password.equals(user.getPassword())) {
                user.setPassword(null);
                session.setAttribute("username", username);
                System.out.println("in if: user:   " + user);
                return true;
            } else {
                System.out.println("no user in session....");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("ERROR: unknown user: " + username);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
}
    public boolean loginAsAdmin(HttpServletRequest request) {
        UserService us = new UserService();
//            User user = us.get(username);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            User user = us.get(username);
//            if (user.getPassword().equals(password)) {
            if (user != null && password.equals(user.getPassword()) && username.equals("admin")) {
                user.setPassword(null);
                session.setAttribute("admin", "admin");
                return true;
            } 
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("ERROR: unknown user: " + "admin");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
}

public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }

}
