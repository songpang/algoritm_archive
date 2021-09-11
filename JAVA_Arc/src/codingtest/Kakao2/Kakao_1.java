package codingtest.Kakao2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Kakao_1 {
    @Test
    public void test() {
        Assertions.assertEquals(new int[]{2,1,1,0}, solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},  2));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> reportSet = new HashSet<>();
        Map<String, Integer> reportMap = new HashMap<>();
        Map<String, List<String>> reportListMap = new HashMap<>();
        StringTokenizer st;

        for (String s : report) {
            if(reportSet.add(s)) {
                st = new StringTokenizer(s);
                String reporter = st.nextToken();
                String xxx = st.nextToken();

                if(!reportMap.containsKey(xxx)) {
                    reportMap.put(xxx, 1);
                    List<String> t = new ArrayList<>();
                    t.add(reporter);
                    reportListMap.put(xxx, t);
                } else {
                    reportMap.put(xxx, reportMap.get(xxx) + 1);
                    List<String> t = reportListMap.get(xxx);
                    t.add(reporter);
                    reportListMap.put(xxx, t);
                }
            }
        }

        int[] result = new int[id_list.length];
        int lLength =  id_list.length;

        // 신고당한 놈들 집함!
        for (String s : reportMap.keySet()) {
            if (reportMap.get(s) >= k) { // k 회 이상 신고
                List<String> t = reportListMap.get(s);
                for (String s1 : t) {
                    for (int i = 0; i <lLength; i++) {
                        if(id_list[i].equals(s1)) {
                            result[i]++;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
