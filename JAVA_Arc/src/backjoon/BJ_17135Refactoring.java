package backjoon;

import java.io.IOException;
import java.util.*;

public class BJ_17135Refactoring {
    static int N, M, D;
    static int maxHostile = 0;
    static int[][] plate;
    static Set<Point> hostile;
    static List<Point> hostileLocation = new ArrayList<>();

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
            for (int i = 0; i < plate[t].length; i++) {
                if (plate[t][i] == 1) {
                    hostileLocation.add(new Point(t, i));
                }
            }
        }

        combination(0, 3, new boolean[M]);

        System.out.println(maxHostile);
    }

    public static void combination(int start, int r, boolean[] visited) {
        if (r == 0) {
            List<Integer> archers = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    archers.add(i);
                }
            }

            // 아처의 위치는 라운드 진행마다 한 칸 씩 위로 가면됨
            int curArcher = plate.length;
            int max = 0;

            // 아처는 마지막부터 0까지 가야함.
            List<Point> copyHostile = new ArrayList<>(hostileLocation);
            for (int t = 0; t < plate.length; t++) {
                hostile = new HashSet<>();
                for (Integer archer : archers) {
                    int min = Integer.MAX_VALUE;
                    Point closest = new Point(16, 16);

                    for (Point point : copyHostile) {
                        if (point.x >= curArcher) continue;

                        int distance = getManhattanDistance(point, new Point(curArcher, archer));
                        if (distance > D) continue;
                        if (min > distance) {
                            min = distance;
                            closest = point;
                        } else if (min == distance) {
                            if (closest.y > point.y) {
                                closest = point;
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
                //삭제 해야됨
                for (Point point : hostile) {
                    copyHostile.remove(point);
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
}

