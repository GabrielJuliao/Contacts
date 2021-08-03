package com.gabrieljuliao.Contacts.controller;

import com.gabrieljuliao.Contacts.dao.UserDAO;
import com.gabrieljuliao.Contacts.model.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;

@WebServlet(value = "signUp", name = "signUpServlet")
public class SignUpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(BCrypt.hashpw(req.getParameter("password"), BCrypt.gensalt(10, new SecureRandom())));
        UserDAO userDAO = new UserDAO((Connection) getServletContext().getAttribute("dbCon"));
        userDAO.createUser(user);
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("overview");
    }
}
