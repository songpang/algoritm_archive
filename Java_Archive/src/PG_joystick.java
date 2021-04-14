import java.util.Scanner;

public class PG_joystick {
    public static void main(String[] args) {
        System.out.println(solution("BBBAAB"));
    }

    public static int solution(String name) {
        int answer = 0;
        char[] nameArr = name.toCharArray();

        for (int i = 0; i < nameArr.length; i++) {
            if (nameArr[i] > 77) {
                int over77 = nameArr[i] - 78;
                nameArr[i] -= 64 + 2 * over77;
                answer += nameArr[i];
            } else {
                nameArr[i] -= 64;
                answer += nameArr[i];
            }
        }

        int countA = 0;
        int maxA = 0;
        for (int i = 0; i < nameArr.length; i++) {
            if (nameArr[i] == 1) {
                countA++;
                if (maxA < countA) {
                    maxA = countA;
                }
            } else {
                countA = 0;
            }
        }
        answer -= maxA + 1;
        return answer;
    }
}
