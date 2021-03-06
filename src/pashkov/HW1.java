package pashkov;

import java.util.Arrays;
import java.util.Random;

public class HW1 {

    public static final Random random = new Random();
    public static final int lengthOfArray = 10;

    public static void main(String[] args) {
        // 1) Fill the array with random numbers. Calculate:
        // - the number of elements that are more than their neighbor on the left;
        // - the number of even elements;
        // - the number of elements that are less than the arithmetic mean.
        int[] arr = new int[lengthOfArray];
        fillArrayRandomNumbers(arr);
        System.out.println(countElementsLessThanArithmeticMean(arr));
        System.out.println(countEvenElements(arr));
        System.out.println(countElementsLargerLeft(arr));
        System.out.println(Arrays.toString(arr));
    }

    private static int countElementsLessThanArithmeticMean(int[] arr) {
        int sum = 0;
        int count = 0;
        for (int j : arr) {
            sum += j;
        }
        double arithmeticMean = sum / lengthOfArray;
        for (int j : arr) {
            if (j < arithmeticMean) {
                count++;
            }
        }
        return count;
    }

    private static int countEvenElements(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int countElementsLargerLeft(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                count++;
            }
        }
        return count;
    }

    private static void fillArrayRandomNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
    }
}

