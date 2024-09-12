import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> schedule = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toUpperCase();
        }

        if (cacheSize != 0) {
            for (String city : cities) {
                if (!schedule.contains(city)) {
                    if (schedule.size() < cacheSize) {
                        schedule.add(city);
                        answer += 5;
                    } else {
                        schedule.poll();
                        schedule.add(city);
                        answer += 5;
                    }
                } else {
                    schedule.remove(city);
                    schedule.add(city);
                    answer += 1;
                }
            }

            return answer;
        }
        else {
            for(int i = 0; i < cities.length; i++){
                answer +=5;
            }
            return answer;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(3,
                new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(Solution.solution(2,
                new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(Solution.solution(5,
                new String[] {"a", "b", "c", "b", "a"}));

    }
}