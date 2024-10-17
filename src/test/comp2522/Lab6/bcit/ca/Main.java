package comp2522.Lab6.bcit.ca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Main class to demonstrate the functionality of the BookStore and its items.
 *
 * @author Dalraj Bains
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Arsh Mann
 *
 * @version 1.0
 */
public class Main{

    /**
     * Main method to run the BookStore example.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args){

        // Create a new BookStore for Literature
        BookStore<Literature> store = new BookStore<>("BCIT Bookstore");

        // Add various literature types
        store.addItem(new Novel("War and Peace", "Leo Tolstoy", 1869));
        store.addItem(new ComicBook("Spider-Man"));
        store.addItem(new Magazine("National Geographic"));

        // Print the items in the store
        System.out.println("Bookstore Items:");
        store.printItems();

        // Using the static nested class to display bookstore info
        BookStore.BookStoreInfo info = new BookStore.BookStoreInfo();
        info.displayInfo(store.getName(), store.getItems().size());

        // Using the inner class to calculate statistics
        BookStore<Literature>.NovelStatistics stats = store.new NovelStatistics();
        System.out.println("Average title length: " + stats.averageTitleLength());

        // Demonstrate lambda usage
        System.out.println("\nTitles containing 'War':");
        store.printBookTitle("War");

        // Demonstrate method reference for sorting
        System.out.println("\nSorted Titles:");
        store.printTitlesInAlphaOrder();

        // Bonus: Anonymous inner class to sort by title length
        List<Literature> items = new ArrayList<>(store.getItems());
        items.sort(new Comparator<Literature>(){

            @Override
            public int compare(Literature o1, Literature o2){
                return Integer.compare(o1.getTitle().length(), o2.getTitle().length());
            }
        });

        System.out.println("\nTitles sorted by length:");

        for(Literature item : items){
            System.out.println(item.getTitle());
        }
    }
}
