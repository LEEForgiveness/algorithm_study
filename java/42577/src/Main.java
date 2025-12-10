import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], i);
        }

        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[]{"119", "97674223", "1195524421"}));
    }
}