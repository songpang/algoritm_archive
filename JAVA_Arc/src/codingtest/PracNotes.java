package codingtest;

import backjoon.BJ_17135;

import java.util.*;

public class PracNotes {
    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        List<Point> test = new ArrayList<>();
        Set<Point> test1 = new HashSet<>();

        test.add(new Point(1, 2));
        test.add(new Point(2, 3));
        test.add(new Point(1, 4));
        test.add(new Point(1, 5));
        test.add(new Point(2, 2));
        test.add(new Point(1, 3));


        for (Point point : test) {
            if(point.x == 2) {
                test1.add(point);
            }
        }

        for (Point point : test1) {
            test.remove(point);
        }

        for (Point point : test) {
            System.out.println(point);
        }
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

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}