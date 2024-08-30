import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        long qsum1 = 0;
        long qsum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        for(int i = 0; i < queue1.length; i++){
            sum += queue1[i] + queue2[i];
            qsum1 += queue1[i];
            qsum2 += queue2[i];
        }

        if(qsum1 == qsum2){
            return 0;
        }

        if(sum % 2 == 1){
            return -1;
        }

        // 1, 2, 2, 3, 4, 5, 6, 7
        // 1, 1, 1, 1, 2, 2, 2, 10

        while (qsum1 != qsum2){
            if(qsum1 > qsum2){
                int movedValue = q1.poll();
                q2.add(movedValue);
                qsum1 -= movedValue;
                qsum2 += movedValue;
                answer++;
            }
            else {
                int movedValue = q2.poll();
                q1.add(movedValue);
                qsum1 += movedValue;
                qsum2 -= movedValue;
                answer++;
            }

            if((queue1.length + queue2.length) * 2 < answer){
                return -1;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {3, 2, 7 ,2}, new int[] {4, 6, 5, 1}));
        System.out.println(Solution.solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2}));
    }
}