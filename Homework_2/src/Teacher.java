/**
 *This class is a child of Person class
 *We need this class for a better management of our University
 * @author Pop Iosif Cristian
 */
public class Teacher extends Person {
	private int teacherId;//every teacher has an id
	private int salary;//salary it's an important factor for every teacher
/**
 *This method will get us the  
 *id of our teacher
 * @return teacherId 
 */
	public int getTeacherId(){
		return teacherId;
	}
/**
 *This method will help us to set or
 *change the id of our teacher
 *@param teacherId  
 */
	public void setTeacherId(int teacherId){
		this.teacherId=teacherId;
	}
/**
 *This method will get us the  
 *salary of our teacher
 * @return salary  
 */
	public int getSalary(){
		return salary;
	}
/**
 *This method will help us to set or
 *change the salary of our teacher
 *@param salary 
 */
	public void setSalary(int salary){
		this.salary=salary;
	}
}