package codingtest.Kakao2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Kakao_6 {
    @Test
    public void test() {
        Assertions.assertEquals(10,
                solution(new int[][] {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}},
        new int[][] {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}));
    }

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for (int[] oper : skill) {
            if(oper[0] < 2) { // 적 공격
                for (int i = oper[1]; i <= oper[3]; i++) {
                    for (int j = oper[2]; j <= oper[4]; j++) {
                        board[i][j] -= oper[5];
                    }
                }
            } else { // 회복
                for (int i = oper[1]; i <= oper[3]; i++) {
                    for (int j = oper[2]; j <= oper[4]; j++) {
                        board[i][j] += oper[5];
                    }
                }
            }
        }

        int col = board[0].length;

        for (int[] ints : board) {
            for (int j = 0; j < col; j++) {
                if (ints[j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
