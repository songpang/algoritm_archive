package backjoon;

import java.util.Scanner;

public class BJ_2750 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, temp, start, mid);
            mergeSort(arr, temp, mid + 1, end);
            merge(arr, temp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        for (int i = start; i < end; i++) {
            if(temp[start] >= temp[mid]) {
                arr[i] = temp[start];
                start++;
            } else {
                arr[i] = temp[mid];
                mid++;
            }

            for (int j = start; j < mid-start; j++) {
                arr[j] = temp[start];
                start++;
            }
        }
    }

}
