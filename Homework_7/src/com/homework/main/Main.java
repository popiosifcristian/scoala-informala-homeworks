package com.homework.main;

/**
 * Created by Joseph Wednesday, 15.02.2017 at 23:51.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        StudentsManagement sm = new StudentsManagement();
        UniversityManagement um = new UniversityManagement();

        //tests for exceptions

        sm.addStudent(um.list,"Pop","Iosif","1997-May-28",'m',"1000");
        sm.addStudent(um.list,"Sipos","Andrei","1992-Oct-22",'M',"1");
        sm.addStudent(um.list,"Sas","Alexandru","1997-May-06",'n',"1004");
        sm.addStudent(um.list,"Iluc","Paul","1980-Jun-27",'M',"1003");
        sm.addStudent(um.list,"","Marco","1997-Nov-28",'M',"1002");
        sm.addStudent(um.list,"Igna","Eduard","1999-Jan-25",'M',"1006");
        sm.addStudent(um.list,"","","1000-Jan-25",'n',"");

        //tests for methods

//        sm.addStudent(um.list,"Pop","Iosif","1997-May-28",'M',"1000");
//        sm.addStudent(um.list,"Sipos","Andrei","1992-Oct-22",'M',"12");
//        sm.addStudent(um.list,"Sas","Alexandru","1997-May-06",'m',"1004");
//        sm.addStudent(um.list,"Iluc","Paul","1997-Jun-27",'M',"1003");
//        sm.addStudent(um.list,"Ariciu","Marco","1997-Nov-28",'M',"1002");
//        sm.addStudent(um.list,"Igna","Eduard","1997-Jan-25",'M',"1006");

        if (um.list.size()==0)
            System.out.println("In this University does not exist any Student");
        else
            System.out.println("University Students List: "+um.list.toString());
        System.out.println("======================================================================================");
        sm.deleteStudent(um.list,"1000");
        um.listStudentsWithAge(24);
        um.listStudentsByLastName();

    }
}
