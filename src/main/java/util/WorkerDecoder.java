package main.java.util;

import main.java.data.Person;
import main.java.data.Worker;

public class WorkerDecoder {
    public void describe( Worker w){
        System.out.println("Worker");
        System.out.println("id: "+w.getId());
        System.out.println("Name:"+w.getName());
        System.out.println("Coordinates: "+"("+w.getCoordinates().getX()+", "+w.getCoordinates().getY()+")");
        System.out.println("Start date: "+w.getCreationDate());
        System.out.println("Salary: "+w.getSalary());
        System.out.println("Personal stats:");
        Person p = w.getPerson();
        System.out.println("Height: "+p.getHeight());
        System.out.println("Eye color: "+p.getEyeColor());
        System.out.println("Hair color: "+p.getHairColor());
        System.out.println("Nationality: "+p.getNationality());
    }
}
