package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_6808_Permutation {
    static int gyuWin;
    static int gyuLose;
    static int[] gyuArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            gyuWin = 0;
            gyuLose = 0;
            gyuArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] deck = new int[19];
            deck[0] = 1;
            for (int i : gyuArr) deck[i] = 1;

            int[] youngArr = new int[9];
            int count = 0;
            for (int j = 0; j < deck.length; j++) {
                if (deck[j] != 1) youngArr[count++] = j;
            }

            permutation(youngArr, 0, new boolean[9], 0);
            gyuWin = 362880 - gyuLose;
            System.out.printf("#%d %d %d\n", t, gyuWin, gyuLose);
        }
    }

    public static void permutation(int[] youngArr, int gyuPoint, boolean[] visited, int depth) {
        if (depth == 9) {
            if (gyuPoint < 86) gyuLose++;
            return;
            //1-18 171 85.5
        }

        if (gyuPoint >= 86) {
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (gyuArr[depth] > youngArr[i]) {
                    gyuPoint += gyuArr[depth] + youngArr[i];
                    permutation(youngArr, gyuPoint, visited, depth + 1);
                    gyuPoint -= gyuArr[depth] + youngArr[i];
                } else {
                    permutation(youngArr, gyuPoint, visited, depth + 1);
                }
                visited[i] = false;
            }
        }
    }
}
