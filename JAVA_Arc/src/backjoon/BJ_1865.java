package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1865 {
    static class Adjacent {
        int S;
        int E;
        int T;

        public Adjacent(int s, int e, int t) {
            S = s;
            E = e;
            T = t;
        }
    }

    static int N, M, W;
    static final int INF = Integer.MAX_VALUE;
    static List<Adjacent> adjacents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        loop:
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            adjacents = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                adjacents.add(new Adjacent(from, to, weight));
                adjacents.add(new Adjacent(to, from, weight));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                adjacents.add(new Adjacent(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                        -Integer.parseInt(st.nextToken())));
            }

            boolean isCycle;
            for (int i = 0; i < N; i++) {
                isCycle = bf(i);
                if(isCycle) {
                    System.out.println("YES");
                    continue loop;
                }
            }
            System.out.println("NO");
        }
    }

    private static boolean bf(int start) {
        int[] distance = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            distance[start] = INF;
        }

        distance[start] = 0;
        int edgeCount = adjacents.size();
        boolean update;

        for (int i = 0; i < N; i++) {
            update = false;
            for (int j = 0; j < edgeCount; j++) {
                int current = adjacents.get(j).S;
                int next = adjacents.get(j).E;
                int weight = adjacents.get(j).T;

                if (distance[current] != INF && distance[next] > distance[current] + weight) {
                    distance[next] = distance[current] + weight;
                    update = true;
                    if (i == N - 1) {
                        return true;
                    }
                }
            }
            // 아래 코드로 시간초과 해결.
            // update를 추가해서 해결했음.
            if(!update) break;
        }
        return false;
    }
}
