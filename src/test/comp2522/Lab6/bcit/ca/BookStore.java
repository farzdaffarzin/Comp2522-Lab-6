package comp2522.Lab6.bcit.ca;

import java.util.ArrayList;
import java.util.List;

/**
 * BookStore is a generic class that represents a collection of literary items.
 * It can store any type of Literature and provides methods to manipulate and display the stored items.
 *
 * @author Dalraj Bains
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Arsh Mann
 *
 * @version 1.0
 *
 * @param <T> the type of Literature items this BookStore will store.
 */
public class BookStore<T extends Literature>{

    private final String name;
    private final List<T> items = new ArrayList<>();

    /**
     * Constructs a BookStore with the specified name.
     *
     * @param name the name of the bookstore.
     */
    public BookStore(String name){
        this.name = name;
    }

    /**
     * Adds a literary item to the bookstore.
     *
     * @param item the item to add.
     */
    public void addItem(T item){
        items.add(item);
    }

    /**
     * Prints the titles of all items in the bookstore.
     */
    public void printItems(){
        for(T item : items){
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
    public void printBookTitle(String title){

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

        public void displayInfo(String storeName, int itemCount){

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

            int totalLength = 0;
            for(T item : items){

                totalLength += item.getTitle().length();
            }
            return (double) totalLength / items.size();
        }

        /**
         * Adds novels to a provided collection.
         *
         * @param novelCollection the collection to add novels to.
         */
        public void addNovelsToCollection(List<? super Novel> novelCollection){

            for(T item : items){

                if(item instanceof Novel){
                    novelCollection.add((Novel) item);
                }
            }
        }
    }
}
