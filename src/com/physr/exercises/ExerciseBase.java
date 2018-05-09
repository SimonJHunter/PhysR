package com.physr.exercises;

public abstract class ExerciseBase {

    private int ID;
    private String Name;
    private String Description;
    private int Reps;


    public ExerciseBase() {

    }

    public ExerciseBase(int ID, String name, String description, int reps) {
        this.ID = ID;
        Name = name;
        Description = description;
        Reps = reps;
    }

    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}
    public String getName() {return Name;}
    public void setName(String name) {Name = name;}
    public String getDescription() {return Description;}
    public void setDescription(String description) {Description = description;}
    public int getReps() {return Reps;}
    public void setReps(int reps) {Reps = reps;}

    public abstract void display();
}
