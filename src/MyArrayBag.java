import java.util.Arrays;

public class MyArrayBag<T> implements MyArrayBagInterface<T>{
    private final T[] myBag = toArray();

    /**
     * @return the current size of the bag
     */
    @Override
    public int getCurrentSize() {
        int count = 0;
        for (var entry : myBag){
            if (entry == null) continue;
            count++;
        }
        return count;
    }

    /**
     * @return return true if the bag is full, else false
     */
    @Override
    public boolean isFull() {
        return getCurrentSize() == 10;
    }

    /**
     * @return return True if the bag is empty, else false
     */
    @Override
    public boolean isEmpty() {
        return getCurrentSize() == 0;
    }

    /**
     * @param newEntry is a simple entry to add in the bag
     * @return true if the entry was correctly added, else false
     */
    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            return false;
        }
        try {
            myBag[getCurrentSize()] = newEntry;
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * @return null if the remove hasn't finished correctly, else the item removed
     */
    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        try {
            var last = myBag[getCurrentSize()-1];
            myBag[getCurrentSize() - 1] = null;
            return last;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * put null on every item of the bag
     */
    @Override
    public void clear() {
        Arrays.fill(myBag, null);
    }

    /**
     * @param anEntry is the thing to search in the bag
     * @return the amount of the item found
     */
    @Override
    public int getFrequencyOf(T anEntry) {
        if (isEmpty()) {
            return 0;
        }
        var count = 0;
        for (var entry : myBag) {
            if (entry == anEntry) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param anEntry is the thing to search in the bag
     * @return true if the item was found at least 1 time, else false
     */
    @Override
    public boolean contains(T anEntry) {
        if (isEmpty()){
            return false;
        }
        for (var entry : myBag){
            if (entry == anEntry) return true;
        }
        return false;
    }

    /**
     * @return the bag as an array
     */
    @Override
    public T[] toArray() {
        return (T[]) new Object[10];
    }

    public int findAndRemove(T anEntry){
        if (isEmpty()){
            return 0;
        }
        var count = 0;
        var currentSize = getCurrentSize();
        for (int i = 0; i < currentSize; i++){
            if (myBag[i] == anEntry){
                myBag[i] = null;
                count++;
            }
        }
        return count;
    }
}
