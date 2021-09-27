package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1755 {
    static class Number implements Comparable<Number>{
        int number;
        String enNumber;

        public Number(int number, String enNumber) {
            this.number = number;
            this.enNumber = enNumber;
        }

        @Override
        public int compareTo(Number o) {
            return this.enNumber.compareTo(o.enNumber);
        }
    }

    static String[] numbers = {"zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        List<Number> numberSorted = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            String first = null;
            int div = i / 10;
            if (div == 0) {
                first = numbers[i];
            } else {
                first = numbers[div];
                first += numbers[i % 10];
            }
            numberSorted.add(new Number(i, first));
        }

        numberSorted.sort(Comparator.naturalOrder());
        for (int i = 0; i <= N - M; i++) {
            if(i != 0 && i % 10 == 0) System.out.println();
            System.out.print(numberSorted.get(i).number + " ");
        }
    }
}
