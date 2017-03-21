/**This class is father of Novel and ArtAlbum classes
 * We need this class to define Book
 * @author Pop Iosif Cristian
 * @version 1.0
 * @date 15.12.2016
 */
public class Book {
    private String name;//the name of the book
    private int pagesNumber;//number of pages of our book

    /**
     * This is the constructor of Book class
     * It will help us to create new Book objects
     * @param name is a String and it will contain name of our Book
     * @param pagesNumber is an int and it will contain number of pages from our Book
     */
    public Book(String name, int pagesNumber){
        this.name=name;
        this.pagesNumber=pagesNumber;
    }
    /**
     * This method will get us the name of our Book
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * This method will get us number of pages of our Book
     * @return pagesNumber
     */
    public int getPagesNumber(){
        return pagesNumber;
    }
    /**
     * This method will help us to print the features of our Book object
     * and our Novel and ArtAlbums objects using overriding
     */
    public void getInfo(){
        System.out.println("[Name:] "+this.getName()+" [Pages:] "+this.getPagesNumber());
    }
}
