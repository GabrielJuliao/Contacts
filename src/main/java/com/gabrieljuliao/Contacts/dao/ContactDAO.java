package com.gabrieljuliao.Contacts.dao;

import com.gabrieljuliao.Contacts.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactDAO {
    private final Connection connection;
    private String query;
    private PreparedStatement statement;

    public ContactDAO(Connection connection) {
        this.connection = connection;
    }

    public void createContact(Contact contact) {
        query = "insert into contacts (owner_id, title, firstName, lastName, phoneNo, email, address)\n" +
                "values (?,?,?,?,?,?,?)";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, contact.getOwnerID());
            statement.setString(2, contact.getTitle());
            statement.setString(3, contact.getFirstName());
            statement.setString(4, contact.getLastName());
            statement.setString(5, contact.getPhoneNo());
            statement.setString(6, contact.getEmail());
            statement.setString(7, contact.getAddress());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateContact(Contact contact) {
        query = "update contacts set title = ?, firstName = ?,lastName  = ?,phoneNo   = ?,email= ?, address   = ? where contact_id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, contact.getTitle());
            statement.setString(2, contact.getFirstName());
            statement.setString(3, contact.getLastName());
            statement.setString(4, contact.getPhoneNo());
            statement.setString(5, contact.getEmail());
            statement.setString(6, contact.getAddress());
            statement.setString(7, contact.getContactID());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Contact getContact(String id) {
        query = "select * from contacts where contact_id=?";
        Contact contact = new Contact();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                contact.setContactID(resultSet.getString("contact_id"));
                contact.setOwnerID(resultSet.getString("owner_id"));
                contact.setTitle(resultSet.getString("title"));
                contact.setFirstName(resultSet.getString("firstName"));
                contact.setLastName(resultSet.getString("lastName"));
                contact.setPhoneNo(resultSet.getString("phoneNo"));
                contact.setEmail(resultSet.getString("email"));
                contact.setAddress(resultSet.getString("address"));
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contact;
    }

    public ArrayList<Contact> getAllContacts(String ownerID) {
        ArrayList<Contact> contactModelList = null;
        query = "select * from contacts where owner_id = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, ownerID);
            ResultSet resultSet = statement.executeQuery();
            contactModelList = new ArrayList<Contact>();
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setContactID(resultSet.getString("contact_id"));
                contact.setOwnerID(resultSet.getString("owner_id"));
                contact.setTitle(resultSet.getString("title"));
                contact.setFirstName(resultSet.getString("firstName"));
                contact.setLastName(resultSet.getString("lastName"));
                contact.setPhoneNo(resultSet.getString("phoneNo"));
                contact.setEmail(resultSet.getString("email"));
                contact.setAddress(resultSet.getString("address"));
                contactModelList.add(contact);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contactModelList;
    }

    public void deleteContact(String id) {
        query = "delete from contacts where contact_id=?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
