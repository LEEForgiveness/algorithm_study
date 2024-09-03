import static java.lang.Math.min;

class Solution {
    public static int solution(int a, int b) {
        int answer = 0;
        int greatestCommonDivisor = 1;
        for(int i = 1; i <= min(a, b); i++){
            if(a % i == 0 && b % i == 0){
                greatestCommonDivisor = i;
            }
        }

        a /= greatestCommonDivisor;
        b /= greatestCommonDivisor;

        if(b == 1){
            return 1;
        }

        for(int i = 2; i <= b; i++){
            if(b % i == 0){
                if(i != 5 && i != 2 && i % 5 != 0 && i % 2 != 0){
                    System.out.println(i);
                    answer = 2;
                    break;
                }
                else {
                    answer = 1;
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(7, 20));
//        System.out.println(Solution.solution(11, 22));
//        System.out.println(Solution.solution(12, 21));
//        System.out.println(Solution.solution(9, 18));
//        System.out.println(Solution.solution(1, 8));
//        System.out.println(Solution.solution(3, 9));
//        System.out.println(Solution.solution(1, 12));
    }
}