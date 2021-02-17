package main.java.data;

public class Person {
    private Double height;
    private Color eyeColor;
    private Color hairColor;
    private Country nationality;

    public Person(Double height, Country nationality, Color eyeColor, Color hairColor){
        this.height=height;
        this.nationality=nationality;
        this.eyeColor=eyeColor;
        this.hairColor=hairColor;
    }
}