package main.java.data;

public class Person {
    private final Double height;
    private final Color eyeColor;
    private final Color hairColor;
    private final Country nationality;

    public Person(Double height, Country nationality, Color eyeColor, Color hairColor){
        this.height=height;
        this.nationality=nationality;
        this.eyeColor=eyeColor;
        this.hairColor=hairColor;
    }

    public Double getHeight(){return height;}

    public Color getEyeColor(){return eyeColor;}

    public Color getHairColor(){return hairColor;}

    public Country getNationality(){return nationality;}
}