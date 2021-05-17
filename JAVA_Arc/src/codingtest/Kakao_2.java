package codingtest;

import java.util.ArrayList;
import java.util.List;

public class Kakao_2 {
//    public static void main(String[] args) {
//        System.out.println(solution());
//    }

    public static int[] solution(String[][] places) {
        int[] answer = {};

        for (String[] pl : places) {
            String[][] seats = new String[6][6];
            for (int i = 0; i < pl.length; i++) {
                seats[i] = pl[i].split("");
            }

            List<String> locationP = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(seats[i][j].equals("P")) {
                        StringBuilder temp = new StringBuilder();
                        temp.append(i).append(j);
                        locationP.add(String.valueOf(temp));
                    }
                }
            }

        }

        //두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면,
        // T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.

        return answer;
    }

}
