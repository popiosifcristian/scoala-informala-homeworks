/**
 *This class is child of Person class 
 *We need this class for a better management of our University
 * @author Pop Iosif Cristian
 */
public class Student extends Person {
	private int studentId;//every student has an id
/**
  *This method will get us the  
 *id of our student
 * @return studentId  
 */
	public int getStudentId(){
		return studentId;
	}
/**
 *This method will help us to set or
 *change the id of our student
 *@param studentId 
 */
	public void setStudentId(int studentId){
		this.studentId=studentId;
	}
}