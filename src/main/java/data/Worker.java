package main.java.data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

public class Worker {
    private int id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private long salary;
    private ZonedDateTime startDate;
    private LocalDate endDate;
    private Status status;
    private Person person;

    public Worker(String name,
                  Coordinates coordinates,
                  Date creationDate,
                  long salary,
                  ZonedDateTime startDate,
                  LocalDate endDate,
                  Status status,
                  Person person){
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate=creationDate;
        this.salary=salary;
        this.startDate=startDate;
        this.endDate=endDate;
        this.status=status;
        this.person=person;
    }
}