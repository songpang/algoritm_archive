package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken();
        List<Integer> sequence = new ArrayList<>();
        sequence.add(1);

        int temp;
        for (int i = 2; i <= N; i++) {
            temp = Integer.parseInt(st.nextToken());
            sequence.add(sequence.size() - temp, i);
        }

        for (Integer integer : sequence) {
            System.out.print(integer + " ");
        }

    }
}
