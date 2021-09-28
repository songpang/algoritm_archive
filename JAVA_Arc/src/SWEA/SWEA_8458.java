package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// SWEA 8458 원점으로 집합
// 아이디어를 떠올리기 굉장히 어려웠던 문제
// 1. 원점까지 거리가 짝/홀수로 통일되어야함
// 2. 가장 큰 값을 i값을 계속해서 더해온값이 넘길 때 짝수여야함
public class SWEA_8458 {
    static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            Point[] points = new Point[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y, Math.abs(x) + Math.abs(y));
            }

            Arrays.sort(points, Comparator.comparingInt(o -> o.distance));

            int result = 0;
            int judge = points[0].distance % 2;
            for (Point point : points) {
                if (point.distance % 2 != judge) {
                    result = -1;
                    break;
                }
            }

            if (result != -1) {
                int th = 0;
                int max = points[N - 1].distance;
                while (th < max || (max - th) % 2 != 0) {
                    th += ++result;
                }
            }

            System.out.printf("#%d %d\n",t, result);
        }
    }
}
