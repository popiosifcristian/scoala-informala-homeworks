package com.homework.main;

/**This is the com.homework.main.Student class and have the goal to define the student
 * @author Pop Iosif Cristian
 */
public class Student {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private char gender;
    private String id;


    public Student(String firstName, String lastName, String dateOfBirth, char gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }

    @Override
    public String toString() {
        return '\n'+"Student{" +
                "first name='" + firstName + '\'' +
                "last name='" + lastName + '\'' +
                "birth day='" + dateOfBirth + '\'' +
                "gender='" + gender + '\'' +
                "id='" + id + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
