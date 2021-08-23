package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] student = new int[N][2];

        for (int i = 0; i < N; i++) {
            student[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(student, Comparator.comparingInt(o -> o[1]));

        int female = K;
        int male = K;
        int grade = student[0][1];
        int room = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i][1] != grade) {
                if (female != K) room++;
                if (male != K) room++;
                grade = student[i][1];
                female = K;
                male = K;
            }
            if (student[i][0] == 0) female--;
            else male--;

            if(female == 0) {
                female = K;
                room++;
            }
            if(male == 0) {
                male = K;
                room++;
            }
        }

        if(female != K) room++;
        if(male != K) room++;

        System.out.println(room);
    }
}
