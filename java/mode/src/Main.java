import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if (count.containsKey(array[i])){
                count.put(array[i],count.get(array[i]) + 1);
            }
            else {
                count.put(array[i], 1);
            }
        }

        int modeValue = 0;
        int counter = 0;
        for(Integer key: count.keySet()){
            if(modeValue < count.get(key)){
                modeValue = count.get(key);
                answer = key;
            }
        }

        for(Integer key: count.keySet()){
            if(modeValue == count.get(key)){
                counter++;
            }
        }

        if(counter >= 2){
            return -1;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {1, 2, 3, 3, 3, 4}));
        System.out.println(Solution.solution(new int[] {1, 1, 2, 2}));
        System.out.println(Solution.solution(new int[] {1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 6, 7, 8}));
        System.out.println(Solution.solution(new int[] {1, 2}));
        System.out.println(Solution.solution(new int[] {1, 1, 1, 2, 2}));
    }
}