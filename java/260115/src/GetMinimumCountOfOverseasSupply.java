import java.util.Comparator;
import java.util.PriorityQueue;

class GetMinimumCountOfOverseasSupply {

    public static int getMinimumCountOfOverseasSupply(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int lastIndex = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        while(stock < k){
            while(lastIndex < dates.length && dates[lastIndex] <= stock){
                maxHeap.add(supplies[lastIndex]);
                lastIndex++;
            }
            System.out.println(maxHeap.toString());
            answer++;
            int pop = maxHeap.poll();
            stock += pop;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("정답 = 2 / 현재 풀이 값 = " +
            getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
        System.out.println("정답 = 4 / 현재 풀이 값 = " +
            getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15, 20}, new int[]{20, 5, 10, 5}, 40));
        System.out.println("정답 = 1 / 현재 풀이 값 = " +
            getMinimumCountOfOverseasSupply(2, new int[]{1, 10}, new int[]{10, 100}, 11));
    }
}