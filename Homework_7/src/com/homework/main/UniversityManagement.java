package com.homework.main;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Pop Iosif Cristian
 */
public class UniversityManagement {
    public List<Student> list = new ArrayList<Student>();//our student repository

    /**
     * this method will list all students with a specific age
     * we will calculate age of our all students using Local Date , Data Time Formatter and Period
     * When we find a student with the specific age we will print him
     */
    public void listStudentsWithAge(int age){
        boolean ok=false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");//this will help us to convert string to Local Date
        LocalDate today = LocalDate.now();
        for(Student student : list){
            LocalDate birthDay=LocalDate.parse(student.getDateOfBirth(), formatter);
            Period period = Period.between(birthDay, today);
            if (period.getYears()==age&&!ok){
                System.out.println("University Students List of students with this age: "+age);
                ok=true;
            }
            if (period.getYears()==age){
                System.out.println(student.toString());}
        }
        if (!ok)
            System.out.println("In this University does not exist a Student with this age: "+age);

        System.out.println("======================================================================================");

    }

    /**
     * this is the name comparator. he will help us sort our list by last name
     */
    static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    }

    /**
     * this method will sort and list our list by last name using the name comparator
     */
    public void listStudentsByLastName(){
        if (list.size()==0)
            System.out.println("In this University does not exist any Student");
        else {
            System.out.print("University Students List sorted by Last Name: ");
            Collections.sort(list, new NameComparator());
            System.out.println(list.toString());
        }
        System.out.println("======================================================================================");

    }
}
