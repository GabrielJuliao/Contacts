package com.gabrieljuliao.Contacts.controller;

import com.gabrieljuliao.Contacts.dao.ContactDAO;
import com.gabrieljuliao.Contacts.model.Contact;
import com.gabrieljuliao.Contacts.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
@WebServlet(value = "DeleteContact", name = "deleteContactServlet")
public class DeleteContactController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactDAO contactDAO = new ContactDAO((Connection) getServletContext().getAttribute("dbCon"));
        User user = (User) req.getSession().getAttribute("user");
        Contact contact = contactDAO.getContact(req.getParameter("contact_id"));

        if (contact.getOwnerID().equals(user.getId())){
            contactDAO.deleteContact(req.getParameter("contact_id"));
            resp.sendRedirect("overview");
        }else resp.sendError(403);

    }
}
