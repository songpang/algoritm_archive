package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9205 {
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

    static Set<Point> pSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Point[] points = new Point[n + 2];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            pSet = new HashSet<>();
            bfs(points, n);
        }
    }


    public static void bfs(Point[] points, int n) {
        Queue<Point> pq = new LinkedList<>();
        pq.offer(points[0]);
        pSet.add(points[0]);

        while(!pq.isEmpty()) {
            Point temp = pq.poll();

            if(temp.x == points[points.length - 1].x && temp.y == points[points.length - 1].y) {
                System.out.println("happy");
                return;
            }

            for (int i = 1; i < n + 2; i++) {
                int distance = getManhattanDistance(temp, points[i]);
                if(distance <= 1000) {
                    int size = pSet.size();
                    pSet.add(points[i]);
                    if(size != pSet.size()) {
                        pq.offer(points[i]);
                    }
                }
            }

        }
        System.out.println("sad");
    }

    public static int getManhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
