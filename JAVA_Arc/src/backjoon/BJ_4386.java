// 언어 : JAVA , 메모리 : 14748 KB , 시간 : 140 ms

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_4386 {
    static class Point {
        double x;
        double y;
        int i;

        public Point(double x, double y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }

    static class Adjacent implements Comparable<Adjacent> {
        Point a;
        Point b;
        double distance;

        public Adjacent(Point a, Point b, double distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Adjacent o) {
            if (this.distance > o.distance) return 1;
            else if(this.distance == o.distance) return 0;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        // 인접한 놈들 리스트
        List<Adjacent> ads = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), i);
        }

        int size = points.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                ads.add(new Adjacent(points[i], points[j], getDistance(points[i], points[j])));
            }
        }

        Collections.sort(ads);

        // 자기 자신의 끝 부모 설정
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double sum = 0;
        int adsSize = ads.size();
        for (int i = 0; i < adsSize; i++) {
            Adjacent temp = ads.get(i);

            // a와 b의 부모가 같지 않다면 서로 다른 그래프에 속하므로 union을 해줘야함
            if(!findParent(parent, temp.a.i, temp.b.i)) {
                unionParent(parent, temp.a.i, temp.b.i);
                sum += temp.distance;
            }
        }

        System.out.printf("%.2f", sum);

    }

    // 아래부터는 평범한 union-find를 위한 메서드!
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

    public static double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}

