package com.gabrieljuliao.Contacts.controller;

import com.gabrieljuliao.Contacts.dao.UserDAO;
import com.gabrieljuliao.Contacts.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(value = "DeleteAccount", name = "deleteAccountServlet")
public class DeleteAccountController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserDAO userDAO = new UserDAO((Connection) getServletContext().getAttribute("dbCon"));
        User user = (User) req.getSession().getAttribute("user");
        userDAO.deleteUser(user.getId());
        resp.sendRedirect("SignIn");
    }
}
