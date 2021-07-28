package backjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 5목 승리 시 가장 왼쪽 인덱스를 출력해야 했는데
// 좌하로 탐색 시 가장 위의 인덱스를 출력하고 있었다...... 이걸 찾으려고 몇 시간을 고민했는가

public class BJ_2615 {
    private static final int[][] plate = new int[21][21];
    private static final int[][] udrl = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./Test5.txt"));
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                plate[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (plate[i][j] != 0) {
                    for (int k = 0; k < udrl.length; k++) {
                        if (check5Stones(i, j, plate[i][j], k) == 5) {
                            if(k == 3) {
                                i += 4;
                                j -= 4;
                            }
                            System.out.println(plate[i][j]);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static int check5Stones(int x, int y, int color, int direction) {
        int nextX = x + udrl[direction][0];
        int nextY = y + udrl[direction][1];
        int count = 1;

        while (plate[nextX][nextY] != 0 && plate[nextX][nextY] == color) {
            count++;
            nextX += udrl[direction][0];
            nextY += udrl[direction][1];
        }

        if(count == 5) {
            nextX = x - udrl[direction][0];
            nextY = y - udrl[direction][1];

            if(plate[nextX][nextY] == color) {
                count++;
            }
        }

        return count;
    }
}
