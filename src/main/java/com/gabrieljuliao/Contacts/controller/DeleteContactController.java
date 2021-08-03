package com.gabrieljuliao.Contacts.controller;

import com.gabrieljuliao.Contacts.dao.ContactDAO;

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
        contactDAO.deleteContact(req.getParameter("contact_id"));
        resp.sendRedirect("overview");
    }
}
