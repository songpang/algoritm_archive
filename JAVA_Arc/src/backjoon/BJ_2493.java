package backjoon;

import java.io.*;
import java.util.Stack;

public class BJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Tower> st = new Stack<>();

        int i = 1;
        br.readLine();
        for (String s : br.readLine().split(" ")) {
            int tower = Integer.parseInt(s);
            while(!st.isEmpty()) {
                if(st.peek().height >= tower) {
                    bw.write(st.peek().location + " ");
                    break;
                }
                st.pop();
            }
            if(st.isEmpty()) bw.write("0 ");
            st.push(new Tower(i++, tower));
        }
        bw.flush();
    }

    static class Tower {
        int location;
        int height;

        public Tower(int location, int height) {
            this.location = location;
            this.height = height;
        }
    }
}
