package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class MyListTest {
    private final MyList<Integer> myList = new MyList<>();
    private final MyList<Integer> newMyList = new MyList<>();

    @Test
    public void add_test() {
        myList.add(1);
        myList.add(5);
        Assertions.assertEquals(1, myList.get(0));
        Assertions.assertEquals(5, myList.get(1));
        Assertions.assertEquals(2, myList.size());
    }

    @Test
    public void get_test_and_size() {
        myList.add(1);
        myList.add(5);
        int expected = 1;
        int expected1 = 5;
        int actual = myList.get(0);
        int actual1 = myList.get(1);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(2, myList.size());
    }

    @Test
    public void test_get_invalid_index() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.get(4));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.get(5));
    }

    @Test
    public void resize_test() {
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);

        Assertions.assertEquals(3, myList.get(3));
        Assertions.assertNull(myList.get(4));
        Assertions.assertNull(myList.get(5));
    }

    @Test
    public void remove_test() {
        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.get(0);
        myList.get(3);

        Assertions.assertEquals(0, myList.get(0));
        Assertions.assertEquals(3, myList.get(3));

        myList.remove(0);
        Assertions.assertEquals(1, myList.get(0));
        Assertions.assertNull(myList.get(3));

    }

    @Test
    public void map_test_from_int_to_double() {
        myList.add(5);
        myList.add(15);

        Function<Integer, Double> doubleFunction = x -> x * 1.0;
        MyList<Double> doubledList = myList.map(doubleFunction);

        double expected = 5.0;
        double actual = doubledList.get(0);
        double expected1 = 15.0;
        double actual1 = doubledList.get(1);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    public void hashCode_successful_with_equal_lists() {
        myList.add(1);
        myList.add(2);

        newMyList.add(1);
        newMyList.add(2);

        Assertions.assertEquals(myList.hashCode(), newMyList.hashCode());
    }

    @Test
    public void hashCode_with_same_elements_dif_order() {
        myList.add(2);
        myList.add(1);

        newMyList.add(1);
        newMyList.add(2);

        Assertions.assertNotEquals(myList.hashCode(), newMyList.hashCode());
    }

    @Test
    public void list_myList_equals_newMyList() {
        myList.add(1);
        myList.add(2);

        newMyList.add(1);
        newMyList.add(2);

        Assertions.assertTrue(myList.equals(newMyList));
    }

    @Test
    public void list_myList_notEquals_newMyList() {
        myList.add(2);
        myList.add(1);

        newMyList.add(1);
        newMyList.add(2);

        Assertions.assertFalse(myList.equals(newMyList));
    }

    @Test
    public void myList_equals_newMyList_empty() {
        Assertions.assertTrue(myList.equals(newMyList));
    }

    @Test
    public void myList_and_newMyList_have_different_size_not_equals() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        newMyList.add(1);
        newMyList.add(2);
        newMyList.add(3);
        newMyList.add(4);

        Assertions.assertFalse(myList.equals(newMyList));
    }

    @Test
    public void testToString() {
        myList.add(1);
        myList.add(2);
        myList.add(3);

        String expected = "[1, 2, 3]";
        String actual = myList.toString();

        Assertions.assertEquals(expected, actual);
    }
}
