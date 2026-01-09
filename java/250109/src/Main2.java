import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 1;
        List<Integer> houses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && visited[i][j] == 0){
                    houses.add(dfs(map, visited, i, j, count));
                    count++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println(count - 1);
        Collections.sort(houses);
        for (int i = 0; i < houses.size(); i++) {
            System.out.println(houses.get(i));
        }
    }

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static int dfs(int[][] map, int[][] visited, int i, int j, int count){
        int house = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {i, j});
        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            house++;
            visited[cur[0]][cur[1]] = 1;
            map[cur[0]][cur[1]] = count;
            for (int k = 0; k < 4; k++) {
                int newY = cur[0] + dy[k];
                int newX = cur[1] + dx[k];
                if (0 <= newX && newX < map[0].length && 0 <= newY && newY < map.length && map[newY][newX] == 1 && visited[newY][newX] == 0) {
                    stack.push(new int[] {newY, newX});
                    visited[newY][newX] = 1;
                }
            }
        }
        return house;
    }
}
