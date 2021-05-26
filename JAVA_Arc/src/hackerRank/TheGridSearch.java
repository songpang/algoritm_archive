package hackerRank;

import java.util.List;

public class TheGridSearch {
    public static void main(String[] args) {
        String temp = "abcdefghij";
        String part = "fgh";

        System.out.println(temp.indexOf(part));
    }

    public static String gridSearch(List<String> G, List<String> P) {
        int location = 0;
        for (int i = 0; i <= G.size() - P.size(); i++) {
            while (G.get(i).indexOf(P.get(0), location) != -1) {
                location = G.get(i).indexOf(P.get(0), location);
                int j = 1;
                while (j < P.size()) {
                    if (G.get(i + j).indexOf(P.get(j), location) == location) {
                        j++;
                    } else {
                        location++;
                        break;
                    }
                }
                if (j == P.size()) {
                    return "YES";
                }
            }
            location = 0;
        }
        return "NO";
    }
}
