package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ipt = Integer.parseInt(st.nextToken());
        int idx = 1;
        int p = 1;

        if(ipt == 8) {
            idx = 8;
            p = -1;
        }

        int count = 1;
        while(count != 8) {
            count++;
            idx += p;
            if(idx != Integer.parseInt(st.nextToken())) break;
        }

        if(count != 8) System.out.println("mixed");
        else if (idx == 8) System.out.println("ascending");
        else System.out.println("descending");
    }
}
