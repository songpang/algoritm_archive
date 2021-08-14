package codingtest.Toss;

public class Toss1 {
    public static void main(String[] args) {

    }

    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        // total : 공급 대가

        // 과세 10%
        // 공급 가액 - 비과세 금액 = 과세 금액
        // 주문금액 - 공급 가액 = 부가세 리턴
        // 공급 가액 + answer  = orderAmount
        // 공급대가 = 공급 가액 + 부가세
        // 공급대가 = 주문 금액
        // 주문금액 - 공급 가액 = 부가세
        // 공급 가액 - 비과세 금액 x 10%
        // (x - 비과세) x 1/10 == 부과세
        //  x + 부과세 = 주문금액
        // 위는 공급 대가
        // orderAmount =
//        long total = 0;
//        long answer = 0;
//        double temp = 0;
//
////        answer = (orderAmount - taxFreeAmount) * 0.1;
//        // 봉사료 있으면 공급대가 = 주문금액 - 서비스
//        if(serviceFee != 0) {
//            total = orderAmount - serviceFee - taxFreeAmount;
//        } else {
//            total = orderAmount - taxFreeAmount;
//        }
//
//        temp = (orderAmount - taxFreeAmount) * 0.1;
//
//        return answer;
        double ans = (orderAmount-taxFreeAmount-serviceFee)/10+0.5;
        return (long)ans;
    }

}
