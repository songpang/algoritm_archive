package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16236_DBFS {
    static class Point {
        int r;
        int c;
        int size;

        public Point(int x, int y, int size) {
            this.r = x;
            this.c = y;
            this.size = size;
        }
    }

    static int[][] aquarium;
    static int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int minDistance;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        List<Point> fish = new ArrayList<>();
        Point shark = null;

        aquarium = new int[N][N];
        for (int i = 0; i < N; i++) {
            aquarium[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < N; j++) {
                if (aquarium[i][j] == 9) {
                    shark = new Point(i, j, 2);
                    continue;
                }
                if (aquarium[i][j] != 0) {
                    fish.add(new Point(i, j, aquarium[i][j]));
                }
            }
        }

        if(fish.size() == 0) {
            System.out.println(0);
            return;
        }

        Point closeFish = fish.get(0);
        int time = 0;
        int sharkLevel = 2;
        int fishSize = fish.size();
        aquarium[shark.r][shark.c] = 0;

        for (int i = 0; i < fishSize; i++) {
            int min = Integer.MAX_VALUE;
            for (Point point : fish) {
                if (point.size >= shark.size) {
                    continue;
                }

                int distance = getDistance(shark, point);
                if (min > distance) {
                    min = distance;
                    closeFish = point;
                } else if (min == distance) {
                    // 가장 위에 있는 물고기, 왼쪽
                    if (closeFish.r == point.r) {
                        if (closeFish.c > point.c) {
                            closeFish = point;
                            min = distance;
                        }
                    } else if (closeFish.r > point.r) {
                        closeFish = point;
                        min = distance;
                    }
                }
            }

            if (min != Integer.MAX_VALUE) {
                fish.remove(closeFish);

                time += min;
                shark.r = closeFish.r;
                shark.c = closeFish.c;
                sharkLevel--;

                if (sharkLevel == 0) {
                    shark.size++;
                    sharkLevel = shark.size;
                }
            } else {
                break;
            }
        }
        System.out.println(time);
    }

    public static int getDistance(Point shark, Point fish) {
        minDistance = Integer.MAX_VALUE;
        bfs(fish.r, fish.c, shark, new boolean[N][N]);

        return minDistance;
    }

    public static void bfs(int r, int c, Point shark, boolean[][] visited) {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(r, c, aquarium[r][c]));
        visited[r][c] = true;

        int count = 0;
        while(!pQ.isEmpty()) {
            Point temp = pQ.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = temp.r + DIR[i][0];
                int nextC = temp.c + DIR[i][1];

                if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < N
                        && !visited[nextR][nextC] && aquarium[nextR][nextC] <= shark.size) {

                    if(shark.r == nextR && shark.c == nextC) {
                        minDistance = Math.min(minDistance, count);
                        return;
                    }

                    visited[nextR][nextC] = true;
                    pQ.offer(new Point(nextR, nextC, aquarium[nextR][nextC]));
                }
            }
            count++;
        }

    }

    // 시간초과 DFS
//    public static void dfs(int r, int c, int distance, Point shark, boolean[][] visited) {
//        if (r == shark.r && c == shark.c) {
//            minDistance = Math.min(minDistance, distance);
//            return;
//        }
//
//        if (aquarium[r][c] > shark.size) {
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int nextR = r + DIR[i][0];
//            int nextC = c + DIR[i][1];
//
//            if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < N
//                    && !visited[nextR][nextC]) {
//                visited[nextR][nextC] = true;
//                dfs(nextR, nextC, distance + 1, shark, visited);
//                visited[nextR][nextC] = false;
//            }
//        }
//    }
}





