package comp2522.Lab6.bcit.ca;

/**
 * Novel represents a type of Literature.
 * It extends the Literature class and provides additional details specific to novels,
 * such as the author's name and the year of publication.
 * It also implements the Comparable interface to allow for title-based comparison.
 *
 * @author Dalraj Bains
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Arsh Mann
 *
 * @version 1.0
 */
public class Novel extends Literature
        implements Comparable<Novel>{

    private final String title;
    private final String authorName;
    private final int yearPub;

    /**
     * Constructs a Novel with the specified title, author name, and year of publication.
     *
     * @param title      the title of the novel.
     * @param authorName the name of the author of the novel.
     * @param yearPub    the year the novel was published.
     */
    Novel(final String title,
          final String authorName,
          final int yearPub){

        this.title = title;
        this.authorName = authorName;
        this.yearPub = yearPub;
    }

    /**
     * Gets the title of the novel.
     *
     * @return the title of the novel.
     */
    @Override
    public String getTitle(){
        return title;
    }

    /**
     * Gets the name of the author of the novel.
     *
     * @return the author's name.
     */
    public String getAuthorName(){
        return authorName;
    }

    /**
     * Gets the year the novel was published.
     *
     * @return the year of publication.
     */
    public int getYearPub(){
        return yearPub;
    }

    /**
     * Compares this novel to another novel based on their titles.
     *
     * @param that the other novel to compare with.
     * @return a negative integer, zero, or a positive integer as this title is less than, equal to, or greater than the specified title.
     */
    @Override
    public int compareTo(final Novel that){
        return this.title.compareToIgnoreCase(that.title);
    }

    /**
     * Returns a string representation of the novel.
     *
     * @return a string containing the title, author's name, and year of publication.
     */
    @Override
    public String toString(){

        final String bookInfo;

        bookInfo = "Title: " +
                this.title +
                " Author: " +
                this.authorName +
                " Year: " +
                this.yearPub;

        return bookInfo;
    }
}
