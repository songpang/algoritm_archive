package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2239 {
    static final int SUDOKU_SIZE = 9;
    static int[][] sudoku;
    static List<Point> zeroList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input;

        sudoku = new int[SUDOKU_SIZE][SUDOKU_SIZE];
        zeroList = new ArrayList<>();

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            input = br.readLine().toCharArray();
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                sudoku[i][j] = input[j] - '0';
                if (sudoku[i][j] == 0) {
                    zeroList.add(new Point(i, j));
                }
            }
        }

        dfs(0);
        // 시간초과
//        while(zeroList.size() != 0) {
//            int size = zeroList.size();
//            loop:
//            for (int j = 0; j < size; j++) {
//                Point point = zeroList.get(j);
//                int isOnly = 0;
//                int lastIdx = 0;
//                for (int i = 1; i <= SUDOKU_SIZE; i++) {
//                    // 9까지 검사해서 true가 1개면 수정
//                    // 2개 이상이면 다음으로 넘어감
//                    if (isRowFit(point, i) && isColFit(point, i) && isLocalFit(point, i)) {
//                        isOnly++;
//                        lastIdx = i;
//                        if(isOnly > 1) {
//                            continue loop;
//                        }
//                    }
//                }
//
//                if(isOnly == 1) {
//                    sudoku[point.x][point.y] = lastIdx;
//                    zeroList.remove(point);
//                    j--;
//                    size--;
//                }
//            }
//        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints : sudoku) {
            for (int anInt : ints) {
                sb.append(anInt);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isRowFit(Point point, int value) {
        int row = point.x;

        for (int i : sudoku[row]) {
            if (i == value) return false;
        }

        return true;
    }

    public static boolean isColFit(Point point, int value) {
        int col = point.y;

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (sudoku[i][col] == value) return false;
        }

        return true;
    }

    public static boolean isLocalFit(Point point, int value) {
        int col = point.y / 3 * 3;
        int row = point.x / 3 * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (sudoku[i][j] == value) return false;
            }
        }

        return true;
    }

    static boolean dfs(int count) {
        if (count == zeroList.size()) {
            return true;
        }

        Point point = zeroList.get(count);
        int row = point.x;
        int col = point.y;

        for (int i = 1; i <= SUDOKU_SIZE; i++) {
            if (isRowFit(point, i) && isColFit(point, i) && isLocalFit(point, i)) {
                sudoku[row][col] = i;
                if (dfs(count + 1)) {
                    return true;
                } else {
                    sudoku[row][col] = 0;
                }
            }
        }

        return false;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
