package codingtest;

import java.util.ArrayList;
import java.util.List;

public class PracNotes {
    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        int n = 10;
        for (int i = 1; i < 5; i++) {
            permutation(0, i, new int[n], new boolean[n]);
        }
    }

    public static void permutation(int count, int n, int[] output, boolean[] visited) {
        if(count == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(output[i]);
            }
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[count] = i;
                permutation(count + 1, n, output, visited);
                visited[i] = false;

            }
        }
    }


}