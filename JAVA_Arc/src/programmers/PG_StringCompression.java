package programmers;

public class PG_StringCompression {
    public static void main(String[] args) {
        System.out.println(solution("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxz"));
    }

    // 다시 풀어보기
    public static int solution(String s) {
        if(s.length() == 1 ) return 1;

        int answer = 1001;
        for (int i = 1; i < s.length() / 2; i++) {
            String now = "", next = "", result = "";
            int count = 1;
            for (int j = 0; j <= s.length() / i; j++) {
                int start = j * i;
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
                now = next;
                next = s.substring(start, end);

                if(now.equals(next)) {
                    count++;
                } else {
                    result += (processHit(count) + now);
                    count = 1;
                }
            }
            result += processHit(count) + now;
            answer = Math.min(answer, result.length());
        }

        return answer;
    }

    private static String processHit(int count) {
        return count > 1 ? String.valueOf(count) : "";

    }


}
