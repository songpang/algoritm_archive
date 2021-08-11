package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracNotes {
    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        boolean[] visited = new boolean[3];
        permutation(new int[3], visited, 0, 3);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    static void permutation(int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            result.add(output.clone());
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                permutation(output, visited, depth + 1, r);
                output[depth] = 0;
                visited[i] = false;
            }
        }
    }

}