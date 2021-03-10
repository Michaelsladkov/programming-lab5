package util;

import data.Person;
import data.Worker;

public class WorkerDecoder {
    public void describe( Worker w){
        System.out.println("Worker");
        System.out.println("id: "+w.getId());
        System.out.println("Name:"+w.getName());
        System.out.println("Coordinates: "+"("+w.getCoordinates().getX()+", "+w.getCoordinates().getY()+")");
        System.out.println("Start date: "+w.getCreationDate().toString());
        System.out.println("Salary: "+w.getSalary());
        System.out.println("Personal stats:");
        Person p = w.getPerson();
        System.out.println("\tHeight: "+p.getHeight());
        System.out.println("\tEye color: "+p.getEyeColor());
        System.out.println("\tHair color: "+p.getHairColor());
        System.out.println("\tNationality: "+p.getNationality());
    }

    public String getCSVLine(Worker w){
        String output="";
        output+=w.getId()+",";
        output+=w.getName()+",";
        output+=w.getCoordinates().getX()+",";
        output+=w.getCoordinates().getY()+",";
        output+=w.getCreationDate().toString()+",";
        output+=w.getSalary()+",";
        Person p = w.getPerson();
        output+=p.getHeight()+",";
        output+=p.getEyeColor()+",";
        output+=p.getHairColor()+",";
        output+=p.getNationality();
        return output;
    }
}
