public interface MyArrayBagInterface <T> {
    /**
     * @return the current number of entries in this bag.
     */
    int getCurrentSize();

    /**
     * @return true if the bag is full, else false
     */
    boolean isFull();

    /**
     * @return true if the bag is empty, else false
     */
    boolean isEmpty();

    /**
     * @param newEntry is a simple entry to add in the bag
     * @return true if the entry was correctly added, else false
     */
    boolean add(T newEntry);

    /**
     * @return the entry that was removed from the bag
     */
    T remove();

    /**
     * Removes all entries from this bag
     */
    void clear();

    /**
     * @param anEntry is the entry to be counted
     * @return the number of times that anEntry appears in the bag
     */
    int getFrequencyOf(T anEntry);

    /**
     * @param anEntry is the entry to be checked
     * @return true if the bag contains anEntry, else false
     */
    boolean contains(T anEntry);

    /**
     * @return an array containing all the entries in the bag
     */
    T[] toArray();

    /**
     * @param anEntry is the entry to be removed
     * @return the number of times that anEntry appears in the bag
     */
    int findAndRemove(T anEntry);

    /**
     * @param bagEntry is the bag to be combined with the current bag
     * @return the union of the two bags
     * The union of two sets A and B is the set of elements which are in A, in B, or in both A and B.
     * In that case, the union of {1, 2, 3} and {3, 4, 5} is {1, 2, 3, 4, 5}. So we have to check if the element is already in the unionBag
     */
    MyArrayBag<T> union(MyArrayBag<T> bagEntry);

    void countVowelsAndConsonants();
}
