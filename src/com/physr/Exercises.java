package com.physr;

import com.physr.utilities.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercises  {

    public void showExcercises() throws SQLException {
        try (
                Connection conn = DBUtil.getConnection();
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM exercise");
        ) {


            String format = "Name: %s \nDescription: %s \n\n";
            while (rs.next()) {
                //System.out.println("Name: " + rs.getString("Name"));
                //System.out.println("Description: " + rs.getString("Description") + "\n");
                System.out.format(format, rs.getString("Name"), rs.getString("Description"));
            }


        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }
    }

    public void updateReps(int excerciseID, int value){
        
    }
}
