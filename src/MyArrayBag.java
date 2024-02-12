import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayBag<T> implements MyArrayBagInterface<T>{
    //make a constructor that initializes the bag with 10 nulls
    private final T[] myBag;
    public final int MAX_SIZE = 10;
    private int currentSize = 0;

    @SuppressWarnings("unchecked")
    public MyArrayBag() {
        myBag = (T[]) new Object[MAX_SIZE];
    }

    /**
     * Gets the current number of entries in this bag.
     * @return the current size of the bag
     */
    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * Sees whether this bag is full.
     * @return return true if the bag is full, else false
     */
    @Override
    public boolean isFull() {
        return currentSize == MAX_SIZE;
    }

    /**
     * Sees whether this bag is empty.
     * @return return True if the bag is empty, else false
     */
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Adds a new entry to this bag.
     * @param newEntry is a simple entry to add in the bag
     * @return true if the entry was correctly added, else false
     */
    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            return false;
        }
        try {
            myBag[currentSize] = newEntry;
            currentSize++;
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return null if the remove hasn't finished correctly, else the item removed
     */
    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        try {
            var last = myBag[currentSize - 1];
            myBag[currentSize - 1] = null;
            currentSize--;
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
     * Counts the number of times a given entry appears in this bag.
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
            if (entry == null) continue;
            if (entry.equals(anEntry)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry is the thing to search in the bag
     * @return true if the item was found at least 1 time, else false
     */
    @Override
    public boolean contains(T anEntry) {
        if (isEmpty()){
            return false;
        }

        for (var entry : myBag){
            if (entry == null) continue;
            if (entry.equals(anEntry)){
                return true;
            }
        }
        return false;
    }

    /**
     * Creates an array of all entries that are in this bag.
     * @return the bag as an array
     */
    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] tmpBag = (T[]) Array.newInstance(myBag.getClass().getComponentType(), getCurrentSize());
        if (getCurrentSize() >= 0) System.arraycopy(myBag, 0, tmpBag, 0, getCurrentSize());
        return tmpBag;
    }

    /**
     * Removes all entries from this bag that match a given entry.
     * @param anEntry is the item to remove
     * @return the amount of the item removed
     */
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

    /**
     * Returns a new bag that contains both the entries of the bag and the entries of the bagEntry
     * @param bagEntry is the bag to compare with
     * @return the union of the 2 bags
     */
    @Override
    public MyArrayBag<T> union(MyArrayBag<T> bagEntry){
        if (bagEntry == null || bagEntry.isEmpty()){
            return null;
        }
        var unionBag = new MyArrayBag<T>();
        for (int i = 0; i < currentSize; i++){
            if (myBag[i] == null) continue;
            if (unionBag.contains(myBag[i])) continue;
            unionBag.add(myBag[i]);
        }
        for (int i = 0; i < bagEntry.getCurrentSize(); i++){
            if (bagEntry.myBag[i] == null) continue;
            if (unionBag.contains(bagEntry.myBag[i])) continue;
            unionBag.add(bagEntry.myBag[i]);
        }
        return unionBag;
    }

    /**
     * put in the consonants bag the consonants of the bagEntry and throw the vowels. It will print the frequency of each consonant and the number of consonants.
     */
    public void countVowelsAndConsonants(){
        MyArrayBag<String> letters = new MyArrayBag<>();
        MyArrayBag<String> vowels = new MyArrayBag<>();
        MyArrayBag<String> consonants = new MyArrayBag<>();

        for (int i = 0; i < 10; i++) {
            letters.add(String.valueOf((char) (Math.random() * 26 + 'a')));
        }
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        while (!letters.isEmpty()) {
            String letter = letters.remove();
            System.out.println("Letter: " + letter);
            if (!vowels.contains(letter)) {
                System.out.println("    Consonant: " + letter);
                consonants.add(letter);
            }
        }

        System.out.println("Number of consonants: " + consonants.currentSize);
        for (char c = 'a'; c <= 'z'; c++) {
            String letter = String.valueOf(c);
            if (consonants.contains(letter)) {
                System.out.println("Frequency of " + letter + ": " + consonants.getFrequencyOf(letter));
            }
        }
    }
}
