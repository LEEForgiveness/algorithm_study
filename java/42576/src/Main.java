import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < participant.length; i++){
            if(!map.containsKey(participant[i])){
                map.put(participant[i], 1);
            }
            else {
                map.put(participant[i], map.get(participant[i]) + 1);
            }
        }

        for(int i = 0; i < completion.length; i++){
            if(map.containsKey(completion[i])){
                map.put(completion[i], map.get(completion[i]) - 1);
            }
        }

        for(String v: map.keySet()){
            if(map.get(v) != 0){
                answer.append(v);
            }
        }

        return answer.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
    }
}