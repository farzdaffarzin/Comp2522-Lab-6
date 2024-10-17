package comp2522.Lab6.bcit.ca;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * BookStore is a generic class that represents a collection of literary items.
 * It can store any type of Literature and provides methods to manipulate and display the stored items.
 *
 * @param <T> the type of Literature items this BookStore will store.
 * @author Dalraj Bains
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Arsh Mann
 * @version 1.0
 */
public class BookStore<T extends Literature>{

    private final String name;
    private final List<T> items = new ArrayList<>();
    private final int INITIALIZE_LENGTH = 0;

    /**
     * Constructs a BookStore with the specified name.
     *
     * @param name the name of the bookstore.
     */
    public BookStore(final String name){
        this.name = name;
    }

    /**
     * Adds a literary item to the bookstore.
     *
     * @param item the item to add.
     */
    public void addItem(final T item){
        items.add(item);
    }

    /**
     * Prints the titles of all items in the bookstore.
     */
    public void printItems(){

        for(final T item : items){
            System.out.println(item.getTitle());
        }
    }

    /**
     * Gets the name of the bookstore.
     *
     * @return the name of the bookstore.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the list of literary items in the bookstore.
     *
     * @return the list of literary items.
     */
    public List<T> getItems(){
        return items;
    }

    /**
     * Prints the titles of items that contain the specified title fragment.
     *
     * @param title the title fragment to search for.
     */
    public void printBookTitle(final String title){

        items.forEach(item -> {

            if(item.getTitle().contains(title)){
                System.out.println(item.getTitle());
            }
        });
    }

    /**
     * Prints the titles of all items in alphabetical order.
     */
    public void printTitlesInAlphaOrder(){

        items.sort((item1, item2) -> item1.getTitle().compareToIgnoreCase(item2.getTitle()));
        items.forEach(item -> System.out.println(item.getTitle()));
    }


    /**
     * Prints the titles of all items in alphabetical order.
     */
    public static class BookStoreInfo{

        public void displayInfo(final String storeName,
                                final int itemCount){

            System.out.println("BookStore: " +
                    storeName +
                    ", Items: " +
                    itemCount);
        }
    }

    /**
     * Inner class that provides statistics for novels in the bookstore.
     */
    public class NovelStatistics{

        /**
         * Calculates the average length of novel titles.
         *
         * @return the average length of novel titles.
         */
        public double averageTitleLength(){

            int totalLength;
            totalLength = INITIALIZE_LENGTH;

            for(final T item : items){

                totalLength += item.getTitle().length();
            }
            return (double) totalLength / items.size();
        }

        /**
         * Adds novels to a provided collection.
         *
         * @param novelCollection the collection to add novels to.
         */
        public void addNovelsToCollection(final List<? super Novel> novelCollection){

            for(final T item : items){

                if(item instanceof Novel){
                    novelCollection.add((Novel) item);
                }
            }
        }
    }

    /**
     * Main method to run the BookStore example.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args){

        final BookStore<Literature> store;

        store = new BookStore<>("BCIT Bookstore");

        // Add various literature types
        store.addItem(new Novel("War and Peace", "Leo Tolstoy", 1869));
        store.addItem(new ComicBook("Spider-Man"));
        store.addItem(new Magazine("National Geographic"));

        // Print the items in the store
        System.out.println("Bookstore Items:");
        store.printItems();

        // Using the static nested class to display bookstore info
        final BookStore.BookStoreInfo info;
        info = new BookStore.BookStoreInfo();

        info.displayInfo(store.getName(), store.getItems().size());

        // Using the inner class to calculate statistics
        final BookStore<Literature>.NovelStatistics stats;
        stats = store.new NovelStatistics();

        System.out.println("Average title length: " + stats.averageTitleLength());

        // Demonstrate lambda usage
        System.out.println("\nTitles containing 'War':");
        store.printBookTitle("War");

        // Demonstrate method reference for sorting
        System.out.println("\nSorted Titles:");
        store.printTitlesInAlphaOrder();

        // Bonus: Anonymous inner class to sort by title length
        final List<Literature> items;
        items = new ArrayList<>(store.getItems());

        items.sort(new Comparator<Literature>(){

            @Override
            public int compare(final Literature o1,
                               final Literature o2){

                return Integer.compare(o1.getTitle().length(), o2.getTitle().length());
            }
        });

        System.out.println("\nTitles sorted by length:");

        for(Literature item : items){
            System.out.println(item.getTitle());
        }
    }
}
