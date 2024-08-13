import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
    public static String solution(String[] survey, int[] choices) {
        Map<Character, Integer> result = new HashMap<>();
        String answer = "";
        StringBuilder mbti = new StringBuilder();
        IntStream.range(0, survey.length).forEach(i -> {
            String s = survey[i];
            int c = choices[i];

            if (c > 4) {
                char ch = s.charAt(1);
                result.put(ch, result.getOrDefault(ch, 0) + c - 4);
            } else if(c < 4) {
                char ch = s.charAt(0);
                result.put(ch, result.getOrDefault(ch, 0) + 4 - c);
            }
        });

        result.forEach((key, value) -> System.out.println(key + " " + value));
        char[][] comparisonGroup = {{'R','T'}, {'C', 'F'}, {'J', 'M'},{'A', 'N'}};
        IntStream.range(0, 4).forEach(i -> {
            if (result.getOrDefault(comparisonGroup[i][0], 0) >= result.getOrDefault(comparisonGroup[i][1], 0)){
                mbti.append(comparisonGroup[i][0]);
            } else {
                mbti.append(comparisonGroup[i][1]);
            }
        });

        answer = mbti.toString();

        return answer;
    }


}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }
}