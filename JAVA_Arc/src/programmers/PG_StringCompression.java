package programmers;

public class PG_StringCompression {
    public static int answer;
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    public static int solution(String s) {
        answer = s.length();

        for (int i = (s.length()) / 2; i > 0; i--) { // s의 길이의 반만큼
            findBehind(s, i, answer);
        }

        return answer;
    }

    private static void findBehind(String s, int index, int r) {
        int result = r;


        String newOne = s.substring(0, index);
        String leftOne = s.substring(index);

        int count = 0;
        int temp = index;
        while(leftOne.startsWith(newOne)) {
            count++;
            temp += index;
            leftOne = s.substring(temp);
        }

        if(count > 0) {
            result = result - count * index + 1;
            findBehind(leftOne, index, result);
        }

        answer = Math.min(answer, result);
    }
}


