package com.example.lesson2_15;

import com.example.lesson2_15.Exceptions.ArrayOutOfLimitException;
import com.example.lesson2_15.Exceptions.ItemNotFoundException;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;


public class WorkToArray implements StringList {

    private int size;
    private final String[] storage;


    public WorkToArray(int arraySize) {
        storage = new String[arraySize];
    }

    public WorkToArray() {
        storage = new String[3];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;

        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;

        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = storage[index];
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList.equals(storage)) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = String.valueOf(null);
            size = 0;
        }
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new ItemNotFoundException("Элемент не найден");
        }
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new ArrayOutOfLimitException("хранилище заполнено");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new ItemNotFoundException("Элемент не найден");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(storage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkToArray that = (WorkToArray) o;
        return Arrays.equals(storage, that.storage);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(storage);
    }
}
