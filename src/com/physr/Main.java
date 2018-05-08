package com.physr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.physr.utilities.DBUtil;

public class Main {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM exercise");
            rs.last();

            System.out.println("Total no rows: " + rs.getRow());


        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }
        finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(stmt != null) {
                    stmt.close();
                }
                if(conn != null) {
                    conn.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
