/**This class is a child of class Book
 * We need this class to define Novel
 * @author Pop Iosif Cristian
 * @version 1.0
 * @date 15.12.2016
 */
public class Novel extends Book {
    private String type;//this is the special feature of Novel

    /**
     * This is the constructor of Novel class
     * He will help us to create new Novel objects
     * @param name is a String and it will contain name of our Novel
     * @param pagesNumber is an int and it will contain number of pages from our Novel
     * @param type is a String and it will contain the type of our Novel
     */
    public Novel(String name, int pagesNumber, String type){
        super(name,pagesNumber);
        this.type=type;
    }
    /**
     * This method will get us type of our Novel
     * @return type
     */
    public String getType(){
        return type;
    }
    /**
     * This method will help us to print the features of our Novel object
     */
    @Override
    public void getInfo(){
        System.out.println("[Novel:] "+this.getName()+" [Pages:] "+this.getPagesNumber()+" [Type:] "+this.getType());
    }
}
