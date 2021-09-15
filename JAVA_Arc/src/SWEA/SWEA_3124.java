package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_3124 {
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[E];
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                edges[i] = new Edge(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));

            int[] parent = new int[V+1];
            for (int i = 0; i <= V; i++) {
                parent[i] = i;
            }

            long sum = 0;
            for (int i = 0; i < E; i++) {
                if (!findParent(parent, edges[i].from, edges[i].to)) {
                    unionParent(parent, edges[i].from, edges[i].to);
                    sum += edges[i].weight;
                }
            }

            System.out.printf("#%d %d", t, sum);
        }

    }

    public static int getParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    public static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a > b) parent[b] = a;
        else parent[a] = b;
    }
}
