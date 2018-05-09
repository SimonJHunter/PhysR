package com.physr.exercises;

public class Exercise extends ExerciseBase {

    public Exercise(){

    }

    public Exercise(int ID, String name, String description, int reps){
        super(ID, name, description, reps);
    }

    @Override
    public void display() {
        String format = "Name: %s \nDescription: %s \nReps: %d \n\n";
        System.out.format(format, getName(), getDescription(), getReps());
    }
}
