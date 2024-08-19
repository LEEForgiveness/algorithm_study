import java.util.*;

class Solution {
    public static List<Integer> solution(String[] id_list, String[] report, int k) {
        List<Integer> answer = new ArrayList<>();
        List<String> bannedUser = new ArrayList<>();
        HashSet<String>reportSet = new HashSet<>(Arrays.asList(report));
        Map<String, List<String>> userReport = new LinkedHashMap<>();
        Map<String, Integer> reported = new HashMap<>();

        Arrays.stream(id_list).forEach(id -> {
            userReport.put(id,new ArrayList<>());
        });

        reportSet.stream()
                .map(s -> s.split(" "))
                .forEach(temp -> {
                    userReport.computeIfAbsent(temp[0], key -> new ArrayList<>()).add(temp[1]);
                    reported.put(temp[1], reported.getOrDefault(temp[1], 0) + 1);
                    if (reported.get(temp[1]) >= k) {
                        bannedUser.add(temp[1]);
                    }
                });

        System.out.println("userReport: " + userReport);
        System.out.println("bannedUser: " + bannedUser);

        for(Map.Entry<String, List<String>> entry : userReport.entrySet()) {
            int result = 0;
            for(String user : userReport.get(entry.getKey())){
                if (bannedUser.contains(user)){
                    result++;
                }
            }
            answer.add(result);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(
                new String[] {"muzi", "frodo", "apeach", "neo"},
                new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                2));

        System.out.println(Solution.solution(
                new String[] {"con", "ryan"},
                new String[] {"ryan con", "ryan con", "ryan con", "ryan con"},
                3));
    }
}