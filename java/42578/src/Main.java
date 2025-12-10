import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesNumber = new HashMap<>();

        for(int i = 0; i < clothes.length; i++){
            clothesNumber.put(clothes[i][1], clothesNumber.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : clothesNumber.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : clothesNumber.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        return answer - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}