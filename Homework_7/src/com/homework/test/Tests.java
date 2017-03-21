package com.homework.test;
import com.homework.main.Student;
import com.homework.main.StudentsManagement;
import com.homework.main.UniversityManagement;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph Thursday, 16.02.2017 at 01:03.
 *
 * @author Pop Iosif Cristian
 * @version 1.0
 */
public class Tests {
    @Test
    public void valid_name(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertTrue(sm.nameValidation("Joseph"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_name(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertFalse(sm.nameValidation(""));
    }

    @Test
    public void valid_age(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertTrue(sm.ageValidation("1997-May-28"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_empty_age(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertFalse(sm.ageValidation(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_age(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertFalse(sm.ageValidation("1998-May-28"));
    }

    @Test
    public void valid_gender(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertTrue(sm.genderValidation('m'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_empty_gender(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertFalse(sm.genderValidation(' '));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_gender(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertFalse(sm.genderValidation('n'));
    }

    @Test
    public void valid_id(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertTrue(sm.idValidation("123321"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalid_id(){
        StudentsManagement sm = new StudentsManagement();
        Assert.assertFalse(sm.idValidation(""));
    }

    @Test
    public void add_student(){
        List<Student> list = new ArrayList<Student>();
        StudentsManagement sm = new StudentsManagement();
        sm.addStudent(list,"Pop","Iosif","1997-May-28",'M',"1000");
        Assert.assertEquals(list.size(),1);
    }

    @Test
    public void add_invalid_name_student(){
        List<Student> list = new ArrayList<Student>();
        StudentsManagement sm = new StudentsManagement();
        sm.addStudent(list,"","Iosif","1997-May-28",'M',"1000");
        Assert.assertEquals(list.size(),0);
    }

    @Test
    public void add_invalid_age_student(){
        List<Student> list = new ArrayList<Student>();
        StudentsManagement sm = new StudentsManagement();
        sm.addStudent(list,"Pop","Iosif","1998-May-28",'M',"1000");
        Assert.assertEquals(list.size(),0);
    }

    @Test
    public void add_invalid_gender_student(){
        List<Student> list = new ArrayList<Student>();
        StudentsManagement sm = new StudentsManagement();
        sm.addStudent(list,"Pop","Iosif","1997-May-28",'n',"1000");
        Assert.assertEquals(list.size(),0);
    }

    @Test
    public void add_invalid_id_student(){
        List<Student> list = new ArrayList<Student>();
        StudentsManagement sm = new StudentsManagement();
        sm.addStudent(list,"Pop","Iosif","1997-May-28",'m',"");
        Assert.assertEquals(list.size(),0);
    }

    @Test
    public void delete_student(){
        List<Student> list = new ArrayList<Student>();
        StudentsManagement sm = new StudentsManagement();
        sm.addStudent(list,"Pop","Iosif","1997-May-28",'M',"1000");
        sm.deleteStudent(list,"1000");
        Assert.assertEquals(list.size(),0);
    }

    @Test
    public void delete_invalid_id(){
        List<Student> list = new ArrayList<Student>();
        StudentsManagement sm = new StudentsManagement();
        sm.addStudent(list,"Pop","Iosif","1997-May-28",'M',"1000");
        sm.deleteStudent(list,"1");
        Assert.assertEquals(list.size(),1);
    }

    @Test
    public void list_by_age(){
        StudentsManagement sm = new StudentsManagement();
        UniversityManagement um = new UniversityManagement();
        sm.addStudent(um.list,"Sipos","Andrei","1992-Oct-22",'M',"12");
        String res = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(os);
            System.setOut(capture);
            um.listStudentsWithAge(24);
            capture.flush();
            res = os.toString();
        } finally {
            System.setOut(originalOut);
        }
        String s="University Students List of students with this age: 24\n" +
                "\n" +
                "Student{first name='Sipos'last name='Andrei'birth day='1992-Oct-22'gender='M'id='12'}\n" +
                "======================================================================================"+"\n";
        Assert.assertEquals(res,s);
    }

    @Test
    public void list_nobody_by_age(){
        StudentsManagement sm = new StudentsManagement();
        UniversityManagement um = new UniversityManagement();
        sm.addStudent(um.list,"Sipos","Andrei","1992-Oct-22",'M',"12");
        String res = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(os);
            System.setOut(capture);
            um.listStudentsWithAge(25);
            capture.flush();
            res = os.toString();
        } finally {
            System.setOut(originalOut);
        }
        String s="In this University does not exist a Student with this age: 25\n" +
                "======================================================================================"+"\n";
        Assert.assertEquals(res,s);
    }

    @Test
    public void list_students_by_last_name(){
        StudentsManagement sm = new StudentsManagement();
        UniversityManagement um = new UniversityManagement();
        sm.addStudent(um.list,"Pop","Iosif","1997-May-28",'M',"1000");
        sm.addStudent(um.list,"Sipos","Andrei","1992-Oct-22",'M',"12");
        sm.addStudent(um.list,"Sas","Alexandru","1997-May-06",'m',"1004");
        sm.addStudent(um.list,"Iluc","Paul","1997-Jun-27",'M',"1003");
        sm.addStudent(um.list,"Ariciu","Marco","1997-Nov-28",'M',"1002");
        sm.addStudent(um.list,"Igna","Eduard","1997-Jan-25",'M',"1006");        String res = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(os);
            System.setOut(capture);
            um.listStudentsByLastName();
            capture.flush();
            res = os.toString();
        } finally {
            System.setOut(originalOut);
        }
        String s="University Students List sorted by Last Name: [\n" +
                "Student{first name='Sas'last name='Alexandru'birth day='1997-May-06'gender='m'id='1004'}, \n" +
                "Student{first name='Sipos'last name='Andrei'birth day='1992-Oct-22'gender='M'id='12'}, \n" +
                "Student{first name='Igna'last name='Eduard'birth day='1997-Jan-25'gender='M'id='1006'}, \n" +
                "Student{first name='Pop'last name='Iosif'birth day='1997-May-28'gender='M'id='1000'}, \n" +
                "Student{first name='Ariciu'last name='Marco'birth day='1997-Nov-28'gender='M'id='1002'}, \n" +
                "Student{first name='Iluc'last name='Paul'birth day='1997-Jun-27'gender='M'id='1003'}]\n" +
                "======================================================================================\n";
        Assert.assertEquals(res,s);
    }

    @Test
    public void list_nobody_by_last_name(){
        StudentsManagement sm = new StudentsManagement();
        UniversityManagement um = new UniversityManagement();
        String res = null;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(os);
            System.setOut(capture);
            um.listStudentsByLastName();
            capture.flush();
            res = os.toString();
        } finally {
            System.setOut(originalOut);
        }
        String s="In this University does not exist any Student\n" +
                "======================================================================================\n";
        Assert.assertEquals(res,s);
    }

}
