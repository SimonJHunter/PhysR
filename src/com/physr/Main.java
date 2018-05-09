package com.physr;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        GetExercises ex = new GetExercises();
        try {
            ex.showExcercises();

            //ex.updateReps(2);
            //ex.showExcercises();

            //ex.insertClient("Matt", "Fletcher");

        } catch (SQLException e)
        {

        }

    }


}
