package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_1992 {
    // 빠르고 간결한 답변 ( 백준 랭킹에서 )
    static int arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String arrNumber = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = arrNumber.charAt(j) - '0';
            }
        }

        solution(0, 0, N);
        System.out.println(sb);

    }

    static void solution(int row, int col, int size) {
        if (oneColorCheck(row, col, size)) {

            if (arr[row][col] == 0) {
                sb.append(0);
            } else
                sb.append(1);
            return;
        }
        int newSize = size / 2;
        sb.append("(");
        solution(row, col, newSize);
        solution(row, col + newSize, newSize);
        solution(row + newSize, col, newSize);
        solution(row + newSize, col + newSize, newSize);
        sb.append(")");
    }

    static boolean oneColorCheck(int row, int col, int size) {
        int earlyColor = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (earlyColor != arr[i][j])
                    return false;
            }
        }

        return true;
    }

    // 아래가 내가 푼 답변.
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        int[][] video = new int[N][N];
//        for (int i = 0; i < N; i++) {
//            video[i] = Arrays.stream(br.readLine()
//                    .split("")).mapToInt(Integer::parseInt).toArray();
//        }
//
//        String temp = extract(video, video.length);
//        System.out.println(temp);
//    }
//
//    public static String extract(int[][] video, int size) {
//        boolean isAllOneNum = true;
//
//        loop:
//        for (int i = 0; i < video.length; i++) {
//            for (int j = 0; j < video.length; j++) {
//                if(video[i][j] != video[0][0]) {
//                    isAllOneNum = false;
//                    break loop;
//                }
//            }
//        }
//
//        if(isAllOneNum) {
//            sb.setLength(0);
//            sb.append(video[0][0]);
//            return sb.toString();
//        }
//
//        if (size == 2) {
//            sb.setLength(0);
//            sb.append("(");
//            for (int i = 0; i < 2; i++) {
//                for (int j = 0; j < 2; j++) {
//                    sb.append(video[i][j]);
//                }
//            }
//            sb.append(")");
//            return sb.toString();
//        }
//        int arrSize = video.length / 2;
//
//        int[][] Quadrant1 = new int[arrSize][arrSize];
//        int[][] Quadrant2 = new int[arrSize][arrSize];
//        int[][] Quadrant3 = new int[arrSize][arrSize];
//        int[][] Quadrant4 = new int[arrSize][arrSize];
//
//        for (int i = 0; i < video.length; i++) {
//            if (i < arrSize) {
//                Quadrant1[i] = Arrays.copyOfRange(video[i], 0, arrSize);
//                Quadrant2[i] = Arrays.copyOfRange(video[i], arrSize, video.length);
//            } else {
//                Quadrant3[i - arrSize] = Arrays.copyOfRange(video[i], 0, arrSize);
//                Quadrant4[i - arrSize] = Arrays.copyOfRange(video[i], arrSize, video.length);
//            }
//        }
//
//        return "(" + extract(Quadrant1, arrSize) + extract(Quadrant2, arrSize) +
//                extract(Quadrant3, arrSize) + extract(Quadrant4, arrSize) + ")";
//
//    }
}
