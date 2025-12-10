//dots
// 1,2 3,4
// 1,3 2,4
// 1,4 2,3

class Solution {
    public static int solution(int[][] dots) {
        int answer = 0;

        float t1 = (float) (dots[0][1] - dots[1][1]) / (float) (dots[0][0] - dots[1][0]);
        float t2 = (float) (dots[2][1] - dots[3][1]) / (float) (dots[2][0] - dots[3][0]);
        if(t1 == t2)
            return 1;

        t1 = (float) (dots[0][1] - dots[2][1]) / (float) (dots[0][0] - dots[2][0]);
        t2 = (float) (dots[1][1] - dots[3][1]) / (float) (dots[1][0] - dots[3][0]);
        if(t1 == t2)
            return 1;

        t1 = (float) (dots[0][1] - dots[3][1]) / (float) (dots[0][0] - dots[3][0]);
        t2 = (float) (dots[1][1] - dots[2][1]) / (float) (dots[1][0] - dots[2][0]);
        if(t1 == t2)
            return 1;

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][] {{1, 4}, {9, 2}, {3, 8}, {11, 6}}));
        System.out.println(Solution.solution(new int[][] {{3, 5}, {4, 1}, {2, 4}, {5, 10}}));
    }
}