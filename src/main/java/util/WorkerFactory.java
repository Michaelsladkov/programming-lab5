package util;

import data.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class WorkerFactory {
    private int id;
    private Scanner scanner;
    private final FieldsReader fieldsReader;

    public WorkerFactory(int startId, FieldsReader fieldsReader){
        this.id = startId;
        this.fieldsReader = fieldsReader;
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
        fieldsReader.setScanner(scanner);
                return createWorker(
                fieldsReader.readName(),
                new Coordinates(fieldsReader.readCoordinate('x'),fieldsReader.readCoordinate('y')),
                fieldsReader.readSalary(),
                fieldsReader.readStartDate(),
                fieldsReader.readEndDate(),
                fieldsReader.readStatus(),
                fieldsReader.readHeight(),
                fieldsReader.readColor("eye color"),
                fieldsReader.readColor("hair color"),
                fieldsReader.readNationality()
        );
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
        double height;
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
        if (name.equals("null")) name = null;
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

    public void setStartId(int newId){
        id=newId;
    }
}