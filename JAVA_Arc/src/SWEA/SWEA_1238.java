package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1238 {
    static int N, start;
    static int[][] adjacent;
    static int[] pairs;
    static Queue<Pair> bq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            start = Integer.parseInt(input[1]);

            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = 0;
            pairs = new int[N];
            while(st.hasMoreTokens()) {
                pairs[idx++] = Integer.parseInt(st.nextToken());
            }

            adjacent = new int[101][101];
            for (int i = 0; i < N; i += 2) {
                adjacent[pairs[i]][pairs[i + 1]] = 1;
            }

            int result = bfs(0, start, new boolean[101], adjacent);
            System.out.printf("#%d %d\n", t, result);
        }
    }

    public static int bfs(int depth, int start, boolean[] visited, int[][] adjacent) {
        bq = new LinkedList<>();
        bq.add(new Pair(start, depth));

        Pair temp;
        int max;
        int resultMax = 0;
        while (!bq.isEmpty()) {
            max = -1;
            while (bq.peek() != null && bq.peek().depth == depth) {
                temp = bq.poll();

                for (int i = 1; i <= 100; i++) {
                    if (adjacent[temp.number][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        bq.add(new Pair(i, depth + 1));
                        max = Math.max(max, i);
                    }
                }
            }
            if(max != -1) resultMax = max;
            depth++;
        }

        return resultMax;
    }

    static class Pair {
        int number;
        int depth;

        public Pair(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }
    }

}
