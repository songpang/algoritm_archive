package programmers;

public class PG_KAKAO_DStringsNEWords {
    public static void main(String[] args) {

    }

    public int solution(String s) {
        StringBuilder result = new StringBuilder();
        String[] dictionary = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                result.append(s.charAt(i));
            } else {
                for (int j = 0; j < dictionary.length; j++) {
                    if(s.substring(i).startsWith(dictionary[j])) {
                        result.append(j);
                        i += dictionary[j].length() - 1;
                        break;
                    }
                }
            }
        }

        return Integer.parseInt(result.toString());
    }
}
