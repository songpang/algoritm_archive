package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1828 {
    static class Degree implements Comparable<Degree>{
        int low;
        int high;

        public Degree(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int compareTo(Degree o) {
            return this.high - o.high;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Degree[] degree = new Degree[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            degree[i] = new Degree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(degree);

        int i = 1;
        int deg = degree[0].high;
        int result = 1;

        while(i < N) {
            if(degree[i].low <= deg && degree[i].high >= deg) {
                i++;
            } else {
                result++;
                deg = degree[i].high;
            }
        }

        System.out.println(result);
    }
}
