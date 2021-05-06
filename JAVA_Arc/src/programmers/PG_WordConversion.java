package programmers;

public class PG_WordConversion {
    public int answer;
    public boolean[] used;
    public int solution(String begin, String target, String[] words) {
        answer = words.length;
        used = new boolean[words.length];

        dfs(begin, target, words, 0);
        return (answer == words.length) ? 0 : answer;
    }

    public void dfs(String present, String target, String[] words, int count) {
        if(present.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(!used[i] && check(present, words[i])) {
                used[i] = true;
                dfs(words[i], target, words, count+1);
                used[i] = false;
            }
        }
    }

    private boolean check(String present, String target) {
        int count = 0;
        for (int i = 0; i < present.length(); i++) {
            if(present.charAt(i) != target.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

}
