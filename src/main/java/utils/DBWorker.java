package utils;

import models.LegalCustomer;
import models.RealCustomer;
import resources.Strings;

import java.sql.*;

public class DBWorker {
    public static Connection dbConnection() {
        Connection connection;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(Strings.DBPATH);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void createRealTable() throws SQLException {
        try (Connection con = DBWorker.dbConnection();
        ) {
            Statement statement = con.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS real_customers (" +
                    "firstName TEXT," +
                    "lastName TEXT," +
                    "fatherName TEXT," +
                    "birthDay TEXT," +
                    "nationalCode TEXT," +
                    "customerNumber TEXT)"
            );
        }
    }

    public static void createLegalTable() throws SQLException {
        try (Connection con = DBWorker.dbConnection()) {
            Statement statement = con.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS legal_customers (" +
                    "corpName Text," +
                    "registrationDate TEXT," +
                    "financialCode TEXT," +
                    "customerNumber TEXT)"
            );
        }
    }

    public static void insertRealData(RealCustomer customer) throws SQLException {
        try (Connection con = DBWorker.dbConnection();
        ) {
            Statement statement = con.createStatement();
            statement.execute(String.format("INSERT INTO real_customers(firstName, lastName, fatherName, birthDay, nationalCode, customerNumber) " +
                            "VALUES ('%s','%s','%s','%s','%s','%s')",
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getFather(),
                    customer.getBirthDate(),
                    customer.getNationalCode(),
                    customer.getCustomerNumber())
            );
        }
    }


    public static void insertLegalData(LegalCustomer customer) throws SQLException {
        try (Connection con = DBWorker.dbConnection();
        ) {
            Statement statement = con.createStatement();
            statement.execute(String.format("INSERT INTO legal_customers(corpName, registrationDate, financialCode, customerNumber)" +
                            "VALUES ('%s','%s','%s','%s')",
                    customer.getCorpName(),
                    customer.getRegistrationDate(),
                    customer.getFinancialCode(),
                    customer.getCustomerNumber())
            );
        }
    }

    public static ResultSet selectReal(String conditionQuery) throws SQLException {
        Connection con = DBWorker.dbConnection();
        Statement stmt = con.createStatement();
        if (conditionQuery.isEmpty()) {
            return stmt.executeQuery("SELECT * FROM real_customers");
        } else {
            return stmt.executeQuery("SELECT * FROM real_customers WHERE " + conditionQuery);
        }
    }

    public static ResultSet selectLegal(String conditionQuery) throws SQLException {
        Connection con = DBWorker.dbConnection();
        Statement stmt = con.createStatement();
        if (conditionQuery.isEmpty()) {
            return stmt.executeQuery("SELECT * FROM legal_customers");
        } else {
            return stmt.executeQuery("SELECT * FROM legal_customers WHERE " + conditionQuery);
        }
    }


}
