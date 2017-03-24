/**
 *This class is father of Teacher and Student 
 *classes and aims to define every person
 * @author Pop Iosif Cristian
 */
public class Person {
	private String name;//we need the name of the person
	private int cnp;//every person has an id, here in Romania it's named CNP
	private int age;//we need the age of the person
	private int phoneNumber;//we need the phone number of the person
	private String adress;//we need the adress of the person

/**
 *This method will get us the  
 *name of our person
 * @return name
 */
	public String getName(){
		return name;
	}
/**
 *This method will help us to set or
 *change the name of our person
 *@param name 
 */
	public void setName(String name){
		this.name=name;
	}
/**
 *This method will get us the  
 *cnp of our person
 * @return cnp
 */
	public int getCnp(){
		return cnp;
	}
/**
 *This method will help us to set or
 *change the cnp of our person
 *@param cnp
 */
	public void setCnp(int cnp){
		this.cnp=cnp;
	}
/**
 *This method will get us the  
 *age of our person
 * @return age 
 */
	public int getAge(){
		return age;
	}
/**
 *This method will help us to set or
 *change the age of our person
 *@param age 
 */
	public void setAge(int age){
		this.age=age;
	}
/**
 *This method will get us the  
 *phone number of our person
 * @return phoneNumber 
 */ 
	public int getPhoneNumber(){
		return phoneNumber;
	}
/**
 *This method will help us to set or
 *change the phone number of our person
 *@param phoneNumber 
 */
	public void setPhoneNumber(int phoneNumber){
		this.phoneNumber=phoneNumber;
	}
/**
  *This method will get us the  
 *adress of our person
 * @return adress 
 */
	public String getAdress(){
		return adress;
	}
/**
 *This method will help us to set or
 *change the adress of our person
 *@param adress 
 */
	public void setAdress(String adress){
		this.adress=adress;
	}	

}
