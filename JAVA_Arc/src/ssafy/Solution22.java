package ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution22 {
    private static int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    private static int alive;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("./input.txt"));
        Scanner scanner = new Scanner(System.in);

        int testcase = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testcase; i++) {
            int size = scanner.nextInt();
            int bugs = scanner.nextInt();
            scanner.nextLine();

            alive = bugs;

            int[][] pond = new int[size][size];
            int[] location = new int[3];

            while (bugs != 0) {
                bugs--;

                int j = 0;
                for (String a : scanner.nextLine().split(" ")) {
                    location[j++] = Integer.parseInt(a);
                }

                int moveX = direction[location[2] - 1][0];
                int moveY = direction[location[2] - 1][1];

                for(int k = 3; k > 0; k --) {
                    if(!moveBugs(location, pond, moveX, moveY, k)) {
                        break;
                    }

                    if(k == 1) {
                        if (location[0] < 0 || location[1] < 0
                                || location[0] >= pond.length || location[1] >= pond.length
                                || pond[location[0]][location[1]] == 1) {
                            alive--;
                            break;
                        }
                        pond[location[0]][location[1]] = 1;
                    }
                }
            }

            System.out.printf("\n#%d %d", i + 1, alive);
        }
    }

    public static boolean moveBugs(int[] location, int[][] pond, int moveX, int moveY, int count) {
        if (location[0] < 0 || location[1] < 0
                || location[0] >= pond.length || location[1] >= pond.length
                || pond[location[0]][location[1]] == 1) {
            alive--;
            return false;
        }

        location[0] += moveX * count;
        location[1] += moveY * count;

        return true;
    }
}
