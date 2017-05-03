import java.util.ArrayList;
import java.util.List;

/**This class will contain our methods and our ArrayList
 * @author Pop Iosif Cristian
 * @version 1.0
 * @date 15.12.2016
 */
public class Library {
public List<Book> books= new ArrayList<>();//in this ArrayList we will put all our Books

    /**
     * This method will add objects in our ArrayList
     * If boolean choose is true it will add a new Novel
     * Else it will add a new ArtAlbum
     */
    public void addBook(Book book){
       switch (book.getClass().getSimpleName()){
           case "Novel":
               books.add(book);
               break;

           case "ArtAlbum":
               books.add(book);
               break;
       }
    }

    /**
     * This method will delete a Book from our ArrayList
     * First time we will create a new empty object, than we will
     * search in our ArrayList first object what have the same name as
     * the given name. If we find that object, we remove it from the ArrayList
     * @param name is the name of the Book that user want it deleted
     */
    public void deleteBook(String name){
        Object chosen = new Object();
        for(Book book : books) {
            if (book.getName().equals(name))
                chosen=book;
        }
        books.remove(chosen);
    }

    /**
     * This method will list all Books from our ArrayList
     * with help of getInfo() method from Book
     */
    public void listBooks() {
        for (Book book : books) {
            book.getInfo();
        }
    }
}
