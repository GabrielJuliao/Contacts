package com.gabrieljuliao.Contacts.controller;

import com.gabrieljuliao.Contacts.dao.UserDAO;
import com.gabrieljuliao.Contacts.model.User;
import com.gabrieljuliao.Contacts.utils.TextInput;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(value = "Account", name = "accountServlet")
public class AccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDAO userDAO = new UserDAO((Connection) getServletContext().getAttribute("dbCon"));

        User user = (User) req.getSession().getAttribute("user");

        user.setFirstName(TextInput.firstLetterUppercase(req.getParameter("firstName")));
        user.setLastName(TextInput.firstLetterUppercase(req.getParameter("lastName")));
        user.setEmail(TextInput.allLowerCase(req.getParameter("email")));
        userDAO.updateUser(user);

        req.getSession().setAttribute("user", user);
        resp.sendRedirect("overview");
    }
}
