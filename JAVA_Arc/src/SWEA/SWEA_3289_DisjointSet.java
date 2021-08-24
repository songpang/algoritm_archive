package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 서로소 집합
public class SWEA_3289_DisjointSet {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[] parents = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }

            StringBuilder sb = new StringBuilder();
            int op, a, b;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                op = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if (op == 0) {
                    if (!findParent(parents, a, b)) {
                        unionParent(parents, a, b);
                    }
                } else {
                    if (findParent(parents, a, b)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            System.out.printf("#%d %s\n", t, sb.toString());
        }
    }

    public static int getParent(int[] parents, int x) {
        if (parents[x] == x) return x;
        return parents[x] = getParent(parents, parents[x]);
    }

    public static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }

    public static void unionParent(int[] parents, int a, int b) {
        a = getParent(parents, a);
        b = getParent(parents, b);

        if (a > b) parents[a] = b;
        else parents[b] = a;
    }
}
