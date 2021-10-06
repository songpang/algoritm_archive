package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17471 {
    static int N, min;
    static int[] population;
    static int[][] adjacent;
    static int totalPopulation = 0;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        population = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            totalPopulation += population[i];
        }

        adjacent = new int[N][N];
        for (int from = 0; from < N; from++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            for (int j = 0; j < size; j++) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                adjacent[from][to] = 1;
                adjacent[to][from] = 1;
            }
        }

        min = Integer.MAX_VALUE;
        parent = new int[N];
        for (int i = 1; i < N / 2 + 1; i++) {
            powerSet(0, 0, i, new int[i]);
        }

        if(min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }

    public static void powerSet(int start, int count, int r, int[] output) {
        if(min == 0) return;
        if(count == r) {
            if(!checkIfInSameGraph(r, output)) {
                return;
            }

            int[] temp = new int[N - r];
            int idx = 0;

            loop:
            for (int i = 0; i < N; i++) {
                for (int k : output) {
                    if (i == k) continue loop;
                }
                temp[idx++] = i;
            }

            if(!checkIfInSameGraph(N - r, temp)) {
                return;
            }

            int outputSum = 0;
            for (int i : output) {
                outputSum += population[i];
            }

            int tempSum = totalPopulation - outputSum;

            min = Math.min(min, Math.abs(outputSum - tempSum));
            return;
        }

        for (int i = start; i < N; i++) {
            output[count] = i;
            powerSet(i + 1, count + 1, r, output);
        }
    }

    private static boolean checkIfInSameGraph(int r, int[] output) {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < r; i++) {
            int a = output[i];

            for (int j = 0; j < N; j++) {
                if(adjacent[a][j] != 0) {
                    for (int o : output) {
                        if(o != a && j == o) {
                            if(!findParent(parent, j, a)) {
                                unionParent(parent, j, a);
                                int big = Math.max(j, a);
                                int small = Math.min(j, a);
                                for (int k = 0; k < parent.length; k++) {
                                    if(parent[i] == big) {
                                        parent[i] = small;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 같은 그래프에 있는지 검사
        int parentValue = parent[output[0]];
        for (int i : output) {
            if(parentValue != parent[i]) return false;
        }

        return true;
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
