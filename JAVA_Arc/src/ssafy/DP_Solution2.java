package ssafy;

public class DP_Solution2 {
    public static void main(String[] args) {

        int[] f = new int[100];

        f[1] = 2;
        f[2] = 3;
        // f2 = 노노노,파, 노파노, 파노노,파 5
        // 노노노(노, 파) 노노파노 노파노(노, 파) 파노노(노, 파) 파노파노 8

        // 노 > 2개 생김
        // 파 > 1개 생김
        // 1 1 + 1
        // 2 1 * 2 + 1
        // 3 2 * 2 + 1
        // 4 3 * 2 + 1
        // f3 = 노노파노 노파노(노,파) 파노노파 파노파노(노,파) 6

        for (int i = 3; i < 100; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        System.out.println(f[8]);
    }
}
