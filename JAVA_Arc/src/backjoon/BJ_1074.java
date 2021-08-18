package backjoon;

import java.util.Scanner;

public class BJ_1074 {
    static int N, r, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();

        double temp = calculateZ(N, r, c);
        System.out.println((int) temp);
    }

    public static double calculateZ(int N, double r, double c) {
        if(N == 0) return r + c;
        double midX = Math.pow(2, N) / 2;
        double midY = Math.pow(2, N) / 2;

        double count = Math.pow(2, 2 * N - 2);
        if(r < midX) {
            // 1사
            if(c < midY) {
                count = 0;
            } else {
                c = c - Math.pow(2, N-1);
            }
        } else {
            // 3사
            if(c < midY) {
                count = count * 2;
                r = r - Math.pow(2, N-1);
            } else {
                count = count * 3;
                r = r - Math.pow(2, N-1);
                c = c - Math.pow(2, N-1);
            }
        }

        return count + calculateZ(N-1, r, c);
    }
}

/*
package day0817;
import java.util.Scanner;
public class Main2 {
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int size = (int) Math.pow(2, N);
        count(size, r, c);
        System.out.println(cnt);
    }
    // 2 3 2
    private static void count(int size, int r, int c) {
        if (size == 1)
            return;
        // 1 2
        // 3 4
        if (r < size / 2 && c < size / 2) { //1
            count(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) { //2
            cnt += (size * size) / 4;
            count(size / 2, r, c - size / 2);
        } else if (r >= size / 2 && c < size / 2) { //3
            cnt += (size * size) / 4 * 2;
            count(size / 2, r - size / 2, c);
        } else { //4
            cnt += (size * size) / 4 * 3;
            count(size / 2, r - size / 2, c - size / 2);
        }
    }
}

 */