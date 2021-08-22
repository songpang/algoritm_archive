package programmers;

import java.util.Arrays;
import java.util.Comparator;

// kruskal 알고리즘 ( + union-find 알고리즘) 기본 문제
// 섬 연결하기
public class PG_Greedy_LInkIslands {
    public static void main(String[] args) {
        solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int sum = 0;
        int length = costs.length;
        for (int i = 0; i < length; i++) {
            if(!findParent(parent, costs[i][0], costs[i][1])) {
                sum += costs[i][2];
                unionParent(parent, costs[i][0], costs[i][1]);
            }
        }

        System.out.println(sum);
        return answer;
    }

    public static int getParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    public static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a == b) return true;
        return false;
    }
}
