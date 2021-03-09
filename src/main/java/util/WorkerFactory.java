package main.java.util;

import main.java.data.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.time.format.DateTimeFormatter.ISO_DATE;

public class WorkerFactory {
    private int id;
    private Scanner scanner;

    public WorkerFactory(int startId){
        this.id=startId;
    }

    public Worker createWorker(String name, Coordinates coordinates,
                               long salary, ZonedDateTime startDate,
                               LocalDate endDate, Status status,
                               Double height, Color eyeColor,
                               Color hairColor, Country nationality) throws NullFieldException, IncorrectValueException {
        if(name==null||name.length()==0){
            throw new NullFieldException("Name");
        }
        if(coordinates==null){
            throw new NullFieldException("Coordinates");
        }
        if(salary<=0){
            throw new IncorrectValueException("Salary", "Should be more than 0");
        }
        if(startDate==null){
            throw new NullFieldException("Start date");
        }
        if(endDate==null){
            throw new NullFieldException("End date");
        }
        if (status==null){
            throw new NullFieldException("Status");
        }
        if(height==null){
            throw new NullFieldException("Height");
        }
        if(nationality==null){
            throw new NullFieldException("Nationality");
        }
        if(height<=0){
            throw new IncorrectValueException("Height", "Should be more than 0");
        }
        Person person=new Person(height, nationality, eyeColor, hairColor);
        return new Worker(name, coordinates, new Date(), salary, startDate, endDate, status, person, id++);
    }

    public Worker readWorkerFromConsole() throws NullFieldException, IncorrectValueException{
        String name=null;
        Long x=null;
        Long y=null;
        Long salary=null;
        ZonedDateTime startDate=null;
        LocalDate endDate=null;
        Status status=null;
        Double height=null;
        Color eyeColor;
        Color hairColor;
        Country nationality=null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a z");

        while (name==null){
            System.out.print("Enter worker's name: ");
            name=scanner.findInLine("\\w+");
            if(name==null){
                System.out.print("your input doesn't contain name, try again");
                while (scanner.nextLine().isEmpty()){}
            }
        }

        while (x==null){
            System.out.print("Enter x coordinate: ");
            try {
                x = scanner.nextLong();
            }
            catch (InputMismatchException e){
                System.out.println("your input doesn't contain coordinate, try again");
                x=null;
                while (scanner.nextLine().isEmpty()){}
            }
        }

        while (y==null){
            System.out.print("Enter y coordinate: ");
            try {
                y = scanner.nextLong();
            }
            catch (InputMismatchException e){
                System.out.println("your input doesn't contain coordinate, try again");
                y=null;
                while (scanner.nextLine().isEmpty()){}
            }
        }

        while (salary==null){
            System.out.print("Enter salary: ");
            try {
                salary = scanner.nextLong();
                if(salary<=0){
                    System.out.println("Salary should be more than 0");
                    salary=null;
                    while (scanner.nextLine().isEmpty()){}
                }
            }
            catch (InputMismatchException e){
                System.out.println("your input doesn't contain salary, try again");
                salary=null;
                while (scanner.nextLine().isEmpty()){}
            }
        }

        while (startDate==null){
            System.out.print("Enter start date: ");
            String preDate;
            while((preDate=scanner.nextLine()).isEmpty()){}
            try {
                startDate = ZonedDateTime.parse(preDate, formatter);
            }
            catch (InputMismatchException e){
                System.out.print("your input doesn't contain date, try again");
                startDate=null;
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Your format is incorrect. Use yyyy-mm-dd hh:mm:ss AM/PM +/-hh:mm");
            }
        }

        while (endDate==null){
            System.out.print("Enter end date: ");
            try {
                endDate = LocalDate.parse(scanner.next());
            }
            catch (InputMismatchException e){
                System.out.print("your input doesn't contain date, try again");
                startDate=null;
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Your format is incorrect. Use yyyy-mm-dd");
            }
        }

        while (status==null){
            System.out.println("Enter one of following states: ");
            for(Status s:Status.values()){
                System.out.println(s.toString());
            }
            String preStatus;
            while ((preStatus=scanner.nextLine()).isEmpty()){}
            try {
                status = Status.valueOf(preStatus.toUpperCase());
            }
            catch (IllegalArgumentException e){
                System.out.println("Your input doesn't contain any of possible states. Try again");
                status=null;
            }
        }

        while (height==null)
        {
            System.out.print("Enter height: ");
            try {
                height = scanner.nextDouble();
            }
            catch (InputMismatchException e){
                System.out.print("your input doesn't contain height, try again");
                height=null;
            }
            if(height!=null) if(height<=0){
                System.out.println("Height should be more than 0");
                height=null;
            }
        }

        {
            System.out.println("Enter one of following eyes colors: ");
            for (Color s : Color.values()) {
                System.out.println(s.toString());
            }
            String preColor;
            while((preColor=scanner.nextLine()).isEmpty()){}
            try {
                eyeColor = Color.valueOf(preColor.toUpperCase());
            } catch (IllegalArgumentException e) {

                eyeColor = null;
            }
        }

        {
            System.out.println("Enter one of following hair colors: ");
            for (Color s : Color.values()) {
                System.out.println(s.toString());
            }
            String preStatus = scanner.nextLine();
            try {
                hairColor = Color.valueOf(preStatus.toUpperCase());
            } catch (IllegalArgumentException e) {
                hairColor = null;
            }
        }

        while (nationality==null){
            System.out.println("Enter one of following countries: ");
            for(Country s:Country.values()){
                System.out.println(s.toString());
            }
            String preNation;
            while((preNation=scanner.nextLine()).isEmpty()){}
            try {
                nationality = Country.valueOf(preNation.toUpperCase());
            }
            catch (IllegalArgumentException e){
                System.out.println("Your input doesn't contain any of possible countries. Try again");
                nationality=null;
            }
        }

        return createWorker(name,new Coordinates(x,y),salary,startDate,endDate,status,height,eyeColor,hairColor,nationality);
    }

    public void setScanner(Scanner s){
        scanner=s;
    }
}
