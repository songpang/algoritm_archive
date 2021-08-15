package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16935 {
    static int[][] plate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] inputs = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        plate = new int[inputs[0]][inputs[1]];
        for (int i = 0; i < inputs[0]; i++) {
            plate[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (String s : br.readLine().split(" ")) {
            switch (s) {
                case "1":
                    firstFunc();
                    break;
                case "2":
                    secondFunc();
                    break;
                case "3":
                    plate = thirdFunc();
                    break;
                case "4":
                    plate = fourthFunc();
                    break;
                case "5":
                    fifthFunc();
                    break;
                case "6":
                    sixthFunc();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints : plate) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    // 상하반전
    public static void firstFunc() {
        int top = 0;
        int bottom = plate.length - 1;
        int diff = bottom - top;

        for (int i = 0; i < plate.length; i++) {
            for (int j = 0; j < plate[0].length; j++) {
                if (top < bottom) {
                    int temp = plate[i][j];
                    plate[i][j] = plate[i + diff][j];
                    plate[i + diff][j] = temp;
                }
            }
            top++;
            bottom--;
            diff = bottom - top;
        }
    }

    // 좌우 반전
    public static void secondFunc() {
        int left = 0;
        int right = plate[0].length - 1;
        int diff = right - left;

        for (int i = 0; i < plate[0].length; i++) {
            for (int j = 0; j < plate.length; j++) {
                if (left < right) {
                    int temp = plate[j][i];
                    plate[j][i] = plate[j][i + diff];
                    plate[j][i + diff] = temp;
                }
            }
            left++;
            right--;
            diff = right - left;
        }
    }

    public static int[][] thirdFunc() {
        int[][] conversion = new int[plate[0].length][plate.length];

        for (int i = 0; i < conversion.length; i++) {
            for (int j = 0; j < conversion[0].length; j++) {
                conversion[i][j] = plate[plate.length - 1 - j][i];
            }
        }

        return conversion;
    }

    public static int[][] fourthFunc() {
        int[][] conversion = new int[plate[0].length][plate.length];

        for (int i = 0; i < conversion.length; i++) {
            for (int j = 0; j < conversion[0].length; j++) {
                conversion[i][j] = plate[j][plate[0].length - 1 - i];
            }
        }

        return conversion;
    }

    // 하 좌 상 우

    public static void fifthFunc() {
        int[][] temp = new int[plate.length][plate[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = plate[i][j];
            }
        }

        int rh = plate.length / 2;
        int ch = plate[0].length / 2;
        // 4 -> 1
        for (int i = 0; i < rh; i++) {
            for (int j = 0; j < ch; j++) {
                plate[i][j] = plate[i + rh][j];
            }
        }
        // 3 -> 4
        for (int i = rh; i < 2 * rh; i++) {
            for (int j = 0; j < ch; j++) {
                plate[i][j] = plate[i][j + ch];
            }
        }
        // 2 -> 3
        for (int i = 0; i < rh; i++) {
            for (int j = ch; j < 2 * ch; j++) {
                plate[i + rh][j] = plate[i][j];
            }
        }
        // 1 -> 2
        for (int i = 0; i < rh; i++) {
            for (int j = ch; j < 2 * ch; j++) {
                plate[i][j] = temp[i][j - ch];
            }
        }

    }

    public static void sixthFunc() {
        int[][] temp = new int[plate.length][plate[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = plate[i][j];
            }
        }

        int rh = plate.length / 2;
        int ch = plate[0].length / 2;
        // 2 -> 1
        for (int i = 0; i < rh; i++) {
            for (int j = ch; j < 2 * ch; j++) {
                plate[i][j - ch] = plate[i][j];
            }
        }
        // 3 -> 2
        for (int i = 0; i < rh; i++) {
            for (int j = ch; j < 2 * ch; j++) {
                plate[i][j] = plate[i + rh][j];
            }
        }
        // 4 -> 3
        for (int i = rh; i < 2 * rh; i++) {
            for (int j = 0; j < ch; j++) {
                plate[i][j + ch] = plate[i][j];
            }
        }

        // 1 -> 4
        for (int i = 0; i < rh; i++) {
            for (int j = 0; j < ch; j++) {
                plate[i + rh][j] = temp[i][j];
            }
        }
    }
}
