import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> rank = new HashMap<>();

        for(int i = 0; i < players.length; i++){
            rank.put(players[i], i);
        }

        // Print the entire map
//        for (Map.Entry<String, Integer> entry : rank.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        for(int i = 0; i < callings.length; i++){
//            System.out.println("before");
//            System.out.println(players[rank.get(callings[i]) - 1]);
//            System.out.println(rank.get(players[rank.get(callings[i]) - 1]));
            rank.put(players[rank.get(callings[i]) - 1], rank.get(players[rank.get(callings[i]) - 1]) + 1);
//            System.out.println("after");
//            System.out.println(players[rank.get(callings[i]) - 1]);
//            System.out.println(rank.get(players[rank.get(callings[i]) - 1]));
            rank.put(callings[i], rank.get(callings[i]) - 1);
//            System.out.println(callings[i] + " : " + rank.get(callings[i]));

            String temp = players[rank.get(callings[i])];
            players[rank.get(callings[i])] = players[rank.get(callings[i]) + 1];
            players[rank.get(callings[i]) + 1] = temp;
        }

        // Print the entire map
//        for (Map.Entry<String, Integer> entry : rank.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        for (Map.Entry<String, Integer> entry : rank.entrySet()) {
            answer[entry.getValue()] = entry.getKey();
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[] {"mumu", "soe", "poe", "kai", "mine"},
                new String[] {"kai", "kai", "mine", "mine"}));
    }
}