package comp2522.Lab6.bcit.ca;

/**
 * ComicBook represents a type of Literature.
 * It extends the Literature class and stores information about comic books.
 *
 * @author Dalraj Bains
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Arsh Mann
 *
 * @version 1.0
 */
public class ComicBook extends Literature{

    private final String title;

    /**
     * Constructs a ComicBook with the specified title.
     *
     * @param title the title of the comic book.
     */
    public ComicBook(final String title){
        this.title = title;
    }

    /**
     * Constructs a ComicBook with the specified title.
     */
    @Override
    public String getTitle(){
        return title;
    }

}
