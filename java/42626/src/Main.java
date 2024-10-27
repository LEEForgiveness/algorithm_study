import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            heap.add(scoville[i]);
        }

        while(heap.peek() < K){
            if(heap.size() < 2){
                return -1;
            }
            int newFood = heap.poll() + heap.poll() * 2;
            heap.add(newFood);
            answer += 1;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] {1,2,3,9,10,12}, 7));
    }
}