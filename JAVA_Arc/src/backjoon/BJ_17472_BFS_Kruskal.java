package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17472_BFS_Kruskal {
    static class Point {
        int x;
        int y;
        int number;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Adjacent {
        Point pFrom;
        Point pTo;
        int weight;

        public Adjacent(Point pFrom, Point pTo, int weight) {
            this.pFrom = pFrom;
            this.pTo = pTo;
            this.weight = weight;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int islandCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        Queue<Point> points = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    points.add(new Point(i, j));
                }
            }
        }

        // 섬을 찾아서 6이하의 정수로 마킹
        markNumber(points);

        List<Adjacent> adjacents = new ArrayList<>();

        // 처음으로 맞는 섬 인접 리스트에 넣는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    Point p1 = new Point(i, j);
                    p1.number = map[i][j];

                    int count = 0;
                    while (map[i][j] != 0 && j < M) j++;
                    while (map[i][j] == 0 && j < M) {
                        count++;
                        j++;
                    }

                    if (j < M) {
                        Point p2 = new Point(i, j);
                        p2.number = map[i][j];
                        if (count >= 2) {
                            adjacents.add(new Adjacent(p1, p2, count));
                        }
                    }
                    j--;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[j][i] != 0) {
                    Point p1 = new Point(j, i);
                    p1.number = map[j][i];

                    int count = 0;
                    while(map[j][i] != 0 && j < N) j++;
                    while(map[j][i] == 0 && j < N) {
                        count++;
                        j++;
                    }

                    if(j < N) {
                        Point p2 = new Point(j, i);
                        p2.number = map[j][i];
                        if(count >= 2) {
                            adjacents.add(new Adjacent(p1, p2, count));
                        }
                    }
                    j--;
                }
            }
        }

        adjacents.sort(Comparator.comparingInt(o -> o.weight));


        // 크루스칼로 긋고

        int[] parent = new int[islandCount + 1];
        for (int i = 2; i <= islandCount; i++) {
            parent[i] = i;
        }

        int size = adjacents.size();
        // 3 7
        int count = 0;
        for (int i = 0; i < size; i++) {
            Adjacent temp = adjacents.get(i);

            if(!findParent(parent, temp.pFrom.number, temp.pTo.number)) {
                unionParent(parent, temp.pFrom.number, temp.pTo.number);
                count += temp.weight;
            }
        }

        if(count == 0) {
            count = -1;
        }

        int sameParent = 0;
        for (int i = 2; i <= islandCount ; i++) {
            if(i == parent[i]) {
                sameParent++;
            }
            if(sameParent == 2) {
                count = -1;
            }
        }

        // 4 4 4 4 4
        // 3 3 4 4 4
        //

        System.out.println(count);
    }

    public static void markNumber(Queue<Point> points) {
        Queue<Point> pq = new LinkedList<>();
        int markingNumber = 2;

        while (!points.isEmpty()) {
            Point temp = points.poll();
            if (map[temp.x][temp.y] != 1) {
                continue;
            }
            pq.offer(temp);
            temp.number = markingNumber;
            islandCount = markingNumber;
            map[temp.x][temp.y] = markingNumber;

            while (!pq.isEmpty()) {
                temp = pq.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = temp.x + DIR[i][0];
                    int ny = temp.y + DIR[i][1];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1) {
                        pq.offer(new Point(nx, ny));
                        map[nx][ny] = markingNumber;
                    }
                }
            }

            temp.number = markingNumber;
            markingNumber++;
        }
    }

    public static int getParent(int[] parents, int x) {
        if(parents[x] == x) return x;
        return parents[x] = getParent(parents, parents[x]);
    }

    public static boolean findParent(int[] parents, int a, int b) {
        a = getParent(parents, a);
        b = getParent(parents, b);
        return a == b;
    }

    public static void unionParent(int[] parents, int a, int b) {
        a = getParent(parents, a);
        b = getParent(parents, b);
        if(a > b) parents[b] = a;
        else parents[a] = b;
    }
}