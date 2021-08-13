package backjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ_15686 {
    static List<Integer[]> houses;
    static List<Integer[]> chicken;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        int[][] city = new int[N][N];
        houses = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            city[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            // 치킨집, 일반집 분리
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 1) {
                    houses.add(new Integer[]{i, j});
                } else if (city[i][j] == 2) {
                    chicken.add(new Integer[]{i, j});
                }
            }
        }

        find(M, new boolean[chicken.size()], 0);

        System.out.println(min);
    }

    public static void find(int r, boolean[] visited, int start) {
        if (r == 0) {
            List<Integer[]> locations = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    locations.add(chicken.get(i));
                }
            }

            int tempMin;
            int sum = 0;
            for (Integer[] house : houses) {
                tempMin = Integer.MAX_VALUE;
                for (Integer[] location : locations) {
                    tempMin = Math.min(tempMin, Math.abs(house[0] - location[0]) + Math.abs(house[1] - location[1]));
                }
                sum += tempMin;
            }

            if (min > sum) {
                min = Math.min(min, sum);
            }
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                find(r - 1, visited, i + 1);
                visited[i] = false;
            }
        }
    }
}
