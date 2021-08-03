package com.gabrieljuliao.Contacts.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String url = "jdbc:mysql://localhost:3306/" + servletContext.getInitParameter("db_name");
        String username = servletContext.getInitParameter("db_username");
        String password = servletContext.getInitParameter("db_password");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            servletContext.setAttribute("dbCon", connection);
            System.out.println("connected to db");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            Connection connection = (Connection) sce.getServletContext().getAttribute("dbCon");
            connection.close();
            System.out.println("disconnected to db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
