package comp2522.Lab6.bcit.ca;

public class Novel extends Literature
        implements Comparable<Novel> {
    
    private final String title;
    private final String authorName;
    private final int yearPub;

    Novel(final String title,
          final String authorName,
          final int yearPub){

        this.title = title;
        this.authorName = authorName;
        this.yearPub = yearPub;
    }

    @Override
    public String getTitle(){
        return title;
    }

    public String getAuthorName(){
        return authorName;
    }

    public int getYearPub(){
        return yearPub;
    }

    @Override
    public int compareTo(Novel that){
        return this.title.compareToIgnoreCase(that.title);
    }

    @Override
    public String toString() {
        return "Title: " + this.title + " Author: " + this.authorName + " Year: " + this.yearPub;
    }
}



