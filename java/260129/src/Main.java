import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(bfs(start, end));
        }
    }

    public static class Number {
        int value;
        String command;

        public Number(int value, String command) {
            this.value = value;
            this.command = command;
        }
    }

    static String bfs(int start, int end){
        boolean[] done = new boolean[10000];
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(start, ""));
        done[start] = true;
        String command = "";
        while(!queue.isEmpty()){
            Number cur = queue.poll();
            if (cur.value == end) {
                command = cur.command;
            }
            int now1 = (cur.value * 2) % 10000;
            int now2 = (cur.value - 1) < 0 ? 9999 : (cur.value - 1);
            int now3 = (cur.value % 1000) * 10 + cur.value / 1000;
            int now4 = (cur.value % 10) * 1000 + cur.value / 10;

            if (!done[now1]) {
                queue.add(new Number(now1, cur.command + "D"));
                done[now1] = true;
            }
            if (!done[now2]) {
                queue.add(new Number(now2, cur.command + "S"));
                done[now2] = true;
            }
            if (!done[now3]) {
                queue.add(new Number(now3, cur.command + "L"));
                done[now3] = true;
            }
            if (!done[now4]) {
                queue.add(new Number(now4, cur.command + "R"));
                done[now4] = true;
            }

        }
        return command;
    }
}
