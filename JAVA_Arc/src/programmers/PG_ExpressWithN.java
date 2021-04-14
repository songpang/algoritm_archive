package programmers;

public class PG_ExpressWithN {

    static int answer = -1;

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
    }

    private static int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }

    private static void dfs(int N, int number, int count, int prev) {

        if(count > 8) {
            answer = -1;
            return;
        }

        if(number == prev) {
            if(answer == -1 || answer > count)
            answer = count;
            return;
        }

        int tempN = N;
        for (int i = 0; i < 8 - count; i++) {
            dfs(N, number, count+i+1, prev - tempN);
            dfs(N, number, count+i+1, prev + tempN);
            dfs(N, number, count+i+1, prev * tempN);
            dfs(N, number, count+i+1, prev / tempN);

            tempN = tempN * 10 + N;
        }
    }
}
