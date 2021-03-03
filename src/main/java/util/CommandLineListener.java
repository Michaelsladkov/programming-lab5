package main.java.util;

import main.java.command.Invoker;
import main.java.data.*;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineListener {
    private InputStream stream;
    private Scanner scanner;
    private String line;
    private Invoker invoker;
    private WorkerFactory factory;
    Pattern commandNamePattern;
    Pattern argsPattern;
    public CommandLineListener(Scanner s, Invoker i, WorkerFactory f){
        scanner=s;
        invoker=i;
        factory=f;
        commandNamePattern = Pattern.compile("^\\w+");
        argsPattern = Pattern.compile("\\b(\\w*\\s*)*");
    }

    public void setStream(InputStream stream){
        this.stream=stream;
        scanner=new Scanner(stream);
    }

    public void startRead(){
        String command;
        String args;
        do {
            line = scanner.nextLine();
            Matcher matcher = commandNamePattern.matcher(line);
            matcher.find();
            try{
                command=matcher.group();
            }
            catch (IllegalStateException e){
                System.out.println("Your input is not a command");
                command="";
            }
            line=line.substring(command.length());
            matcher = argsPattern.matcher(line);
            matcher.find();
            try{
                args=matcher.group();
            }
            catch (IllegalStateException e){
                args="";
            }
            invoker.execute(command,args);
        } while(!line.equals("stop"));
    }

    public Worker readWorker() throws NullFieldException, IncorrectValueException{
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

        while (name==null){
            System.out.print("Enter worker's name: ");
            name=scanner.findInLine("\\w+");
            if(name==null){
                System.out.print("your input doesn't contain name, try again");
            }
        }

        while (x==null){
            System.out.print("Enter x coordinate: ");
            try {
                x = scanner.nextLong();
            }
            catch (InputMismatchException e){
                System.out.print("your input doesn't contain coordinate, try again");
                x=null;
            }
        }

        while (y==null){
            System.out.print("Enter y coordinate: ");
            try {
                y = scanner.nextLong();
            }
            catch (InputMismatchException e){
                System.out.print("your input doesn't contain coordinate, try again");
                y=null;
            }
        }

        while (salary==null){
            System.out.print("Enter salary: ");
            try {
                salary = scanner.nextLong();
            }
            catch (InputMismatchException e){
                System.out.print("your input doesn't contain salary, try again");
                salary=null;
            }
            if(salary<=0){
                System.out.println("Salary should be more than 0");
                salary=null;
            }
        }

        while (startDate==null){
            System.out.print("Enter start date: ");
            try {
                startDate = ZonedDateTime.parse(scanner.next());
            }
            catch (InputMismatchException e){
                System.out.print("your input doesn't contain date, try again");
                startDate=null;
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
        }

        while (status==null){
            System.out.println("Enter on of following states: ");
            for(Status s:Status.values()){
                System.out.println(s.toString());
            }
            String preStatus=scanner.nextLine();
            try {
                status = Status.valueOf(preStatus);
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
            if(height<=0){
                System.out.println("Height should be more than 0");
                height=null;
            }
        }

        {
            System.out.println("Enter on of following eyes colors: ");
            for (Color s : Color.values()) {
                System.out.println(s.toString());
            }
            String preStatus = scanner.nextLine();
            try {
                eyeColor = Color.valueOf(preStatus);
            } catch (IllegalArgumentException e) {
                eyeColor = null;
            }
        }

        {
            System.out.println("Enter on of following hair colors: ");
            for (Color s : Color.values()) {
                System.out.println(s.toString());
            }
            String preStatus = scanner.nextLine();
            try {
                hairColor = Color.valueOf(preStatus);
            } catch (IllegalArgumentException e) {
                hairColor = null;
            }
        }

        while (nationality==null){
            System.out.println("Enter on of following countries: ");
            for(Country s:Country.values()){
                System.out.println(s.toString());
            }
            String preStatus=scanner.nextLine();
            try {
                nationality = Country.valueOf(preStatus);
            }
            catch (IllegalArgumentException e){
                System.out.println("Your input doesn't contain any of possible countries. Try again");
                nationality=null;
            }
        }

        return factory.createWorker(name,new Coordinates(x,y),salary,startDate,endDate,status,height,eyeColor,hairColor,nationality);
    }
}