package backjoon;

import java.io.IOException;
import java.util.*;

public class BJ_17135 {
    static int N, M, D;
    static int maxHostile = 0;
    static int[][] plate;
    static Set<Point> hostile;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        D = scanner.nextInt();
        scanner.nextLine();

        plate = new int[N][M];

        for (int t = 0; t < N; t++) {
            plate[t] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        combination(0, 3, new boolean[M]);

        System.out.println(maxHostile);
    }

    public static void combination(int start, int r, boolean[] visited) {
        if (r == 0) {
            List<Integer> archers = new ArrayList<>();
            int[][] plateClone = deepCopy(plate);
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    archers.add(i);
                }
            }

            // 아처의 위치는 라운드 진행마다 한 칸 씩 위로 가면됨
            int curArcher = plate.length;
            int max = 0;

            // 아처는 마지막부터 0까지 가야함.
            for (int t = 0; t < plate.length; t++) {
                hostile = new HashSet<>();
                for (Integer archer : archers) {
                    int min = Integer.MAX_VALUE;
                    Point closest = new Point(16, 16);

                    for (int i = 0; i < curArcher; i++) {
                        for (int j = 0; j < plate[0].length; j++) {
                            if (plateClone[i][j] == 1) {
                                int distance = getManhattanDistance(new Point(i, j), new Point(curArcher, archer));
                                if (distance > D) continue;
                                if (min > distance) {
                                    min = distance;
                                    closest = new Point(i, j);
                                } else if (min == distance) {
                                    // 가장 왼쪽인 j 저장
                                    if (closest.y > j) {
                                        closest = new Point(i, j);
                                    }
                                }
                            }
                        }
                    }
                    if (closest.x != 16) {
                        hostile.add(closest);
                    }
                }
                // 아처 위치 한단계 위로.
                curArcher--;
                max += hostile.size();
                for (Point point : hostile) {
                    plateClone[point.x][point.y] = 0;
                }
            }

            maxHostile = Math.max(max, maxHostile);
        }

        for (int i = start; i < M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, r - 1, visited);
                visited[i] = false;
            }
        }

    }

    public static int getManhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int[][] deepCopy(int[][] origin) {
        if (origin == null) return null;
        int[][] result = new int[origin.length][origin[0].length];

        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
        }

        return result;
    }
}
