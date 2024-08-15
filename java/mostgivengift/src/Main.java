import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public static int solution(String[] friends, String[] gifts) {
		int answer = 0;
		Map<String, Map<String, Integer>> degree = new HashMap<>();
		Map<String, Integer> score = new HashMap<>();
		Map<String, Integer> nextMonthGift = new HashMap<>();

		for(String friend: friends){
			degree.put(friend, new HashMap<>());
			score.put(friend, 0);
			nextMonthGift.put(friend, 0);
		}

		for(int i = 0; i < gifts.length; i++){
			String[] a = gifts[i].split(" ");

			degree.get(a[0]).put(a[1], degree.get(a[0]).getOrDefault(a[1], 0) + 1);
			score.put(a[0], score.get(a[0]) + 1);
			score.put(a[1], score.get(a[1]) - 1);
		}

//		for (Map.Entry<String, Integer> entry : score.entrySet()) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}

		for(String giver: friends){
			for(String receiver: friends){
				if(!giver.equals(receiver)){
					int giverAmount = degree.get(giver).getOrDefault(receiver, 0);
					int receiverAmount = degree.get(receiver).getOrDefault(giver, 0);

					if(giverAmount > receiverAmount) {
						nextMonthGift.put(giver, nextMonthGift.getOrDefault(giver, 0) + 1);
					}

					if (giverAmount == receiverAmount){
						if(score.get(giver) > score.get(receiver)){
							nextMonthGift.put(giver, nextMonthGift.getOrDefault(giver,0) + 1);
						}
					}
				}
			}
		}

		answer = Collections.max(nextMonthGift.values());

		return answer;
	}
}

public class Main {
	public static void main(String[] args) {
		System.out.println(Solution.solution(new String[] {"muzi", "ryan", "frodo", "neo"},
			new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
		System.out.println(Solution.solution(new String[] {"joy", "brad", "alessandro", "conan", "david"},
			new String[] {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}));
		System.out.println(Solution.solution(new String[] {"a", "b", "c"},
			new String[] {"a b", "b a", "c a", "a c", "a c", "c a"}));
	}
}