package programmers;

import java.util.Arrays;
import java.util.Stack;

public class PG_EditTable {

    public static void main(String[] args) {
        solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        String[] result = new String[n];
        Arrays.fill(result, "O");

        Stack<Integer> prison = new Stack<>();

        int currentLocation = k;
        int currentCount = n;

        for (String s : cmd) {
            char func = s.charAt(0);

            if(s.length() > 1) {
                int count = Integer.parseInt(s.substring(2));

                if(func == 'D') {
                    currentLocation += count;
                } else {
                    currentLocation -= count;
                }
            } else {
                if(func == 'C') {
                    result[currentLocation] = "X";

                    if(currentLocation == n - 1) {
//                        currentLocation;
                        // 끝에 다다른 걸 판단하기 위해서
                        //
                    }
                    currentLocation++;
                } else {

                }
            }


        }
        return answer;
    }

    // 일단 들어온 스트링 읽고 판단한다.
    // 판단하고 이동이면 커서 이동.
    // 삭제면 삭제
    // 복구면 복구

    // 근데

}

/*
"U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
"D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.

"C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다.
 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.

"Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다.
 단, 현재 선택된 행은 바뀌지 않습니다.
 */