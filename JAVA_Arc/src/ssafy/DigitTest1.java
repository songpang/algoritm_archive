package ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class DigitTest1 {
    public static void main(String[] args) {
        int[] countDigit = new int[10];

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int number = scanner.nextInt();
            if(number == 0) {
                break;
            }
            countDigit[number/10]++;
        }

        for (int i = 0; i < countDigit.length; i++) {
            if(countDigit[i] != 0) {
                System.out.printf("%d : %d개 \n", i, countDigit[i]);
            }
        }
    }
}
