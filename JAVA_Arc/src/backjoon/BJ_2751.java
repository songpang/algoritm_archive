package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[Integer.parseInt(br.readLine())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] result = countingSort(arr);

        for (int j = 0; j < result.length; j++) {
            if (result[j] != 0) {
                for (int i = 0; i < result[j]; i++) {
                    System.out.println(j+1);
                }
            }
        }
    }

    public static int[] countingSort(int[] arr) {
        int[] result = new int[arr.length];

        for (int i : arr) {
            result[i-1]++;
        }

        return result;
    }

}
