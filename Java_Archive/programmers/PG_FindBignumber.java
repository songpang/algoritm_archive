public class PG_FindBignumber {
    public static void main(String[] args) {
        solution("4177252841", 4);
    }

    public static String solution(String name, int k) {
        String answer = "";

        int len = name.length();
        int flag = 0;
        int maxNumber;

        for (int i = 0; i < len - k; i++) {
            maxNumber = -1;
            for (int j = flag; j <= k + i; j++) {
                int next = name.charAt(j) - '0';
                if (maxNumber < next) {
                    maxNumber = next;
                    flag = j;
                }
                if(maxNumber == 9)
                    break;
            }
            answer += name.charAt(flag);
            flag++;
        }
        return answer;
    }
}
