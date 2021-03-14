package util;

import data.*;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.NoSuchElementException;
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
                               Color hairColor, Country nationality) throws NullFieldException, IncorrectValueException{
        return createWorkerWithIdAndDate(++id, name,coordinates,salary,startDate,endDate,status,height,eyeColor,hairColor,nationality, new Date());
    }

    public Worker createWorkerWithIdAndDate(int _id, String name, Coordinates coordinates,
                               long salary, ZonedDateTime startDate,
                               LocalDate endDate, Status status,
                               Double height, Color eyeColor,
                               Color hairColor, Country nationality,
                                Date creationDate) throws NullFieldException, IncorrectValueException {
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
        return new Worker(name, coordinates, creationDate, salary, startDate, endDate, status, person, _id);
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
        Color eyeColor=null;
        Color hairColor=null;
        Country nationality=null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm:ss z");

        while (name==null){
            System.out.print("Enter worker's name: ");
            name=readLine();
            if(name==null){
                System.out.println("your input doesn't contain name, try again");
            }
        }

        while (x==null){
            System.out.print("Enter x coordinate: ");
            try {
                x = Long.parseLong(readLine());
            }
            catch (NumberFormatException e){
                System.out.println("your input doesn't contain coordinate, try again");
                x=null;
            }
        }

        while (y==null){
            System.out.print("Enter y coordinate: ");
            try {
                y = Long.parseLong(readLine());
            }
            catch (NumberFormatException e){
                System.out.println("your input doesn't contain coordinate, try again");
                y=null;
            }
        }

        while (salary==null){
            System.out.print("Enter salary: ");
            try {
                salary = Long.parseLong(readLine());
                if(salary!=null&&salary<=0){
                    System.out.println("Salary should be more than 0");
                    salary=null;
                }
            }
            catch (NumberFormatException e){
                System.out.println("your input doesn't contain salary, try again");
                salary=null;
            }
        }

        while (startDate==null){
            System.out.print("Enter start date: ");
            try {
                startDate = ZonedDateTime.parse(readLine(), formatter);
            }
            catch (NullPointerException e){
                System.out.println("your input doesn't contain date, try again");
                startDate=null;
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Your format is incorrect. Use yyyy-mm-dd hh:mm:ss +/-hh:mm");
            }
        }

        while (endDate==null){
            System.out.print("Enter end date: ");
            try {
                endDate = LocalDate.parse(readLine());
            }
            catch (NullPointerException e){
                System.out.println("your input doesn't contain date, try again");
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
            try {
                status = Status.valueOf(readLine().toUpperCase());
            }
            catch (IllegalArgumentException e){
                System.out.println("Your input doesn't contain any of possible states. Try again");
                status=null;
            }
            catch (NullPointerException e){
                System.out.println("Your input doesn't contain any of possible states. Try again");
                status=null;
            }
        }

        while (height==null)
        {
            System.out.print("Enter height: ");
            try {
                height = Double.parseDouble(readLine());
            }
            catch (NullPointerException e){
                System.out.println("your input doesn't contain height, try again");
                height=null;
            }
            if(height!=null) if(height<=0){
                System.out.println("Height should be more than 0");
                height=null;
            }
        }

        while(eyeColor==null){
            System.out.println("Enter one of following eyes colors: ");
            for (Color s : Color.values()) {
                System.out.println(s.toString());
            }
            try {
                eyeColor = Color.valueOf(readLine().toUpperCase());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Your input doesn't contain any of possible states. Try again");
                eyeColor = null;
            }
            catch (NullPointerException e){
                break;
            }
        }

        while (hairColor==null){
            System.out.println("Enter one of following hair colors: ");
            for (Color s : Color.values()) {
                System.out.println(s.toString());
            }
            try {
                hairColor = Color.valueOf(readLine().toUpperCase());
            }
            catch (IllegalArgumentException e) {
                System.out.println("Your input doesn't contain any of possible states. Try again");
                hairColor = null;
            }
            catch (NullPointerException e){
                break;
            }
        }

        while (nationality==null){
            System.out.println("Enter one of following countries: ");
            for(Country s:Country.values()){
                System.out.println(s.toString());
            }
            try {
                nationality = Country.valueOf(readLine().toUpperCase());
            }
            catch (IllegalArgumentException e){
                System.out.println("Your input doesn't contain any of possible countries. Try again");
                nationality=null;
            }
            catch (NullPointerException e){
                System.out.println("Your input doesn't contain any of possible countries. Try again");
                nationality=null;
            }
        }

        return createWorker(name,new Coordinates(x,y),salary,startDate,endDate,status,height,eyeColor,hairColor,nationality);
    }

    public void setScanner(Scanner s){
        scanner=s;
    }

    public Worker getFromCSV(String line, int num) throws IncorrectFileException, NullFieldException, IncorrectValueException {
        int id;
        String name;
        Coordinates coordinates;
        long salary;
        ZonedDateTime startDate;
        LocalDate endDate;
        Status status;
        Double height;
        Color eyeColor;
        Color hairColor;
        Country nationality;
        Date creationDate;
        String[] fields = line.split(",");
        if (fields.length != 13) {
            throw new IncorrectFileException(num);
        }
        try {
            id = Integer.parseInt(fields[0]);
        } catch (NumberFormatException e) {
            throw new IncorrectValueException("id", "unable to parse");
        }
        name = fields[1];
        if (name == "null") name = null;
        try {
            coordinates=new Coordinates(Long.parseLong(fields[2]), Long.parseLong(fields[3]));
        }catch (NumberFormatException e) {
            throw new IncorrectValueException("Coordinates", "unable to parse");
        }
        try{
            salary=Long.parseLong(fields[4]);
        }catch (NumberFormatException e) {
            throw new IncorrectValueException("Salary", "unable to parse");
        }
        try{
            startDate=ZonedDateTime.parse(fields[5]);
        }catch (DateTimeParseException e) {
            throw new IncorrectValueException("StartDate", "unable to parse");
        }
        try{
            endDate= LocalDate.parse(fields[6]);
        }catch (DateTimeParseException e) {
            throw new IncorrectValueException("StartDate", "unable to parse");
        }
        try {
            status=Status.valueOf(fields[7]);
        } catch (IllegalArgumentException e){
            if(fields[7]==null) throw new IncorrectValueException("Status value is incorrect");
            else throw new IncorrectValueException("Status", "unable to parse");
        }
        try{
            height=Double.parseDouble(fields[8]);
        } catch (NumberFormatException e){throw new IncorrectValueException("Height", "unable to parse");}
        try{
            eyeColor=Color.valueOf(fields[9]);
        } catch (IllegalArgumentException e){
            if(fields[9].equals("null")) eyeColor=null;
            else throw new IncorrectValueException("eyeColor", "unable to parse");
        }
        try{
            hairColor=Color.valueOf(fields[10]);
        } catch (IllegalArgumentException e){
            if(fields[10].equals("null")) hairColor=null;
            else throw new IncorrectValueException("hairColor", "unable to parse");
        }
        try {
            nationality=Country.valueOf(fields[11]);
        } catch (IllegalArgumentException e){
            if(fields[11].equals("null")) throw new IncorrectValueException("Nationality value is incorrect");
            else throw new IncorrectValueException("Nationality", "unable to parse");
        }
        try{
            creationDate= new Date(Long.parseLong(fields[12]));
        }catch (NumberFormatException e) {
            throw new IncorrectValueException("CreationDate", "unable to parse");
        }
        return createWorkerWithIdAndDate(id,name,coordinates,salary,startDate,endDate,status,height,eyeColor,hairColor, nationality,creationDate);
    }

    public String readLine(){
        String line;
        try {
            line = scanner.nextLine();
        }
        catch (NoSuchElementException e){
            line=null;
        }
        if(line.length()==0) line=null;
        return line;
    }

    public void setStartId(int newId){
        id=newId;
    }
}