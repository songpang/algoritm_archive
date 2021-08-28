package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1922번 MST문제
// Union-Find, Kruskal로 해결.
public class BJ_1922_MST {
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }

        Arrays.sort(edges);
        int[] parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int sum = 0;
        for (int i = 0; i < M; i++) {
            if(!findParent(parent, edges[i].from, edges[i].to)) {
                unionParent(parent, edges[i].from, edges[i].to);
                sum += edges[i].weight;
            }
        }

        System.out.println(sum);
    }

    public static int getParent(int[] parent, int x) {
        if(parent[x] == x) return x;
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
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
}
