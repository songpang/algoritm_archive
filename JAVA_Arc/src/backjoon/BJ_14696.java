package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 딱지놀이
public class BJ_14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] A, B;
        int[] aCount;
        int[] bCount;

        loop:
        for (int i = 0; i < N; i++) {
            aCount = new int[6];
            bCount = new int[6];
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            for (int j = 0; j < size; j++) {
                aCount[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());

            for (int j = 0; j < size; j++) {
                bCount[Integer.parseInt(st.nextToken())]++;
            }

            for (int j = 5; j >= 1; j--) {
                if(aCount[j] > bCount[j]) {
                    System.out.println("A");
                    continue loop;
                }
                else if(aCount[j] < bCount[j]) {
                    System.out.println("B");
                    continue loop;
                }
            }
            System.out.println("D");

        }
    }
}
