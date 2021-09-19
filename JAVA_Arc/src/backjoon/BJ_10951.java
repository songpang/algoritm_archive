package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        while(st.hasMoreTokens()) {
            System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
            String temp;
            if((temp = br.readLine()) == null) break;
            else st = new StringTokenizer(temp);
        }
    }
}
