package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 10423 전기가 부족해
// 전형적인 MST이지만 조건이 있음
// 속도 -> 느림

public class BJ_10423_MST_mutated {
    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int N, M, K;
    static int[] powerPlant;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        powerPlant = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            powerPlant[i] = Integer.parseInt(st.nextToken());
        }

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(edges);

        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int maxCity = 0;
        for (int i = 0; i < M; i++) {
            if (!findParent(parent, edges[i].u, edges[i].v)) {
                if (isPowerPlant(parent, edges[i].u) && isPowerPlant(parent, edges[i].v)) {
                    continue;
                }
                sum += edges[i].w;
                unionParent(parent, edges[i].u, edges[i].v);
                maxCity++;
                if(maxCity == N - K) {
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    public static boolean isPowerPlant(int[] parent, int a) {
        a = getParent(parent, a);
        for (int i = 0; i < K; i++) {
            if (a == powerPlant[i]) {
                return true;
            }
        }
        return false;
    }

    public static int getParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        else return parent[x] = getParent(parent, parent[x]);
    }

    public static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        for (int i = 0; i < K; i++) {
            if (a == powerPlant[i]) {
                parent[b] = a;
                return;
            } else if (b == powerPlant[i]) {
                parent[a] = b;
                return;
            }
        }

        if (a > b) parent[a] = b;
        else parent[b] = a;
    }
}
