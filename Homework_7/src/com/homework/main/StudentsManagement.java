package com.homework.main;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

/**This is Students Management class and have the goal to manage all students,
 * to add students or delete students by id
 * @author Pop Iosif Cristian
 */
public class StudentsManagement {
    private static final Logger LOGGER=Logger.getLogger("studentsManagementLogger");

    /**
     * In this method will add students in repository if the input values have
     * valid values for our students else will catch the exception and will print
     * the last line of stacktrace(with info of where our invalid input is)
     */
    public void addStudent(List<Student> list,String firstName, String lastName, String dateOfBirth, char gender, String id){
       try {
           if (nameValidation(firstName) && nameValidation(lastName) && ageValidation(dateOfBirth) && genderValidation(gender)&&idValidation(id))
               list.add(new Student(firstName, lastName, dateOfBirth, gender, id));
       }catch (IllegalArgumentException e){
           StackTraceElement[] elements = e.getStackTrace();
           System.err.println(elements[elements.length-1]);
       }
    }

    /**
     * this method will delete a student by id
     * and will print the university list after deletion
     */
    public void deleteStudent(List<Student> list,String id){
        Object o = new Object();

        for(Student student : list){
            if(student.getId().equals(id))
                o=student;
        }
        if (list.remove(o)){
            list.remove(o);
            System.out.println("University Students List after deleting the Student with this id: "+id+" "+
                    list.toString());
        }
        else
            System.out.println("In this University does not exist a Student with this id: "+id);
        System.out.println("======================================================================================");

    }

    /**This method will verify if the name is valid
     * @param name of a student
     * @return true if the name is not empty
     */
    public boolean nameValidation(String name){
        if (name.equals("")) {
            LOGGER.info("empty name ");
            throw new IllegalArgumentException("empty name");
        }else
        return true;
    }

    /**This method will verify if the age is valid
     * @param dateOfBirth of a student
     * @return true if date of birth between is 1900 and current year - 18
     */
    public boolean ageValidation(String dateOfBirth){
        if (dateOfBirth.equals("")){
            LOGGER.info("invalid age ");
            throw new IllegalArgumentException("invalid age");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");//this will help us to convert string to Local Date
        LocalDate birthDay = LocalDate.parse(dateOfBirth, formatter);
        Period period = Period.between(birthDay, LocalDate.now());
        if(birthDay.getYear()<1990||period.getYears()<=18){
            LOGGER.info("invalid age ");
            throw new IllegalArgumentException("invalid age");
        }
        return true;
    }

    /**This method will verify if the gender is valid
     * @param gender of a student
     * @return true if gender is M or F(lower case are accepted too)
     */
    public boolean genderValidation(char gender){
        if (gender!='m'&&gender!='M'&&gender!='f'&&gender!='F') {
            LOGGER.info("invalid gender ");
            throw new IllegalArgumentException("invalid gender");
        }
            return true;
    }

    /**This method will verify if the id
     * @param id of a student
     * @return true if the id is not empty
     */
    public boolean idValidation(String id){
        if (id.equals("")){
            LOGGER.info("empty id ");
            throw new IllegalArgumentException("empty id");
        }
        return true;
    }

}
