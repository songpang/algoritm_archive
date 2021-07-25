package ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int maxValue = 2;
    private static final int[] UD = {1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] RL = {0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseCount = scanner.nextInt();
        scanner.nextLine();

        int number = 0;
        while (caseCount != 0) {
            caseCount--;
            int lineCount = scanner.nextInt();
            scanner.nextLine();

            String[][] testCase2 = new String[lineCount][lineCount];

            for (int i = 0; i < lineCount; i++) {
                testCase2[i] = scanner.nextLine().split(" ");
            }

            solution(testCase2);
            System.out.printf("%n#%d " + maxValue, ++number);
            maxValue = 2;
        }
    }

    public static void solution(String[][] buildingArr) {
        for (int i = 0; i < buildingArr.length; i++) {
            for (int j = 0; j < buildingArr.length; j++) {
                if (buildingArr[i][j].equals("B")) {
                    if (checkPossible(i, j, buildingArr)) {
                        int countB = 0;
                        for (int k = 0; k < buildingArr.length; k++) {
                            if (buildingArr[k][j].equals("B")) {
                                countB++;
                            }
                            if (buildingArr[i][k].equals("B")) {
                                countB++;
                            }
                        }
                        maxValue = Math.max(maxValue, --countB);
                    }
                }
            }
        }
    }

    private static boolean checkPossible(int x, int y, String[][] buildingArr) {
        for (int k = 0; k < UD.length; k++) {
            int nextX = x + UD[k];
            int nextY = y + RL[k];

            if (nextX >= 0 && nextY >= 0
                    && nextX < buildingArr.length && nextY < buildingArr.length
                    && buildingArr[nextX][nextY].equals("G")) {
                return false;
            }
        }
        return true;
    }
}
