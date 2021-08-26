package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1251_Prim_MST {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static Point[] island;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            island = new Point[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                island[i] = new Point(Integer.parseInt(st.nextToken()), i);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                island[i].y = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            boolean[] visited = new boolean[N];
            double[] minEdge = new double[N];
            for (int i = 0; i < N; i++) {
                minEdge[i] = Double.MAX_VALUE;
            }

            double sum = 0;
            minEdge[0] = 0;

            for (int i = 0; i < N; i++) {
                int current = -1;
                double min = Double.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (!visited[j] && min > minEdge[j]) {
                        min = minEdge[j];
                        current = j;
                    }
                }

                visited[current] = true;
                sum += Math.pow(min, 2) * E;

                for (int j = 0; j < N; j++) {
                    if (!visited[j] && minEdge[j] > getDistance(island[current], island[j])) {
                        minEdge[j] = getDistance(island[current], island[j]);
                    }
                }
            }

            System.out.printf("#%d %d\n", t, Math.round(sum));
        }
    }

    public static double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.abs(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)));
    }
}