package com.physr;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Exercises ex = new Exercises();
        try {
            ex.showExcercises();
        } catch (SQLException e)
        {

        }

    }


}
