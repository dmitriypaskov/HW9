package pashkov;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HW3 {

    private static final int lengthOfArray = 20;
    private static final int bound = 50;
    private static final Random random = new Random();

    public static void main(String[] args) {
        // 3 *) Write a method that searches using a binary search to see if there is a number in the sorted array.
        System.out.printf("Enter the number from 1 to %s what you want to check :", lengthOfArray );
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = arrayInit();
        System.out.print("Not sorted : ");
        arrayPrint(arr);
        sortTheArray(arr);
        System.out.print("Sorted     : ");
        arrayPrint(arr);
        boolean requiredNumber = checkTheNumber(arr, number);
        if (requiredNumber) {
            System.out.printf("There IS number %s in %s", number, Arrays.toString(arr));
        } else {
            System.out.printf("There IS NOT number %s in %s", number, Arrays.toString(arr));
        }
    }

    private static boolean checkTheNumber(int[] arr, int number) {

        int start = 0;
        int end = arr.length - 1;
        if (arr.length == 0) {
            System.out.println("There isn't any numbers in the array");
            return false;
        }
        if (arr.length == 1 && arr[0] == number) {
            return true;
        }

        while (start >= 0 && end <= arr.length - 1) {
            int centerIndex = start + (end - start) / 2;
            int center = arr[centerIndex];
            if (center == number || arr[start] == number || arr[end] == number) {
                return true;
            }
            if (end - start <= 1) {
                return false;
            }
            if (number < center && centerIndex > 0) {
                end = centerIndex - 1;
            } else if (number > center && centerIndex < arr.length - 1) {
                start = centerIndex + 1;
            }
        }
        return false;
    }

    private static void sortTheArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    private static int[] arrayInit() {
        int[] arr = new int[lengthOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound)+1;
        }
        return arr;
    }

    private static void arrayPrint(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
