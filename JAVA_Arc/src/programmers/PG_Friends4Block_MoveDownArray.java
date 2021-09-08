package programmers;

import java.util.ArrayList;
import java.util.List;

// 프로그래머스 프렌즈4블록
// 배열 구현문제

public class PG_Friends4Block_MoveDownArray {
    public static void main(String[] args) {
        solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int m, int n, String[] board) {
        char[][] plate = new char[m][n];
        int size = board.length;
        for (int i = 0; i < size; i++) {
            plate[i] = board[i].toCharArray();
        }

        int result = play(m, n, plate);
        int sum = result;
        while (result != 0) {
            result = play(m, n, plate);
            sum += result;
        }

        System.out.println(sum);
        return sum;
    }

    private static int play(int m, int n, char[][] plate) {
        List<Point> deleteList = new ArrayList<>();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (plate[i][j] != 'X' && checkFour(i, j, plate)) {
                    deleteList.add(new Point(i, j));
                }
            }
        }

        int count = deleteFour(deleteList, plate);
        moveDown(plate);
        return count;
    }

    private static void moveDown(char[][] plate) {
        int m = plate.length;
        int n = plate[0].length;

        for (int i = 0; i < n; i++) {
            loop:
            for (int j = m - 1; j > 0; j--) {
                char c = plate[j][i];

                int temp = j;
                while (c == 'X') {
                    if (temp - 1 >= 0) {
                        temp--;
                        c = plate[temp][i];
                    } else {
                        continue loop;
                    }
                }
                plate[j][i] = c;
                for (int k = temp; k < j; k++) {
                    plate[k][i] = 'X';
                }
            }
        }
    }

    private static int deleteFour(List<Point> deleteList, char[][] plate) {
        int size = deleteList.size();
        int count = 0;
        for (int i = 0; i < size; i++) {
            Point t = deleteList.get(i);

            if (plate[t.x][t.y] != 'X') count++;
            if (plate[t.x + 1][t.y] != 'X') count++;
            if (plate[t.x][t.y + 1] != 'X') count++;
            if (plate[t.x + 1][t.y + 1] != 'X') count++;

            plate[t.x][t.y] = 'X';
            plate[t.x + 1][t.y] = 'X';
            plate[t.x][t.y + 1] = 'X';
            plate[t.x + 1][t.y + 1] = 'X';
        }
        return count;
    }

    public static boolean checkFour(int i, int j, char[][] plate) {
        char temp = plate[i][j];

        if (temp == plate[i][j] && temp == plate[i + 1][j]
                && temp == plate[i][j + 1] && temp == plate[i + 1][j + 1]) {
            return true;
        }
        return false;
    }
}
