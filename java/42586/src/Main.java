import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            queue.add((int)Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        System.out.println(queue);

        int last = 0;
        while (!queue.isEmpty()){
            if(answer.isEmpty()){
                answer.add(1);
                last = queue.poll();
            }
            else {
                int current = queue.poll();
                if(last >= current){
                    answer.set(answer.size() - 1, answer.get(answer.size() - 1) + 1);
                }
                else {
                    answer.add(1);
                    last = current;
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5}));
        System.out.println(Solution.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1}));
    }
}