import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        heap.add(jobs[0]);
        int totalTime = 0;
        int index = 1;
        int now = jobs[0][0];
        while(!heap.isEmpty()){
            int[] pop = heap.poll();
            if (pop[0] > now) {
                now = pop[0];
            }
            now += pop[1];
            while(index < jobs.length && jobs[index][0] <= now){
                heap.add(jobs[index]);
                index++;
            }
            if (index < jobs.length && heap.isEmpty()) {
                heap.add(jobs[index]);
                index++;
            }
            totalTime += now - pop[0];
        }
        answer = totalTime / jobs.length;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {3, 5}}));
        System.out.println(solution(new int[][] {{7, 8}, {3, 5}, {9, 6}}));
        System.out.println(solution(new int[][] {{0, 10}, {4, 10}, {5, 11}, {15, 2}}));
        System.out.println(solution(new int[][] {{5, 10}, {5, 3}, {5, 5}}));
        System.out.println(solution(new int[][] {{1, 4}, {7, 9}, {1000, 3}}));
    }
}
