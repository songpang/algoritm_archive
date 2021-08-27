package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// 백준 2527 직사각형
// 단순 구현 문제.
public class BJ_2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int first = N;
        int second;
        int count = 2;
        int max = 0;

        List<Integer> store = new ArrayList<>();

        for (int i = N / 2; i <= N; i++) {
            second = i;
            List<Integer> tempList = new ArrayList<>();
            tempList.add(first);
            tempList.add(second);

            while(first - second >= 0) {
                int temp = first - second;
                first = second;
                second = temp;
                tempList.add(temp);
                count++;
            }

            if(max < count) {
                max = count;
                store = tempList;
            }

            first = N;
            count = 2;
        }

        System.out.println(max);

        for (Integer integer : store) {
            System.out.print(integer + " ");
        }
    }

}