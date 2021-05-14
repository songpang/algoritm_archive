package hackerRank;

import java.util.List;

public class PickingNumbers {
    public static int pickingNumbers(List<Integer> a) {
        int result = 0;

        for (int i = 0; i < a.size(); i++) {
            int temp = 0;
            int temp2 = 0;
            for (int j = 0; j < a.size(); j++) {
                if (a.get(i) - a.get(j) == 0 || a.get(i) - a.get(j) == 1) {
                    temp++;
                }
                if (a.get(i) - a.get(j) == 0 || a.get(i) - a.get(j) == -1) {
                    temp2++;
                }
            }
            temp = Math.max(temp, temp2);
            result = Math.max(result, temp);
        }

        return result;
    }
}
