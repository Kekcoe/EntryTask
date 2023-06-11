package com.testtask.dao;

import com.testtask.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
    private String jdbcUsername = "user";
    private String jdbcPassword = "password";

    private static final String SELECT_COMPANY_BY_ID = "select id,name,legalform,adress, branches from companies where id =?";
    private static final String SELECT_ALL_COMPANIES = "select * from companies";

    public Dao() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Company> selectAllCompanies() {
        List<Company> companies = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMPANIES)) {
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String legalForm = rs.getString("legalForm");
                String adress = rs.getString("adress");
                String branches = rs.getString("branches");
                companies.add(new Company(name, legalForm, adress, branches));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return companies;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
