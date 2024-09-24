//5*4*3*2*1 / 2*1 / 3*2*1
//3*2*1 / 1 / 2*1
//4*3*2*1 / 2*1 / 2*1

//answer = answer * (balls - i) / (i + 1);를 하면 답이 나오는 이유 위에 예시를 보면 balls! 한거를
//(n - m)!한거로 나누면 결국에는 balls - 0, balls - 1,..., balls - share + 1까지 곱한거가 분자가 됨
//그리고 (i + 1)은 share!를 말하는 거임!!

class Solution {
    public static long solution(int balls, int share) {
        long answer = 1;
        int temp = balls - share;

        if(temp == 0){
            return 1;
        }

        for(int i = 0; i < share; i++){
            answer = answer * (balls - i) / (i + 1);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(3, 2));
        System.out.println(Solution.solution(5, 3));
        System.out.println(Solution.solution(30, 15));
    }
}