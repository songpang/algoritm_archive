// 언어 : JAVA , 메모리 : 16264 KB , 시간 : 172 ms
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 팰린드롬 만들기 1213
// 팰린드롬, 문자열, 구현

public class BJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String enName = br.readLine();

        int[] alphabet = new int[26];

        // 입력값을 char 배열로 하나씩 돌면서 저장
        int size = enName.length();
        for (int i = 0; i < size; i++) {
            alphabet[enName.charAt(i) - 'A']++;
        }

        int oddCount = 0;
        String temp = "";
        // 팰린드롬 정 가운데에는 홀수여도 상관 없음
        // 홀수 처리하고 continue 해줘야함!
        // 홀수인 놈을 가운데에 몰아넣어서 틀렸는데 제 위치에 가져다 놓고 1개만 가운데에 박으니 통과.
        //bbbaaabbb
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 == 1) {
                if(oddCount == 1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                oddCount++;
                temp += (char)(i + 'A');
                alphabet[i]--;
            }

            if (alphabet[i] != 0) {
                int half = alphabet[i] / 2;
                for (int j = 0; j < half; j++) {
                    sb.append((char) (i + 'A'));
                }
            }
        }

        // 짝수인 부분 앞에 만들고 reverse해서 뒤에 붙이기
        // 붙이기 전에 홀수여서 빼놨던 temp를 먼저 붙인다.
        String reverse = reverse(sb.toString());
        sb.append(temp);
        sb.append(reverse);
        System.out.println(sb.toString());
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();

        int size = s.length();
        for (int i = size - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
