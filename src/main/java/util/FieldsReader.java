package util;

import data.Color;
import data.Country;
import data.NullFieldException;
import data.Status;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FieldsReader {
    private Scanner scanner;
    public FieldsReader(Scanner scanner){
        this.scanner = scanner;
    }

    public void setScanner(Scanner newScanner){
        scanner=newScanner;
    }

    public String readName(){
        String name = null;
        while (name == null){
            System.out.print("Enter worker's name: ");
            name = readLine();
            if(name == null){
                System.out.println("your input doesn't contain name, try again");
            }
        }
        return name;
    }

    public Long readCoordinate(char axis){
        Long coordinate = null;
        while (coordinate == null){
            System.out.print("Enter "+axis+" coordinate: ");
            try {
                coordinate = Long.parseLong(readLine());
            }
            catch (NumberFormatException e){
                System.out.println("your input doesn't contain coordinate, try again");
                coordinate = null;
            }
        }
        return coordinate;
    }

    public Long readSalary(){
        Long salary = null;
        while (salary == null){
            System.out.print("Enter salary: ");
            try {
                salary = Long.parseLong(readLine());
                if(salary<=0){
                    System.out.println("Salary should be more than 0");
                    salary=null;
                }
            }
            catch (NumberFormatException e){
                System.out.println("your input doesn't contain salary, try again");
                salary = null;
            }
        }
        return salary;
    }

    public String readLine(){
        String line;
        try {
            line = scanner.nextLine();
            if(line.length()==0) line = null;
        }
        catch (NoSuchElementException e){
            line = null;
        }
        return line;
    }

    public ZonedDateTime readStartDate(){
        ZonedDateTime startDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm:ss z");
        while (startDate==null){
            System.out.print("Enter start date: ");
            try {
                startDate = ZonedDateTime.parse(readLine(), formatter);
            }
            catch (NullPointerException e){
                System.out.println("your input doesn't contain date, try again");
                startDate = null;
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Your format is incorrect. Use yyyy-mm-dd hh:mm:ss +/-hh:mm");
            }
        }
        return  startDate;
    }

    public LocalDate readEndDate(){
        LocalDate endDate = null;
        while (endDate == null){
            System.out.print("Enter end date: ");
            try {
                endDate = LocalDate.parse(readLine());
            }
            catch (NullPointerException e){
                System.out.println("your input doesn't contain date, try again");
                endDate = null;
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Your format is incorrect. Use yyyy-mm-dd");
            }
        }
        return endDate;
    }

    public Color readColor(String fieldName){
        Color color = null;
        while(color == null){
            System.out.println("Enter one of following values for "+fieldName+" : ");
            for (Color decalredColor : Color.values()) {
                System.out.println(decalredColor.toString());
            }
            try {
                color = Color.valueOf(readLine().toUpperCase());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Your input doesn't contain any of possible states. Try again");
                color = null;
            }
            catch (NullPointerException e){
                break;
            }
        }
        return color;
    }

    public Status readStatus(){
        Status status = null;
        while (status==null){
            System.out.println("Enter one of following states: ");
            for(Status declaredStatus:Status.values()){
                System.out.println(declaredStatus.toString());
            }
            try {
                status = Status.valueOf(readLine().toUpperCase());
            }
            catch (IllegalArgumentException| NullPointerException e){
                System.out.println("Your input doesn't contain any of possible states. Try again");
                status = null;
            }
        }
        return status;
    }

    public Double readHeight(){
        Double height = null;
        while (height == null)
        {
            System.out.print("Enter height: ");
            try {
                height = Double.parseDouble(readLine());
            }
            catch (NullPointerException e){
                System.out.println("your input doesn't contain height, try again");
                height = null;
            }
            if(height!=null) if(height<=0){
                System.out.println("Height should be more than 0");
                height = null;
            }
        }
        return height;
    }

    public Country readNationality(){
        Country nationality = null;
        while (nationality == null){
            System.out.println("Enter one of following countries: ");
            for(Country declaredCountry:Country.values()){
                System.out.println(declaredCountry.toString());
            }
            try {
                nationality = Country.valueOf(readLine().toUpperCase());
            }
            catch (IllegalArgumentException e){
                System.out.println("Your input doesn't contain any of possible countries. Try again");
                nationality = null;
            }
            catch (NullPointerException e){
                System.out.println("Your input doesn't contain any of possible countries. Try again");
                nationality = null;
            }
        }
        return nationality;
    }
}