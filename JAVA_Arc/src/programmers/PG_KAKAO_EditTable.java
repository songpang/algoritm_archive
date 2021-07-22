package programmers;

import java.util.Arrays;
import java.util.Stack;

public class PG_KAKAO_EditTable {

    public static void main(String[] args) {
        solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"});
    }


    //배열에 담고 인덱스 움직여 탐색하는 수행 : 효율성 탈락
    public static String solution(int n, int k, String[] cmd) {
        String[] result = new String[n];
        Arrays.fill(result, "O");
        Stack<Integer> prison = new Stack<>();
        int currentLocation = k;

        for (String s : cmd) {
            char func = s.charAt(0);

            if (s.length() > 1) {
                int count = Integer.parseInt(s.substring(2));

                if (func == 'D') {
                    // 사이에 X가 있나 없나 검사 해줘야함.
                    while (count != 0) {
                        if (result[currentLocation + 1].equals("O")) {
                            count--;
                        }
                        currentLocation++;
                    }
                } else {
                    while (count != 0) {
                        if (result[currentLocation - 1].equals("O")) {
                            count--;
                        }
                        currentLocation--;
                    }
                }
            } else {
                if (func == 'C') {
                    int temp = currentLocation;
                    result[currentLocation] = "X";
                    prison.push(currentLocation);

                    if (currentLocation != n - 1) {
                        currentLocation++;

                        while (result[currentLocation].equals("X") && currentLocation != n - 1) {
                            currentLocation++;
                        }
                    }

                    if (result[currentLocation].equals("X") && currentLocation == n - 1) {
                        currentLocation = temp - 1;
                        while (result[currentLocation].equals("X") && currentLocation != 0) {
                            currentLocation--;
                        }
                    }
                } else {
                    result[prison.pop()] = "O";
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (String s : result) {
            answer.append(s);
        }
        return answer.toString();
    }
}

/*
"U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
"D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.

"C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다.
 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.

"Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다.
 단, 현재 선택된 행은 바뀌지 않습니다.
 */