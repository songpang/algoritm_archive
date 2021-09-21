package programmers;

import java.util.HashMap;
import java.util.Map;

public class PG_GroupPicture {
    public static void main(String[] args) {
        // 네오 프로도 나란히
        // 라이언 튜브에게서 세칸이상 떨어짐
        //
    }

    static char [] kakaoCHar = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public int solution(int n, String[] data) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            char first = data[i].charAt(0);
            char second = data[i].charAt(2);
            int distance = data[i].charAt(4);

        }



        return answer;
    }

    public static void permutation(int count, int max, boolean[] visited, String[] restriction) {
        if(count == max) {

        }

        for (int i = 0; i < max; i++) {
            if(!visited[i]) {
                visited[i] = true;

                permutation(count + 1, max, visited, restriction);
                visited[i] = false;
            }
        }
    }

}
