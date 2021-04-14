package programmers;

import java.util.Arrays;

public class PG_LifeBoat {
    public static void main(String[] args) {

    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int max = people.length - 1;
        int min = 0;
        for (int i = max; i >= min; i--, answer++) {
            if (people[i] + people[min] <= limit) min++;
        }
        return answer;
    }

}
