public interface MyArrayBagInterface <T> {
    public int getCurrentSize();
    public boolean isFull();
    public boolean isEmpty();
    public boolean add(T newEntry);
    public T remove();
    public void clear();
    public int getFrequencyOf(T anEntry);
    public boolean contains(T anEntry);
    public T[] toArray();
    public int findAndRemove(T anEntry);

    /**
     * @param bagEntry is the bag to be combined with the current bag
     * @return the union of the two bags
     * The union of two sets A and B is the set of elements which are in A, in B, or in both A and B.
     * In that case, the union of {1, 2, 3} and {3, 4, 5} is {1, 2, 3, 4, 5}. So we have to check if the element is already in the unionBag
     */
    public MyArrayBag<T> union(MyArrayBag<T> bagEntry);

    public void countVowelsAndConsonants();
}
