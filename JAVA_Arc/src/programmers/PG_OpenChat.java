package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG_OpenChat {

    public static void main(String[] args) {
        for (String s : solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})) {
            System.out.println(s);
        }
    }

    public static String[] solution(String[] record) {
        List<String[]> log = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Map<String, String> userID = new HashMap<>();

        for (String s : record) {
            String[] info = s.split(" ");
            log.add(info);
            if (!info[0].startsWith("L")) userID.put(info[1], info[2]);
        }

        for (String[] strings : log) {
            if (strings[0].startsWith("E"))
                result.add(userID.get(strings[1]) + "님이 들어왔습니다.");
            else if (strings[0].startsWith("L")) {
                result.add(userID.get(strings[1]) + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[result.size()]);
    }

}
