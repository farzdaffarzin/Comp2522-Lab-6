package comp2522.Lab6.bcit.ca;

/**
 * Magazine represents a type of Literature.
 * It extends the Literature class and stores information about magazines.
 *
 * @author Dalraj Bains
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Arsh Mann
 *
 * @version 1.0
 */
public class Magazine extends Literature{

    private final String title;

    /**
     * Constructs a Magazine with the specified title.
     *
     * @param title the title of the magazine.
     */
    public Magazine(final String title){
        this.title = title;
    }

    /**
     * Gets the title of the magazine.
     *
     * @return the title of the magazine.
     */
    @Override
    public String getTitle(){
        return title;
    }
}
