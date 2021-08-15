package programmers;

public class PG_W1_CalculateInsuffi {


    public long solution(int price, int money, int count) {
        long total = 0;

        for (int i = count; i > 0; i--) {
            total +=  (long) price * (long) i;
        }
        // 3 6 9 12
        // 12 + 9 + 6 + 3

        return total - money > 0 ? total - money : 0;
    }
}
