package com.physr;

import com.physr.exercises.Exercise;
import com.physr.utilities.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetExercises {

    public void showExcercises() throws SQLException {
        try (
                Connection conn = DBUtil.getConnection();
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery("SELECT * FROM exercises");
        ) {

            ArrayList<Exercise> myExercises = new ArrayList<Exercise>();

            while (rs.next()) {
                Exercise ex = new Exercise();
                ex.setID(rs.getInt("ID"));
                ex.setName(rs.getString("Name"));
                ex.setDescription(rs.getString("Description"));
                ex.setReps(rs.getInt("Repetitions"));
                myExercises.add(ex);
            }

            for (Exercise ex: myExercises) {
                ex.display();
            }


        } catch (SQLException e) {
            DBUtil.showErrorMessage(e);
        }
    }

    public void updateReps(int exeID) throws SQLException{
        String sql = "SELECT ID, Name, Repetitions  FROM exercises WHERE ID = ?";
        ResultSet rs = null;
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ) {
            pstmt.setInt(1, exeID);

            rs = pstmt.executeQuery();
            rs.first();
            int reps = rs.getInt("Repetitions") + 1;
            rs.updateInt("Repetitions", reps);
            rs.updateRow();

            System.out.println("Reps Updated to: " + reps);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Failed SQL: " + e.getMessage());
            }
        }
    }

    public void insertClient(String fname, String lname) throws SQLException {
        try (
                Connection conn = DBUtil.getConnection();
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT ID, Firstname, Lastname  FROM clients");
        ) {
            rs.moveToInsertRow();
            rs.updateString("Firstname", fname);
            rs.updateString("Lastname", lname);
            rs.insertRow();
        }
    }
}
