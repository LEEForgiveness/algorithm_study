import java.util.*;

class Solution {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < tangerine.length; i++){
            count.put(tangerine[i], count.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(count.values());
        list.sort(((o1, o2) -> o2 - o1));

        int kind = 0;
        int sum = 0;

        for(int l: list){
            kind += 1;
            sum += l;
            if(sum >= k){
                break;
            }
        }

        answer = kind;
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(6, new int[] {1,3,2,5,4,5,2,3}));
        System.out.println(Solution.solution(4, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(Solution.solution(2, new int[] {1, 1, 1, 1, 2, 2, 2, 3}));
    }
}