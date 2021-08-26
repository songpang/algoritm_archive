package backjoon;

// 백준 줄세우기 1681
// 구현
// 스트링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1681 {
        static int N;
    static String L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = st.nextToken();

        int count = 0;
        for (int i = 1; i <= N; i++) {
            count++;
            String temp = String.valueOf(count);
            while(temp.contains(L)) {
                count++;
                temp = String.valueOf(count);
            }
        }

        System.out.println(count);
    }

//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        int cnt = 0;
//        int i = 1;
//        while(true){
//            if(check(i, k)) cnt++;
//            if(cnt==n) break;
//            i++;
//        }
//        System.out.println(i);
//    }
//    public static boolean check(int i, int k){
//        while(i>0){
//            if(i%10==k) return false;
//            i/=10;
//        }
//        return true;
//    }

}
