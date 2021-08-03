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

@WebServlet(value = "AddContact", name = "addContactServlet")
public class ContactDeleteUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/addContact.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ContactDAO contactDAO = new ContactDAO((Connection) getServletContext().getAttribute("dbCon"));
        User user = (User) req.getSession().getAttribute("user");
        Contact contact = new Contact();
        contact.setOwnerID(user.getId());
        contact.setTitle(req.getParameter("title"));
        contact.setFirstName(req.getParameter("firstName"));
        contact.setLastName(req.getParameter("lastName"));
        contact.setAddress(req.getParameter("address"));
        contact.setPhoneNo(req.getParameter("phoneNo"));
        contact.setEmail(req.getParameter("email"));
        contactDAO.createContact(contact);
        resp.sendRedirect("overview");
//        owner_id, title, firstName, lastName, phoneNo, email, address
    }
}
