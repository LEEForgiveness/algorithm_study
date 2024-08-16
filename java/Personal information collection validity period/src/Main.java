import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> term = new HashMap<>();

        for(String t: terms){
            String[] temp = t.split(" ");
            term.put(temp[0], Integer.valueOf(temp[1]));
        }

        String[] splitedToday = today.split("\\.");

        int totalDays = Integer.valueOf(splitedToday[0]) * 28 * 12 + Integer.valueOf(splitedToday[1]) * 28 + Integer.valueOf(splitedToday[2]);

        for(int i = 0; i < privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            String[] temp2 = temp[0].split("\\.");
            int days = 0;
            if (Integer.valueOf(temp2[1]) + term.get(temp[1]) > 12){
                days = (Integer.valueOf(temp2[0]) + 1) * 28 * 12 + (Integer.valueOf(temp2[1]) + term.get(temp[1]) - 12) * 28 + Integer.valueOf(temp2[2]);
            } else {
                days = Integer.valueOf(temp2[0]) * 28 * 12 + Integer.valueOf(temp2[1]) * 28 + Integer.valueOf(temp2[2]) + term.get(temp[1]) * 28;
            }
            System.out.println(days);
            if(days <= totalDays){
                answer.add(i + 1);
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(
                "2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));

        System.out.println(Solution.solution(
                "2020.01.01",
                new String[]{"Z 3", "D 5"},
                new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}));

        System.out.println(Solution.solution(
                "2020.10.01",
                new String[]{"A 11"},
                new String[]{"2019.12.01 A", "2000.01.01 A"}));
    }
}