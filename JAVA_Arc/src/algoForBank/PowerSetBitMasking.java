package algoForBank;

public class PowerSetBitMasking {
    // 비트마스킹을 사용한 powerSet 구하기
    public static void main(String[] args) {
        powerSet(3, new int[]{3, 2, 1});

    }

    public static void powerSet(int N, int[] arr) {
        for (int i = 0; i < 1 << N; i++) {
            for (int j = 0; j < N; j++) {
                if((i & 1 << j) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
