package codingtest.Kakao;

public class Kakao_1 {
    public static void main(String[] args) {
        System.out.println();
    }
    public static int solution(String s) {
        String[] digit = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        StringBuilder temp = new StringBuilder();

        while (s.length() > 0) {
            for (int i = 0; i < digit.length; i++) {
                if (s.startsWith(digit[i])) {
                    temp.append(i);
                    s = s.substring(digit[i].length());
                    break;
                }
                if(i == 9) {
                    temp.append(s.charAt(0));
                    s = s.substring(1);
                }
            }
        }

        return Integer.parseInt(String.valueOf(temp));
    }
}
