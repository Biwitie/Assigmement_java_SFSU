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
}
