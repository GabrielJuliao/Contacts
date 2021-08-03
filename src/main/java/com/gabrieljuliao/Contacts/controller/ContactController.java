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

@WebServlet(value = "Contact", name = "contactServlet")
public class ContactController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactDAO contactDAO = new ContactDAO((Connection) getServletContext().getAttribute("dbCon"));
        Contact contact = contactDAO.getContact(req.getParameter("contact_id"));
        req.setAttribute("contact", contact);
        req.getRequestDispatcher("WEB-INF/views/contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactDAO contactDAO = new ContactDAO((Connection) getServletContext().getAttribute("dbCon"));
        User user = (User) req.getSession().getAttribute("user");
        Contact contact = new Contact();
        contact.setContactID(req.getParameter("contact_id"));
        contact.setTitle(req.getParameter("title"));
        contact.setFirstName(req.getParameter("firstName"));
        contact.setLastName(req.getParameter("lastName"));
        contact.setAddress(req.getParameter("address"));
        contact.setPhoneNo(req.getParameter("phoneNo"));
        contact.setEmail(req.getParameter("email"));
        contactDAO.updateContact(contact);
        resp.sendRedirect("overview");
//        owner_id, title, firstName, lastName, phoneNo, email, address
    }
}
