package algoForBank;

public class FindArrayPair {
    //주어진 배열이 있을 때 i < j 이고 nums[i] == nums[j] 가 되는 짝의 개수를 세라
    // ex) nums : [1,2,3,1,1,3]
    // solution) pairs : (0,3) (0,4) (3,4) (2,5)
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(isPair(nums[i], nums[j], i, j)) answer++;
            }
        }
        return answer;
    }

    public boolean isPair(int x, int y, int i, int j) {
        return x == y && i < j ? true : false;
    }
}