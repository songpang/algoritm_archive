package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[Integer.parseInt(br.readLine())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (end + start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length]; // bad method to create array
        int part1 = start;
        int part2 = mid + 1;

        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int i = start;
        while(part1 <= mid && part2 <= end) {
            if(temp[part1] <= temp[part2]) {
                arr[i++] = temp[part1];
                part1++;
            } else {
                arr[i++] = temp[part2];
                part2++;
            }
        }

        for (int j = 0; j <= mid - part1; j++) {
            arr[i++] = temp[part1 + j];
        }
    }


}
