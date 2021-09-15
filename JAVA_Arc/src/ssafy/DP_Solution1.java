package ssafy;

public class DP_Solution1 {
    public static void main(String[] args) {
        int[] f = new int[100];

        f[1] = 2;
        f[2] = 5;
        // f3 = f2 + 1cm
        // f4 = f3 + 1cm, f2 + 2cm

        for (int i = 3; i < 100; i++) {
            f[i] = f[i - 1] * 2 + f[i - 2];
        }

        System.out.println(f[6]);
    }
    // 8 2
    // 10
}
