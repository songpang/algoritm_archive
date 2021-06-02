/*
Programmers 음양 더하기
 */
package programmers;

public class PG_AddPlusMinus {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        int i = 0;
        for (int absolute : absolutes) {
            if (signs[i]) {
                answer += absolute;
            } else {
                answer -= absolute;
            }
            i++;
        }
        return answer;
    }
}
