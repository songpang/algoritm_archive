package programmers;

import java.util.*;
import java.util.regex.Pattern;

public class PG_NewsClustering {

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "FRENCH"));
    }

    public static int solution(String str1, String str2) {
        if(str1.equalsIgnoreCase(str2)) {
            return 65536;
        }

        List<String> str1Set = new ArrayList<>();
        List<String> str2Set = new ArrayList<>();

        String[] newStr1 = str1.toLowerCase().split("");
        String[] newStr2 = str2.toLowerCase().split("");

        List<String> temp2 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = newStr1[i] + newStr1[i + 1];
            if (Pattern.matches("^[a-z]*$", temp)) {
                str1Set.add(temp);
                temp2.add(temp);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String temp = newStr2[i] + newStr2[i + 1];
            if (Pattern.matches("^[a-z]*$", temp)) {
                str2Set.add(temp);
                if (str1Set.contains(temp)) {
                    str1Set.remove(temp);
                } else {
                    temp2.add(temp);
                }
            }
        }

        List<String> tempSet = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String temp = newStr1[i] + newStr1[i + 1];
            if (Pattern.matches("^[a-z]*$", temp)) {
                tempSet.add(temp);
            }
        }

        List<String> temp1 = new ArrayList<>();
        if (tempSet.size() > str2Set.size()) {
            for (int i = 0; i < str2Set.size(); i++) {
                String temp = str2Set.get(i);
                if (tempSet.contains(temp)) {
                    temp1.add(temp);
                    tempSet.remove(temp);
                }
            }
        } else {
            for (int i = 0; i < tempSet.size(); i++) {
                String temp = tempSet.get(i);
                if (str2Set.contains(temp)) {
                    temp1.add(temp);
                    str2Set.remove(temp);
                }
            }
        }

        double ratioJ = ((double)temp1.size() / (double)temp2.size()) * 65536;

        return (int) ratioJ;
    }
}
