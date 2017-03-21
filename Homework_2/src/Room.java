/**
 *This class is a child of University class
 *We need this class for a better management of our University
 * @author Pop Iosif Cristian
 */
public class Room {
	private int roomId;//every room has an id
	private int availableSeats;//we must know how many seats we have for students
/**
 *This method will get us the id 
 *of our room
 * @return roomId 
 */
	public int getRoomId(){
		return roomId;
	}
/**
 *This method will help us to set or
 *change the id of our room
 *@param roomId  
 */
	public void setRoomId(int roomId){
		this.roomId=roomId;
	}
/**
 *This method will get us the available 
 *seats of the room for our students
 * @return availableSeats
 */
	public int getAvailableSeats(){
		return availableSeats;
	}
/**
 *This method will help us to set or
 *change the number of available seats from our room
 *@param availableSeats 
 */
	public void setAvailableSeats(int availableSeats){
		this.availableSeats=availableSeats;
	}
}