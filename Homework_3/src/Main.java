import java.util.Scanner;

/**This is the main class of our "project"
 * Here we will use all things that we created and here we will design our application
 * @author Pop Iosif Cristian
 * @version 1.0
 * @date 15.12.2016
 */
public class Main {

    public static void main(String[] args){
    Library library = new Library();
    Scanner s = new Scanner(System.in);
        String name;
        int pagesnumber;
        String special;
        boolean choose;
        boolean infinite=true;
        int x;
        /**
         * This is the beginning of our loop
         * Our application will run while infinite is true
         * If  the user want to exit the application he will need to press 0
         * when he press 0 the boolean infinite will be false and our loop will end
         */
        while(infinite) {
            /**
             * This is the basic menu of our application. Here the user can see
             * what options he has. He need to choose one for going ahead
             */
            System.out.println(
                    "Press:"+"\n"+"1 to add a book" + "\n" + "2 to delete a book" + "\n" + "3 to list all books"
                    +"\n"+"0 to exit"
            );
            /**
             * We will save his choice in x
             * After that we will use a switch to complete the action chosen by user
             */
            x = s.nextInt();
            switch (x) {
                case 1: {
                    /**
                     * If the user press 1 than we will ask him what type of book does
                     * he want to add, a Novel or an Art Album.
                     * We will save his choice in y than we will use again a switch to complete
                     * the action chosen by user
                     */
                    int y;
                    System.out.println("Press 1 for a novel or 2 for an art album");
                    y = s.nextInt();
                    switch (y) {
                        //The Add Book case
                        case 1: {
                            //If the user choose 1 than we will add a Novel
                            choose = true;//this will let our addBook function know that we need a Novel
                            System.out.println("Please write the name of the novel");
                            name = getInput();//We will save the name of the Novel from the keyboard
                            System.out.println("Please type how many pages has the novel");
                            pagesnumber = s.nextInt();//We will save how many pages has the Novel from the keyboard
                            System.out.println("Please write the type of the novel");
                            special = getInput();//We will save type of the Novel from the keyboard
                            /**
                             * Now we will call our function with that parameters
                             * And the function will create a new Novel object in our Array List
                             * A new Novel objects with proprieties of chosen parameters
                             */
                            Novel novel = new Novel(name, pagesnumber, special);
                            library.addBook(novel);
                        }
                        break;
                        case 2: {
                            //If the user choose 1 than we will add a Novel
                            choose = false;//this will let our addBook function know that we need an Art Album
                            System.out.println("Please write the name of the art album");
                            name = getInput();//We will save the name of the Art Album from the keyboard
                            System.out.println("Please type how many pages has the art album");
                            pagesnumber = s.nextInt();//We will save how many pages has the Art Album from the keyboard
                            System.out.println("Please write the page quality of art album");
                            special = getInput();//We will save the paper quality of the Art Album from the keyboard
                            /**
                             * Now we will call our function with that parameters
                             * And the function will create a new Art Album object in our Array List
                             * A new Art Album objects with proprieties of chosen parameters
                             */
                            ArtAlbum artAlbum = new ArtAlbum(name, pagesnumber, special);
                            library.addBook(artAlbum);
                        }
                        break;
                        default: {
                            System.out.println("Please choose a number between 1 and 2");
                        }
                        break;
                    }

                }
                break;
                //The Delete Book case
                case 2: {
                    if(library.books.size()==0)//We will verify if our Library have any Book
                        //If here is no Book we will let user know that he has no Book in Library
                        System.out.println("You have no books in library");
                    else {
                        if(library.books.size()==1)//We will verify if our Library have just one Book
                        {//If here is just one Book we will ask user if he really want to delete it
                            System.out.println("You have just one book in your library."+"\n"
                            +"Are you sure that you want it deleted?"+"\n"+"Press:"+"\n"+"1 yes"+"\n"+
                            "2 no"+"\n");
                            if(s.nextInt()==1)//If he choose 1, we will delete it
                            library.books.remove(0);
                        }else {
                            //Else the user need to write the name of the Book that he want it deleted
                            System.out.println("Please write the name of the book that you want it deleted");
                            name = getInput();
                            library.deleteBook(name);

                        }
                    }
                }
                break;
                //The List Books case
                case 3: {
                    if(library.books.size()==0)//We will verify if our Library have any Book
                        //If here is no book we will let user know that he has no Book in Library
                        System.out.println("You have no books in library");
                    else
                    //Else if he have Books in library, we will list the Books
                    library.listBooks();
                }
                break;
                //The Exit case
                case 0:{
                    //If the user press 0 infinite boolean will become false and our application will end
                    infinite=false;
                } break;
                default: {
                    System.out.println("Please choose a number between 1,2,3,0");
                }
                break;
            }
        }
    }

    /**
     *We will use this method to read from the keyboard all strings
     * because i had trouble using nextLine() method from java.util.Scanner;
     */
    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
