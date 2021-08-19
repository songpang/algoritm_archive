package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SWE_1247 {
    static int N;
    static boolean[] visited;
    static int[] location;
    static int min;
    static int[] company;
    static int[] home;
    static List<int[]> customer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;
            company = new int[2];
            home = new int[2];
            customer = new ArrayList<>();

            N = Integer.parseInt(br.readLine());
            location = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < 2; i++) {
                company[i] = location[i];
                home[i] = location[i + 2];
            }

            for (int i = 4; i < location.length; i += 2) {
                customer.add(new int[]{location[i], location[i + 1]});
            }

            visited = new boolean[N];

            permutation(0, 0, company, customer);
            System.out.printf("#%d %d\n", t, min);
        }
    }

    public static void permutation(int count, int totalDistance, int[] start, List<int[]> customers) {

        int[] current = start;
        while (customers.size() != 0) {
            int minLocation;

            for (int i = 0; i < customers.size(); i++) {
                int temp = getDistance(start[0], start[1], customers.get(i)[0], customers.get(i)[1]);
            }
        }
        for (int i = 0; i < N; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                int temp = getDistance(start[0], start[1], customers.get(i)[0], customers.get(i)[1]);
                permutation(count + 1, totalDistance + temp, customers.get(i), customers);
                visited[i] = false;
            }
        }
    }

    // BackTracking
//    public static void permutation(int count, int totalDistance, int[] start, List<int[]> customers) {
//        if (count == N) {
//            int temp2 = getDistance(start[0], start[1], home[0], home[1]);
//            min = Math.min(min, totalDistance + temp2);
//            return;
//        }
//
//        if(totalDistance > min) {
//            return;
//        }
//
//        for (int i = 0; i < N; i ++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                int temp = getDistance(start[0], start[1], customers.get(i)[0], customers.get(i)[1]);
//                permutation(count + 1, totalDistance + temp, customers.get(i), customers);
//                visited[i] = false;
//            }
//        }
//    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
