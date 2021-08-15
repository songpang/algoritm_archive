package algoForBank;

import java.util.Arrays;

public class Combination {
    private static void combination1(int r, int start, boolean[] visited) {
        if(r == 0) {
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination1(r - 1, i + 1, visited);
                visited[i] = false;
            }
        }
    }

        private static void combination(int cnt, int R, int start, int[] numbers, int[] input) {
        if(cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // start 위치의 수부터 가능한 수 모두 고려
        for (int i = start; i < numbers.length; i++) { // i : 인덱스
            numbers[cnt] = input[i];
            // 다음 자리순열 뽑으로 gogo
            combination(cnt+1, R,i+1, numbers, input);
        }

    }
}
