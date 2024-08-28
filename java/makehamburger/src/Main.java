import java.util.ArrayList;
import java.util.List;

// ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
// 빵 – 야채 – 고기 - 빵 = 햄버거
class Solution {
    public static int solution(int[] ingredient) {
        int answer = 0;
        int [] completeHamburger = {1 ,2, 3, 1};
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < ingredient.length; i++){
            temp.add(ingredient[i]);
            if(temp.size() >= completeHamburger.length && temp.get(temp.size() - (completeHamburger.length)) == 1
                    && temp.get(temp.size() - (completeHamburger.length - 1)) == 2
                    && temp.get(temp.size() - (completeHamburger.length - 2)) == 3
                    && temp.get(temp.size() - (completeHamburger.length - 3)) == 1){
                answer++;
                for(int j = 0; j < completeHamburger.length; j++){
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }
}