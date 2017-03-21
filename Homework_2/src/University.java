/**
 *This class is father of Room class and
 *aims to define the University location
 * @author Pop Iosif Cristian
 */
public class University {
	private String location;//every University has a location
/**
 *This method will get us the location
 *of university
 * @return location of university
 */
	public String getLocation(){
		return location;
	}
/**
 *This method will help us to set or
 *change the location of university
 *@param location of university 
 */
	public void setLocation(String location){
		this.location=location;
	}
}