package main.java.data;

public class Person {
    private Double height;
    private Color eyeColor;
    private Color hairColor;
    private Country nationality;

    public Person(Double height, Country nationality) throws  NullFieldException, IncorrectValueException{
        if(height==null){
            throw new NullFieldException("Height");
        }
        if(nationality==null){
            throw new NullFieldException("Nationality");
        }
        if(height<=0){
            throw new IncorrectValueException("Height", "Should be more than 0");
        }
        this.height=height;
        this.nationality=nationality;
    }
    public Person(Double height, Country nationality, Color eyeColor, Color hairColor) throws NullFieldException, IncorrectValueException{
        if(height==null){
            throw new NullFieldException("Height");
        }
        if(nationality==null){
            throw new NullFieldException("Nationality");
        }
        if(height<=0){
            throw new IncorrectValueException("Height", "Should be more than 0");
        }
        this.height=height;
        this.nationality=nationality;
        this.eyeColor=eyeColor;
        this.hairColor=hairColor;
    }
}