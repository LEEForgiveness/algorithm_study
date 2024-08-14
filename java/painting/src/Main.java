class Solution {
    public static int solution(int n, int m, int[] section) {
        boolean painted[] = new boolean[n + 1];
        int answer = 0;

        for(int i = 0; i <= n; i++){
            painted[i] = true;
        }

        for(int no: section){
            painted[no] = false;
        }

        for(int i = 0; i <= n; i++)
        {
            if(!painted[i]){
                for(int j = i; j < i + m; j++){
                    if(j <= n){
                        painted[j] = true;
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
//        System.out.println(Solution.solution(8, 4, new int[] {2,3,6}));
//        System.out.println(Solution.solution(5, 4, new int[] {1,3}));
//        System.out.println(Solution.solution(4, 1, new int[] {1,2,3,4}));
        System.out.println(Solution.solution(10, 3, new int[] {1,3,6,7}));
        System.out.println(Solution.solution(5, 2, new int[] {1,4,5}));
    }
}