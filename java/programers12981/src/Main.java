import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Map<String, Integer> word = new HashMap<>();
        int index = 0;

        for(int i = 0; i < words.length; i++){
            word.put(words[i], word.getOrDefault(words[i], 0) + 1);

            if(i >= 1 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)){
                index = i;
                break;
            }

            if(word.get(words[i]) != 1){
                index = i;
                break;
            }
        }

        if(index != 0){
            if((index + 1) % n == 0){
                answer[0] = n;
                answer[1] = (index + 1) / n;
            }
            else {
                answer[0] = (index + 1) % n;
                answer[1] = (index + 1) / n + 1;
            }
        }
        else {
            answer[0] = 0;
            answer[1] = 0;
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(3,
                new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
        System.out.println(Solution.solution(5,
                new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}));
        System.out.println(Solution.solution(2,
                new String[] {"hello", "one", "even", "never", "now", "world", "draw"}));
    }
}