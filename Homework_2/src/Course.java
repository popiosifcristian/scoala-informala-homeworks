/**
 *This is the main class of our University
 * @author Pop Iosif Cristian
 */
import java.util.List;
public class Course {
    private String name;//we need the name of the course
    private Room room;//we need a room for the course and we will use Room class that we already built
    private Teacher teacher;//we need a teacher for the course and we will use Teacher class that we already built
    private Student student;//we need at least one student for the course and we will use Student class that we already built
    private List<Integer> students;//or a list of students who will attend the course

    /**
     * This is the constructor of our class
     * The constructor will help us creating new Course objects
     * and it will initialize all major things that we need
     * for our course
     *
     * @param name will be the name of our course
     */
    public Course(String name) {
        this.name = name;
        this.room = new Room();
        this.teacher = new Teacher();
        this.student = new Student();
    }

    /**
     * This method will get us the
     * name of our course
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method will help us to set or
     * change the name of our course
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}