package codingtest;

public class PracNotes {
    public static void main(String[] args) {
        long test = minOperations(13);
        System.out.println(test);

    }

    public static long minOperations(long n) {
        int oneCount = 0;
        int resultCount = 0;
        char[] test = makeBinary(n);
        for (char c : test) {
            if (c == '1') {
                oneCount++;
            }
        }

        // 룰 1 : i번째 바이너리 바꾸려면 i+1 바이너리가 1이고 다른 것(i + 2 ~ 끝)들은 0이어야함
        // 룰 2 : 아니면 오른쪽 끝에 있는 디짓 바꿈

        int lastIdx = test.length - 1;

        loop:
        while (oneCount != 0) {
            if(lastIdx - 2 >= 0) {
                if (test[lastIdx] == '1' && test[lastIdx - 1] == '1' && test[lastIdx - 2] == '1') {
                    test[lastIdx] = '0';
                    oneCount--;
                    resultCount++;
                    continue;
                }
            }
            // 일단 1인놈들 찾아서 규칙에 맞는지 확인하고
            for (int i = 0; i < test.length - 1; i++) {
                if (test[i] == '1' && test[i + 1] == '1' && zeroToEnd(i + 2, test)) {
                    test[i] = '0';
                    oneCount--;
                    resultCount++;
                    continue loop;
                }
            }
            // 그다음 없으면 제일 왼쪽 0?
            // 마지막 1 남은 게 마지막 인덱스면 바꾸고 끝.
            if (oneCount == 1) {
                if (test[lastIdx] == '1') {
                    test[lastIdx] = '0';
                    oneCount--;
                } else {
                    test[lastIdx] = '1';
                    oneCount++;
                }
                resultCount++;
            } else {
                // 0인놈을 1로 만들기? 룰 1에 의해
                if (test[lastIdx] == '1') {
                    if (lastIdx - 3 >= 0 && test[lastIdx - 3] == '1') {
                        test[lastIdx] = '0';
                        oneCount--;
                        resultCount++;
                        continue;
                    }
                }

                for (int i = 0; i < test.length - 1; i++) {
                    if (test[i] == '0' && test[i + 1] == '1' && zeroToEnd(i + 2, test)) {
                        test[i] = '1';
                        oneCount++;
                        resultCount++;
                        continue loop;
                    }
                }

                if (test[lastIdx] == '0') {
                    test[lastIdx] = '1';
                    oneCount++;
                    resultCount++;
                }

            }
        }

        return resultCount;
    }

    private static boolean zeroToEnd(int start, char[] test) {
        int end = test.length;
        if (start == end) {
            return true;
        }

        for (int j = start; j < end; j++) {
            if (test[j] == '1') {
                return false;
            }
        }

        return true;
    }

    public static char[] makeBinary(long n) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            if (n % 2 == 0) {
                sb.insert(0, 0);
            } else {
                sb.insert(0, 1);
            }
            n /= 2;
        }

        return sb.toString().toCharArray();
    }
}
