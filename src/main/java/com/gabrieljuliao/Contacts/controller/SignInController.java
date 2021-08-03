package com.gabrieljuliao.Contacts.controller;

import com.gabrieljuliao.Contacts.dao.UserDAO;
import com.gabrieljuliao.Contacts.model.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(value = "/SignIn", name = "signInServlet")
public class SignInController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        UserDAO userDAO = new UserDAO((Connection) getServletContext().getAttribute("dbCon"));
        String view = "SignIn";
        if (userDAO.getUser(req.getParameter("email")) != null) {
            User user = userDAO.getUser(req.getParameter("email"));
            if (BCrypt.checkpw(req.getParameter("password"), user.getPassword())) {
                HttpSession session = req.getSession();
                view = "overview";
                session.setAttribute("user", user);
            }
        }
        res.sendRedirect(view);
    }
}
