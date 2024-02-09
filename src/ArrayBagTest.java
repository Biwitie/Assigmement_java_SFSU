import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayBagTest {
    public static void main(String[] args) {
        var myGroceryBag = new MyArrayBag<String>();
        System.out.println("The bag is empty: " + myGroceryBag.isEmpty());
        System.out.println("The bag is not full: " + myGroceryBag.isFull());
        System.out.println("The bag contains 0 items: " + myGroceryBag.getCurrentSize());
        System.out.println("-------------------");
        myGroceryBag.add("Apple");
        myGroceryBag.add("Banana");
        myGroceryBag.add("Carrot");
        myGroceryBag.add("Date");
        myGroceryBag.add("Eggplant");

        System.out.println("The bag contains 5 items: " + myGroceryBag.getCurrentSize());
        System.out.println("-------------------");

        System.out.println("The bag is not full: " + myGroceryBag.isFull());
        System.out.println("-------------------");

        System.out.println("The bag is not empty: " + myGroceryBag.isEmpty());
        System.out.println("-------------------");

        System.out.println("The bag contains 1 Apple: " + myGroceryBag.getFrequencyOf("Apple"));
        System.out.println("The bag contains 1 Banana: " + myGroceryBag.getFrequencyOf("Banana"));
        System.out.println("The bag contains 1 Carrot: " + myGroceryBag.getFrequencyOf("Carrot"));
        System.out.println("The bag contains 1 Date: " + myGroceryBag.getFrequencyOf("Date"));
        System.out.println("The bag contains 1 Eggplant: " + myGroceryBag.getFrequencyOf("Eggplant"));
        System.out.println("The bag contains 0 Figs: " + myGroceryBag.getFrequencyOf("Figs"));
        System.out.println("-------------------");

        System.out.println("The bag contains Apple: " + myGroceryBag.contains("Apple"));
        System.out.println("The bag contains Banana: " + myGroceryBag.contains("Banana"));
        System.out.println("The bag contains Carrot: " + myGroceryBag.contains("Carrot"));
        System.out.println("The bag contains Date: " + myGroceryBag.contains("Date"));
        System.out.println("The bag contains Eggplant: " + myGroceryBag.contains("Eggplant"));
        System.out.println("The bag contains Figs: " + myGroceryBag.contains("Figs"));
        System.out.println("-------------------");

        System.out.println("The banana was removed: " + myGroceryBag.remove());
        System.out.println("The bag contains 4 items: " + myGroceryBag.getCurrentSize());
        System.out.println("-------------------");

        System.out.println("The bag contains Apple: " + myGroceryBag.contains("Apple"));
        System.out.println("The bag contains Banana: " + myGroceryBag.contains("Banana"));
        System.out.println("The bag contains Carrot: " + myGroceryBag.contains("Carrot"));
        System.out.println("The bag contains Date: " + myGroceryBag.contains("Date"));
        System.out.println("The bag contains Eggplant: " + myGroceryBag.contains("Eggplant"));
        System.out.println("-------------------");

        System.out.println("The bag is empty: " + myGroceryBag.isEmpty());
        System.out.println("-------------------");

        myGroceryBag.clear();
        System.out.println("The bag is empty: " + myGroceryBag.isEmpty());
        System.out.println("The bag contains 0 items: " + myGroceryBag.getCurrentSize());
        System.out.println("-------------------");

        System.out.println("The bag contains Apple: " + myGroceryBag.contains("Apple"));
        System.out.println("The bag contains Banana: " + myGroceryBag.contains("Banana"));
        System.out.println("The bag contains Carrot: " + myGroceryBag.contains("Carrot"));
        System.out.println("The bag contains Date: " + myGroceryBag.contains("Date"));
        System.out.println("The bag contains Eggplant: " + myGroceryBag.contains("Eggplant"));
        System.out.println("-------------------");

        System.out.println("End of the test.");
    }
    @Test
    void CurrentSizeIsZero() {
        var myGroceryBag = new MyArrayBag<String>();
        assertEquals(0, myGroceryBag.getCurrentSize());
    }

    @Test
    void BagIsEmpty() {
        var myGroceryBag = new MyArrayBag<String>();
        assertTrue(myGroceryBag.isEmpty());
    }

    @Test
    void BagIsNotFull() {
        var myGroceryBag = new MyArrayBag<String>();
        assertFalse(myGroceryBag.isFull());
    }

    @Test
    void AddOneItem() {
        var myGroceryBag = new MyArrayBag<String>();
        assertTrue(myGroceryBag.add("Apple"));
    }

    @Test
    void AddOneItemAndCheckSize() {
        var myGroceryBag = new MyArrayBag<String>();
        myGroceryBag.add("Apple");
        assertEquals(1, myGroceryBag.getCurrentSize());
    }

    @Test
    void AddOneItemAndCheckIfEmpty() {
        var myGroceryBag = new MyArrayBag<String>();
        myGroceryBag.add("Apple");
        assertFalse(myGroceryBag.isEmpty());
    }

    @Test
    void AddOneItemAndCheckIfFull() {
        var myGroceryBag = new MyArrayBag<String>();
        myGroceryBag.add("Apple");
        assertFalse(myGroceryBag.isFull());
    }

    @Test
    void AddOneItemAndRemoveItAndCheckSize() {
        var myGroceryBag = new MyArrayBag<String>();
        myGroceryBag.add("Apple");
        myGroceryBag.remove();
        assertEquals(0, myGroceryBag.getCurrentSize());
    }

    @Test
    void AddOneItemAndRemoveItAndCheckIfEmpty() {
        var myGroceryBag = new MyArrayBag<String>();
        myGroceryBag.add("Apple");
        myGroceryBag.remove();
        assertTrue(myGroceryBag.isEmpty());
    }

    @Test
    void AddOneItemAndRemoveItAndCheckIfFull() {
        var myGroceryBag = new MyArrayBag<String>();
        myGroceryBag.add("Apple");
        myGroceryBag.remove();
        assertFalse(myGroceryBag.isFull());
    }

    @Test
    void FullBag() {
        var myGroceryBag = new MyArrayBag<String>();
        myGroceryBag.add("Apple");
        myGroceryBag.add("Banana");
        myGroceryBag.add("Carrot");
        myGroceryBag.add("Date");
        myGroceryBag.add("Eggplant");
        myGroceryBag.add("Lemon");
        myGroceryBag.add("Mango");
        myGroceryBag.add("Orange");
        myGroceryBag.add("Pineapple");
        myGroceryBag.add("Quince");
        assertTrue(myGroceryBag.isFull());
    }

    @Test
    void FullBagAndAddOneMore() {
        var myGroceryBag = new MyArrayBag<String>();
        myGroceryBag.add("Apple");
        myGroceryBag.add("Banana");
        myGroceryBag.add("Carrot");
        myGroceryBag.add("Date");
        myGroceryBag.add("Eggplant");
        myGroceryBag.add("Lemon");
        myGroceryBag.add("Mango");
        myGroceryBag.add("Orange");
        myGroceryBag.add("Pineapple");
        myGroceryBag.add("Quince");
        assertFalse(myGroceryBag.add("Raspberry"));
    }

    @Test
    void FrequencyOfItem() {
        var myGroceryBag = new MyArrayBag<String>();
        myGroceryBag.add("Apple");
        myGroceryBag.add("Apple");
        myGroceryBag.add("Apple");
        myGroceryBag.add("Apple");
        myGroceryBag.add("Banana");
        myGroceryBag.add("Carrot");
        myGroceryBag.add("Date");
        myGroceryBag.add("Eggplant");
        assertEquals(4, myGroceryBag.getFrequencyOf("Apple"));
    }
}