package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1244 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int switches = scanner.nextInt();
        int[] status = new int[switches];

        for (int i = 0; i < status.length; i++) {
            status[i] = scanner.nextInt();
        }

        int students = scanner.nextInt();
        int[][] switchGotten = new int[students][2];

        for (int[] ints : switchGotten) {
            ints[0] = scanner.nextInt();
            ints[1] = scanner.nextInt();

            int multiple = ints[1] - 1;
            // 남학생인 경우
            if (ints[0] == 1) {
                while (multiple < status.length) {
                    status[multiple] = status[multiple] == 1 ? 0 : 1;
                    multiple += ints[1];
                }
            } else {
                //여학생인 경우
                int left = ints[1] - 1;
                int right = ints[1] - 1;
                int max = 0;

                while (left >= 0 && right < status.length && status[left] == status[right]) {
                    if (right - (ints[1] - 1) > max) {
                        max++;
                        status[left] = status[left] == 1 ? 0 : 1;
                        status[right] = status[right] == 1 ? 0 : 1;
                    }
                    left--;
                    right++;
                }
                status[ints[1] - 1] = status[ints[1] - 1] == 1 ? 0 : 1;
            }
        }

        int count = 0;
        for (int i : status) {
            if(count < 20) {
                System.out.print(i + " ");
                count++;
            } else {
                System.out.print("\n" +i + " ");
                count = 1;
            }
        }
    }
}
