package main.java.util;

import main.java.data.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

public class WorkerFactory {
    private int startId;
    public WorkerFactory(int startId){
        this.startId=startId;
    }
    public Worker createWorker(String name, Coordinates coordinates,
                               long salary, ZonedDateTime startDate,
                               LocalDate endDate, Status status) throws NullFieldException, IncorrectValueException {
        if(name==null||name==""){
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
        return new Worker(name, coordinates, new Date(), salary,startDate,endDate,status,);
    }
}
