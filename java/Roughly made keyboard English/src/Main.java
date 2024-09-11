import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> alpabet = new HashMap<>();

        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                Character key = keymap[i].charAt(j);
                if(!alpabet.containsKey(key) || alpabet.get(key) > j + 1){
                    alpabet.put(keymap[i].charAt(j), j + 1);
                }
            }
        }

        // Map 출력
        for (Map.Entry<Character, Integer> entry : alpabet.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        for(int i = 0; i < targets.length; i++){
            for(int j = 0; j < targets[i].length(); j++){
                Character t = targets[i].charAt(j);
                if(!alpabet.containsKey(t) || answer[i] == -1){
                    answer[i] = -1;
                }
                else {
                    answer[i] += alpabet.get(t);
                }
            }
        }

        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD","AABB"}));
        System.out.println(Solution.solution(new String[] {"AA"}, new String[] {"B"}));
        System.out.println(Solution.solution(new String[] {"ABCDE"}, new String[] {"FGHIJ"}));
    }
}