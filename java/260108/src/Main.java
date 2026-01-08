import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
        System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }

    static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++){
            queue.add(new int[] {i, priorities[i]});
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            boolean isMax = true;
            for(int i = 0; i < queue.size(); i++){
                int[] target = queue.poll();
                queue.add(target);
                if(cur[1] < target[1]){
                    isMax = false;
                }
            }if(!isMax){
                queue.add(cur);
            } else {
                answer++;
                if(cur[0] == location){
                    return answer;
                }
            }
        }
        return answer;
    }
}

