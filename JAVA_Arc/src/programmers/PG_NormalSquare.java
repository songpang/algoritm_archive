/*
Point : 공약수는 찾았지만 이후 제외되는 사각형의 규칙은 찾기 못함
        대각선을 1차방정식으로 보고 아래 사각형의 갯수를 구한 뒤 * 2
        int -> long 의 캐스팅을 적절히 해주지 않으면 타당한 알고리즘에도 불구하고 실패.
 */


package programmers;

public class PG_NormalSquare {
    public static void main(String[] args) {

    }
// solution 1

//    public long solution(int w, int h) {
//        int hson = gcd(w, h);
//        return ((long)w * (long)h - ((long)w / hson + (long)h / hson - 1) * hson);
//    }
//
//    public static int gcd(int a, int b) {
//        if (a % b == 0) {
//            return b;
//        } else {
//            return gcd(b, a % b);
//        }
//    }

    //solution 2
    public long solution(int w, int h) {
        long sum = 0;
        for (int i = 0; i < (long)w; i++) {
            sum += i * (long) h / (long) w;
        }

        long answer = 0;

        for (int i = 0; i < w; i++) {
            answer += h * i / w;
        }

        return sum * 2;
    }
}
