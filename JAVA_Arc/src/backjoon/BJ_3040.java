package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_3040 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] shorts = new int[9];

        int count = 0;
        for (int i = 0; i < 9; i++) {
            shorts[count++] = scanner.nextInt();
        }

        combination(0, 7, 0, shorts, new ArrayList<>());
    }

    public static void combination(int sum, int r, int start, int[] shorts, List<Integer> real) {
        if(sum == 100 && r == 0) {
            for (Integer i : real) {
                System.out.println(i);
            }
            return;
        }

        if (r == 0) {
            return;
        }

        for (int i = start; i < shorts.length; i++) {
            real.add(shorts[i]);
            combination(sum + shorts[i], r - 1, i + 1, shorts, real);
            real.remove(real.size() - 1);
        }
    }
}
