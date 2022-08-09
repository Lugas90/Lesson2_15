package com.example.lesson2_15;

import java.util.Arrays;

public class CompareSortArrays {


    private static int[] random(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round((Math.random() * 1000) - 150);
            System.out.println(arr[i]);
        }
        return arr;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(int[] arr) {  // отсортировано за 25796 мс.
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {    // отсортировано за 9129 мс.
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {   // отсортировано за 2448 мс.
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


    public static void main(String[] args) {
        int[] arr1 = new int[100_000];
        random(arr1);
        int[] arr2 = Arrays.copyOf(arr1, 100_000);
        int[] arr3 = Arrays.copyOf(arr1, 100_000);

        long start = System.currentTimeMillis();
        sortBubble(arr1);
        System.out.println(System.currentTimeMillis() - start);
    }
}
