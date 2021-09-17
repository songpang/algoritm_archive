package programmers;

import java.util.Arrays;

public class PG_CarryGoldSilver{
    static class City implements Comparable<City>{
        int g;
        int s;
        int w;
        int t;

        public City(int g, int s, int w, int t) {
            this.g = g;
            this.s = s;
            this.w = w;
            this.t = t;
        }

        @Override
        public int compareTo(City o) {
            return this.t - o.t;
        }
    }

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;

        // 금이나 은 따로 관리해서 둘 중 큰걸 리턴해야됨
        // 클래스로 만들어서 정렬한다음에
        // 작은 놈들부터 빠르게 채운다
        int size = g.length;
        City[] cities = new City[size];
        for (int i = 0; i < size; i++) {
            cities[i] = new City(g[i], s[i], w[i], t[i]);
        }

        Arrays.sort(cities);

        int goldQuota = a;
        int silverQuota = a;

        for (int i = 0; i < size; i++) {

        }

        return answer;
    }
}
