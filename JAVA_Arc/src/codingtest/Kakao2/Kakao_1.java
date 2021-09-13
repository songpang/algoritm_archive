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

        //신고 누적 횟수 Map
        Map<String, Integer> numberMap = new HashMap<>();
        //신고 아이디 Map
        Map<String, Set<String>> idMap = new HashMap<>();


        for(String r : report) {
            String[] split = r.split(" ");
            //merge 함수를 사용해서 1씩 더해주기
            numberMap.merge(split[1], 1, Integer::sum);
            //중복 허용 x 따라서 Set 으로 처리해 놓음
            idMap.computeIfAbsent(split[0], key -> new HashSet<>()).add(split[1]);
        }

        List<Integer> list = new ArrayList<>();
        //신고 아이디 Map 만 반복문을 돈다
        for(String key : idMap.keySet()) {
            int count = 0;
            //신고당한 아이디들 중에 k 보다 큰 개 있으면 count ++ 한다
            for(String value : idMap.get(key)) {
                if(numberMap.get(value) >= k) {
                    count++;
                }
            }
            // list 에 넣어주기
            list.add(count);
        }

        // 내림 차순
        Collections.sort(list, Collections.reverseOrder());

        // idMap 에 없으면 걍 0 이므로 list 의 길이까지만 반복해서 넣어준다.
        int[] answer = new int[id_list.length];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
//    public int[] solution(String[] id_list, String[] report, int k) {
//        Set<String> reportSet = new HashSet<>();
//        Map<String, Integer> reportMap = new HashMap<>();
//        Map<String, List<String>> reportListMap = new HashMap<>();
//        StringTokenizer st;
//
//        for (String s : report) {
//            if(reportSet.add(s)) {
//                st = new StringTokenizer(s);
//                String reporter = st.nextToken();
//                String xxx = st.nextToken();
//
//                if(!reportMap.containsKey(xxx)) {
//                    reportMap.put(xxx, 1);
//                    List<String> t = new ArrayList<>();
//                    t.add(reporter);
//                    reportListMap.put(xxx, t);
//                } else {
//                    reportMap.put(xxx, reportMap.get(xxx) + 1);
//                    List<String> t = reportListMap.get(xxx);
//                    t.add(reporter);
//                    reportListMap.put(xxx, t);
//                }
//            }
//        }
//
//        int[] result = new int[id_list.length];
//        int lLength =  id_list.length;
//
//        // 신고당한 놈들 집함!
//        for (String s : reportMap.keySet()) {
//            if (reportMap.get(s) >= k) { // k 회 이상 신고
//                List<String> t = reportListMap.get(s);
//                for (String s1 : t) {
//                    for (int i = 0; i <lLength; i++) {
//                        if(id_list[i].equals(s1)) {
//                            result[i]++;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
