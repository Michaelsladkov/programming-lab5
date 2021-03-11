package util;

import data.Person;
import data.Worker;

public class WorkerDecoder {
    public void describe( Worker w){
        System.out.println("Worker");
        System.out.println("id: "+w.getId());
        System.out.println("Name:"+w.getName());
        System.out.println("Coordinates: "+"("+w.getCoordinates().getX()+", "+w.getCoordinates().getY()+")");
        System.out.println("Salary: "+w.getSalary());
        System.out.println("Start date: "+w.getStartDate().toString());
        System.out.println("End date: "+w.getEndDate().toString());
        System.out.println("Status: "+w.getStatus());
        System.out.println("Personal stats:");
        Person p = w.getPerson();
        System.out.println("\tHeight: "+p.getHeight());
        System.out.println("\tEye color: "+p.getEyeColor());
        System.out.println("\tHair color: "+p.getHairColor());
        System.out.println("\tNationality: "+p.getNationality());
        System.out.println("Creation time: "+w.getCreationDate());
    }

    public String getCSVLine(Worker w){
        String output="";
        output+=w.getId()+",";
        output+=w.getName()+",";
        output+=w.getCoordinates().getX()+",";
        output+=w.getCoordinates().getY()+",";
        output+=w.getSalary()+",";
        output+=w.getStartDate().toString()+",";
        output+=w.getEndDate().toString()+",";
        output+=w.getStatus()+",";
        Person p = w.getPerson();
        output+=p.getHeight()+",";
        output+=p.getEyeColor()+",";
        output+=p.getHairColor()+",";
        output+=p.getNationality()+",";
        output+=w.getCreationDate().toString();
        return output;
    }
}
