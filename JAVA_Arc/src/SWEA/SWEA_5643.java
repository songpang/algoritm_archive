package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_5643 {

    static List<ArrayList<Integer>> smallerThan;
    static List<ArrayList<Integer>> biggerThan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());

            smallerThan = new ArrayList<>();
            biggerThan = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) {
                smallerThan.add(new ArrayList<>());
                biggerThan.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                smallerThan.get(b).add(a);
                biggerThan.get(a).add(b);
            }

            int count = 0;
            for (int i = 1; i <= N; i++) {
                int result = bfs(i, new boolean[N + 1]);
                if (result == N - 1) count++;
            }

            System.out.printf("#%d %d", t, count);
        }
    }

    public static int bfs(int start, boolean[] visited) {
        Queue<Integer> iq = new LinkedList<>();
        visited[start] = true;
        int count = 0;

        iq.offer(start);
        count = getCount(visited, iq, count, smallerThan);

        iq.offer(start);
        count = getCount(visited, iq, count, biggerThan);

        return count;
    }

    private static int getCount(boolean[] visited, Queue<Integer> iq, int count, List<ArrayList<Integer>> than) {
        while (!iq.isEmpty()) {
            int temp = iq.poll();

            for (Integer sm : than.get(temp)) {
                if (!visited[sm]) {
                    visited[sm] = true;
                    count++;
                    iq.offer(sm);
                }
            }
        }
        return count;
    }
}
