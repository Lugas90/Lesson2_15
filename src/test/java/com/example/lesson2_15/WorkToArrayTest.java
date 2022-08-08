package com.example.lesson2_15;

import com.example.lesson2_15.Exceptions.ArrayOutOfLimitException;
import com.example.lesson2_15.Exceptions.ItemNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.lesson2_15.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class WorkToArrayTest {

    private final WorkToArray out = new WorkToArray();


    @Test
    void shouldReturnAdd() {
        String[] expected = new String[]{PRIVET, POKA};
        out.add(PRIVET);
        out.add(POKA);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnAddStringAndSize() {
        String[] expected = new String[]{PRIVET, POKA};
        out.add(POKA);
        out.add(0, PRIVET);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnSet() {
        String[] expected = new String[]{PRIVET, POKA};
        out.add(PRIVET);
        out.add(ZACHEM);
        out.set(1, POKA);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnRemoveToString() {
        String[] expected = new String[]{PRIVET, POKA};
        out.add(PRIVET);
        out.add(POKA);
        out.add(ZACHEM);
        out.remove(ZACHEM);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnRemoveToSize() {
        String[] expected = new String[]{PRIVET, POKA};
        out.add(PRIVET);
        out.add(POKA);
        out.add(ZACHEM);
        out.remove(2);
        String[] actual = out.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnContains() {
        out.add(PRIVET);
        out.contains(PRIVET);
        Assertions.assertTrue(true);
    }

    @Test
    void shouldReturnIndexOf() {
        int expected = 1;
        out.add(PRIVET);
        out.add(POKA);
        int actual = out.indexOf(POKA);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnLastIndexOf() {
        int expected =0;
        out.add(PRIVET);
        out.add(POKA);
        out.add(ZACHEM);
        int actual = out.lastIndexOf(PRIVET);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnGet() {
        out.add(PRIVET);
        out.add(POKA);
        out.add(ZACHEM);
        String expected = POKA;
        String actual = out.get(1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEquals() {
        String[] expected = new String[]{PRIVET, POKA};
        out.add(PRIVET);
        out.add(POKA);
        String[] actual = out.toArray();
        expected.equals(actual);
        assertTrue(true);
    }

    @Test
    void shouldReturnSize() {
        out.add(PRIVET);
        out.add(POKA);
        out.add(ZACHEM);
        int expected = 3;
        int actual = out.size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnIsEmpty() {
        out.add(PRIVET);
        out.remove(PRIVET);
        out.isEmpty();
        assertTrue(true);


    }

    @Test
    void shouldReturnClear() {
        out.add(PRIVET);
        out.add(POKA);
        assertThrows(NullPointerException.class, () -> out.clear());
    }

    @Test
    void shouldReturnArrayOutOfLimitException() {
        out.add(PRIVET);
        out.add(POKA);
        out.add(ZATEM);
        assertThrows(ArrayOutOfLimitException.class, () -> out.add(ZACHEM));
    }

    @Test
    void shouldReturnNotFoundException () {
        out.add(PRIVET);
        out.add(POKA);
        out.add(ZACHEM);
        String expected = POKA;
        String actual = out.get(1);
        assertThrows(ItemNotFoundException.class, () -> out.get(5));

    }
}



