import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    public static void main(String[] args) {
        int r = 7;
        int c = 4;
        int d = 0;
        int[][] room_map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
    }

    static int rotateRobot(int direction){
        return (direction + 3) % 4;
    }

    static int goBackRobot(int direction){
        return (direction + 2) % 4;
    }

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int bfs(int[][] room_map, int startX, int startY, int direction){
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, direction});
        room_map[startY][startX] = 2;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int tempDirection = current[2];
            for (int i = 0; i < 4; i++) {
                tempDirection = rotateRobot(tempDirection);
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];
            }
        }
        return result;
    }
}
