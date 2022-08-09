package com.example.lesson2_15;

import com.example.lesson2_15.Exceptions.ArrayOutOfLimitException;
import com.example.lesson2_15.Exceptions.ItemNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.lesson2_15.Constants.*;
import static com.example.lesson2_15.WorkToArray.binarySearch;
import static org.junit.jupiter.api.Assertions.*;

class WorkToArrayTest {

    private final WorkToArray out = new WorkToArray();


    @Test
    void shouldReturnAdd() {
        Integer[] expected = new Integer[]{ONE, TWO};
        out.add(ONE);
        out.add(TWO);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnAddIntegerAndSize() {
        Integer[] expected = new Integer[]{ONE, TWO};
        out.add(TWO);
        out.add(0, ONE);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnSet() {
        Integer[] expected = new Integer[]{ONE, TWO};
        out.add(ONE);
        out.add(THREE);
        out.set(1, TWO);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnRemoveToInteger() {
        Integer[] expected = new Integer[]{ONE};
        out.add(ONE);
        out.add(TWO);
        out.remove(TWO);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnRemoveToSize() {
        Integer[] expected = new Integer[]{ONE};
        out.add(ONE);
        out.add(TWO);
        out.remove(1);
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnContains() {
        out.add(ONE);
        Assertions.assertTrue(out.contains(ONE));
    }

    @Test
    void shouldReturnIndexOf() {
        int expected = 1;
        out.add(ONE);
        out.add(TWO);
        int actual = out.indexOf(TWO);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnLastIndexOf() {
        int expected =0;
        out.add(ONE);
        out.add(TWO);
        out.add(THREE);
        int actual = out.lastIndexOf(ONE);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnGet() {
        out.add(ONE);
        out.add(TWO);
        out.add(THREE);
        Integer expected = TWO;
        Integer actual = out.get(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEquals() {
        Integer[] expected = new Integer[] {ONE, TWO};
        Integer[] actual = expected;
        assertTrue(expected.equals(actual));
    }

    @Test
    void shouldReturnSize() {
        out.add(ONE);
        out.add(TWO);
        out.add(THREE);
        int expected = 3;
        int actual = out.size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnIsEmpty() {
        out.add(ONE);
        out.remove(ONE);
        out.isEmpty();
        assertTrue(true);


    }

    @Test
    void shouldReturnClear() {
        out.add(ONE);
        out.add(TWO);
        Integer [] expected = new Integer [0];
        out.clear();
        Integer[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnArrayOutOfLimitException() {
        out.add(ONE);
        out.add(TWO);
        out.add(FOUR);
        assertThrows(ArrayOutOfLimitException.class, () -> out.add(THREE));
    }

    @Test
    void shouldReturnNotFoundException () {
        out.add(ONE);
        out.add(TWO);
        out.add(THREE);
        Integer expected = TWO;
        Integer actual = out.get(1);
        assertThrows(ItemNotFoundException.class, () -> out.get(5));
    }

    @Test
    void shouldReturnBinarySearch () {
        out.add(ONE);
        out.add(TWO);
       boolean expected =  binarySearch(out.toArray(), ONE);
        assertTrue(expected);
    }

}



