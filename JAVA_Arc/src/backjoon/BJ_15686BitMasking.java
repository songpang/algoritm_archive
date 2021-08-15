package backjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ_15686BitMasking {
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

        // 0 1 0 0 0 0
        find(chicken.size(), 0, M);

        System.out.println(min);
    }

    public static void find(int n, int start, int M) {
        List<Integer[]> locations;
        for (int i = start; i < 1 << n; i++) {
            locations = new ArrayList<>();
            if (Integer.bitCount(i) == M) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        locations.add(chicken.get(j));

                        int tempMin;
                        int sum = 0;
                        for (Integer[] house : houses) {
                            tempMin = Integer.MAX_VALUE;
                            for (Integer[] location : locations) {
                                tempMin = Math.min(tempMin, Math.abs(house[0] - location[0]) + Math.abs(house[1] - location[1]));
                            }
                            sum += tempMin;
                        }

                        min = Math.min(min, sum);
                    }
                }
            }
        }
    }
}
