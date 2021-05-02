package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrN = new int[scanner.nextInt()];
        for (int i = 0; i < arrN.length; i++)
            arrN[i] = scanner.nextInt();

        int[] arrM = new int[scanner.nextInt()];
        for (int i = 0; i < arrM.length; i++)
            arrM[i] = scanner.nextInt();

        Arrays.sort(arrN);
        for (int i : arrM) {
            System.out.println(findN(arrN, i));
        }
    }

    public static int findN(int[] arr, int N) {
        int low = 0, high = arr.length-1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == N) return 1;

            if (arr[mid] > N) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
