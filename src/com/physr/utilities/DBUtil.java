package com.physr.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String mySqlUser = "root";
    private static final String mySqlPwd = "R00tP@$$w0rd";
    private static final String mySQLCS = "jdbc:mysql://localhost:3306/physr";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(mySQLCS, mySqlUser, mySqlPwd);
    }

    public static void showErrorMessage(SQLException e){
        System.err.println("Error: " + e.getMessage());
        System.err.println("Error Code: " + e.getErrorCode());
    }
}
