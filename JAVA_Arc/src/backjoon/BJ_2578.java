package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 2578 빙고
// 단순 구현
public class BJ_2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {
            bingo[i] = Arrays.stream(br.readLine().split(" "))
                    .sequential().mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int t = 0; t < 5; t++) {
                if (count >= 12 && checkBingo(bingo)) {
                    System.out.println(count);
                    return;
                }
                int next = Integer.parseInt(st.nextToken());
                loop:
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (bingo[j][k] == next) {
                            bingo[j][k] = 0;
                            count++;
                            break loop;
                        }
                    }
                }
            }
        }
    }

    private static boolean checkBingo(int[][] bingo) {
        int count = 0;

        // 가로 세로 검사
        for (int i = 0; i < 5; i++) {
            int countR = 0;
            int countC = 0;
            for (int j = 0; j < 4; j++) {
                if ((bingo[i][j] == bingo[i][j + 1])) {
                    countR++;
                }
                if ((bingo[j][i] == bingo[j + 1][i])) {
                    countC++;
                }
                if(j == 3 && countR == 4) {
                    count++;
                }
                if(j == 3 && countC == 4) {
                    count++;
                }
            }
        }

        int countCross = 0;
        int countCross2 = 0;
        for (int i = 0; i < 4; i++) {
            if(bingo[i][i] == bingo[i + 1][i + 1]) {
                countCross++;
                if(i == 3 && countCross == 4) {
                    count++;
                }
            }

            if(bingo[i][4 - i] == bingo[i + 1][4 - i - 1]) {
                countCross2++;
                if(i == 3 && countCross2 == 4) {
                    count++;
                }
            }
        }

        return count >= 3;
    }
}
