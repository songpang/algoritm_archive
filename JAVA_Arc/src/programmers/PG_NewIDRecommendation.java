package programmers;

public class PG_NewIDRecommendation {
    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }

    public static String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase().toLowerCase()
                .replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("[.]+", ".") // "[.]{2,}"
                .replaceAll("^[.]|[.]$", "");
        if (answer.equals("")) answer = "a";
        if (answer.length() > 15) answer = answer.substring(0, 15).replaceAll("[.]$", "");
        while (answer.length() < 3) answer += answer.charAt(answer.length() - 1);

        return answer;
    }
}
