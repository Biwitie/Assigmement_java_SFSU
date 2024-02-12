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
     * @return the current size of the bag
     */
    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * @return return true if the bag is full, else false
     */
    @Override
    public boolean isFull() {
        return currentSize == 10;
    }

    /**
     * @return return True if the bag is empty, else false
     */
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
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
            myBag[currentSize] = newEntry;
            currentSize++;
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
     * @param anEntry is the thing to search in the bag
     * @return true if the item was found at least 1 time, else false
     */
    @Override
    public boolean contains(T anEntry) {
        if (isEmpty()){
            return false;
        }
        //print the bag

        for (var entry : myBag){
            if (entry == null) continue;
            if (entry.equals(anEntry)){
                return true;
            }
        }
        return false;
    }

    /**
     * @return the bag as an array
     */
    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] tmpBag = (T[]) Array.newInstance(myBag.getClass().getComponentType(), getCurrentSize());
        if (getCurrentSize() >= 0) System.arraycopy(myBag, 0, tmpBag, 0, getCurrentSize());
        return tmpBag;
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

    /**
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

    public void countVowelsAndConsonants(){
        // Step 1: Create the bags
        MyArrayBag<String> letters = new MyArrayBag<>();
        MyArrayBag<String> vowels = new MyArrayBag<>();
        MyArrayBag<String> consonants = new MyArrayBag<>();

        // Step 2: add 10 random letters to the bag letters with a loop for
        for (int i = 0; i < 10; i++) {
            letters.add(String.valueOf((char) (Math.random() * 26 + 'a')));
        }
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        // Step 3 and 4: Check each letter and add consonants to the consonants bag
        while (!letters.isEmpty()) {
            String letter = letters.remove();
            System.out.println("Letter: " + letter);
            if (!vowels.contains(letter)) {
                System.out.println("    Consonant: " + letter);
                consonants.add(letter);
            }
        }

        // Step 5: Print the number of consonants and the frequency of each consonant
        System.out.println("Number of consonants: " + consonants.currentSize);
        for (char c = 'a'; c <= 'z'; c++) {
            String letter = String.valueOf(c);
            if (consonants.contains(letter)) {
                System.out.println("Frequency of " + letter + ": " + consonants.getFrequencyOf(letter));
            }
        }
    }
}
