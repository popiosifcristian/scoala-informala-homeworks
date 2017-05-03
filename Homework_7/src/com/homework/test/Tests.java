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
}
