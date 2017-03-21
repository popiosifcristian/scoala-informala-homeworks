/**This class is a child of class Book
 * We need this class to define Art Album
 * @author Pop Iosif Cristian
 * @version 1.0
 * @date 15.12.2016
 */
public class ArtAlbum extends Book {
    private String paperQuality;//this is the special feature of Art Album

    /**
     * This is the constructor of ArtAlbum class
     * He will help us to create new ArtAlbum objects
     * @param name is a String and it will contain name of our ArtAlbum
     * @param pagesNumber is an int and it will contain number of pages from our ArtAlbum
     * @param paperQuality is a String and it will contain the paper quality of our ArtAlbum
     */
    public ArtAlbum(String name, int pagesNumber, String paperQuality){
        super(name,pagesNumber);
        this.paperQuality=paperQuality;
    }

    /**
     * This method will get us paper quality of our ArtAlbum
     * @return paperQuality
     */
    public String getPaperQuality(){
        return paperQuality;
    }

    /**
     * This method will help us to print the features of our ArtAlbum object
     */
    @Override
    public void getInfo(){
        System.out.println("[Art Album:] "+this.getName()+" [Pages:] "+this.getPagesNumber()+" [Paper Quality:] "+this.getPaperQuality());
    }
}
