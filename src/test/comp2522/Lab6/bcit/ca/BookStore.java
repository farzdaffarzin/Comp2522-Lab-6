package comp2522.Lab6.bcit.ca;

import java.util.ArrayList;
import java.util.List;

public class BookStore <T extends Literature> {
    private final String name;
    private final List<T> items = new ArrayList<>();

    public BookStore(String name) {
        this.name = name;
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void printItems() {
        for (T item : items) {
            System.out.println(item.getTitle());
        }
    }

    public String getName() {
        return name;
    }

    public List<T> getItems() {
        return items;
    }

    public void printBookTitle(String title) {
        items.forEach(item -> {
            if (item.getTitle().contains(title)) {
                System.out.println(item.getTitle());
            }
        });
    }

    public void printTitlesInAlphaOrder() {
        items.sort((item1, item2) -> item1.getTitle().compareToIgnoreCase(item2.getTitle()));
        items.forEach(item -> System.out.println(item.getTitle()));
    }


    // Static nested class for BookStoreInfo
    public static class BookStoreInfo {
        public void displayInfo(String storeName, int itemCount) {
            System.out.println("BookStore: " + storeName + ", Items: " + itemCount);
        }
    }

    public class NovelStatistics {
        public double averageTitleLength() {
            int totalLength = 0;
            for (T item : items) {
                totalLength += item.getTitle().length();
            }
            return (double) totalLength / items.size();
        }

        public void addNovelsToCollection(List<? super Novel> novelCollection) {
            for (T item : items) {
                if (item instanceof Novel) {
                    novelCollection.add((Novel) item);
                }
            }
        }
    }
}