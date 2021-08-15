package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> josephus = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int N = scanner.nextInt();
        int jump = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            josephus.add(i);
        }

        int idx = 0;
        while (josephus.size() != 0) {
            if (idx - 1 + jump >= josephus.size()) {
                int temp = idx + jump - josephus.size();
                idx = (temp - 1) % josephus.size();
            } else {
                idx = idx - 1 + jump;
            }
            result.add(josephus.remove(idx));
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (Integer integer : result) {
            sb.append(integer + ", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb.toString());
    }
}
