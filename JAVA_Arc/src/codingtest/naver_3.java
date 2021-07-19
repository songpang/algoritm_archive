package codingtest;

public class naver_3 {
    static int MAX_SONG = 1;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}, 5));
    }

    public static int solution(int[] play_list, int listen_time) {
        int sum = 0;
        for (int i : play_list) {
            sum += i;
        }

        if (listen_time >= sum) {
            return play_list.length;
        }

        int max = 1;
        int index = 0;

        if (listen_time > 1) {
            listen_time--;
            MAX_SONG = ++max;
        } else {
            return MAX_SONG;
        }

        for (int i = 0; i < play_list.length; i++) {
            int temp_time = listen_time;
            while (temp_time - play_list[i % play_list.length] > 0) {
                temp_time -= play_list[i % play_list.length];
                max++;
                i++;
            }
            MAX_SONG = Math.max(MAX_SONG, max);
            i = ++index;
            max = 2;
        }

        return MAX_SONG;
    }
}
