Model a management application for a university
Create the class structure for a university. Think of entities like Person, Student, Course, Room, Teacher etc. Write the structure in java code with relations between classes (inheritance/composition).

For example a course might have a room, a teacher, some students, a week day and an hour:

public class Course {
    public Room room;
    public Teacher teacher;
    public Student[] students;
    public int weekDay;
    public int hour;
}
Do not forget about javadoc and java naming conventions!

