package com.gabrieljuliao.Contacts.controller;

import com.gabrieljuliao.Contacts.dao.ContactDAO;
import com.gabrieljuliao.Contacts.model.Contact;
import com.gabrieljuliao.Contacts.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet("/overview")
public class OverviewController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactDAO contactDAO = new ContactDAO((Connection) getServletContext().getAttribute("dbCon"));
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        ArrayList<Contact> contactModels = contactDAO.getAllContacts(user.getId());
        httpSession.setAttribute("contacts", contactModels);
        req.getRequestDispatcher("WEB-INF/views/overview.jsp").forward(req, resp);
    }
}
