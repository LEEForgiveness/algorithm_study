import java.util.*;

class GetCountOfDepartmentsCleanedByRobotVacuum {
    private static int currentR = 7;
    private static int currentC = 4;
    private static int currentD = 0;
    private static int[][] currentRoomMap = {
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

    // 북   동  남 서
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static int getLeftDirection(int currentDirection){
        return (currentDirection + 3) % 4;
    }

    public static int getGoBack(int currentDirection){
        return (currentDirection + 2) % 4;
    }

    public static int getCountOfDepartmentsCleanedByRobotVacuum(int r, int c, int d, int[][] roomMap) {
        int countOfDepartmentsCleaned = 1;
        int n = roomMap.length;
        int m = roomMap[0].length;
        roomMap[r][c] = 2;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c, d});
        while(!queue.isEmpty()){
            int[] rcd = queue.poll();
            int tempDirection = rcd[2];

            for (int i = 0; i < 4; i++) {
                tempDirection = getLeftDirection(tempDirection);
                int newR = rcd[0] + dr[tempDirection];
                int newC = rcd[1] + dc[tempDirection];

                if (0 <= newR && newR < n && 0 <= newC && newC < m && roomMap[newR][newC] == 0){
                    queue.add(new int[] {newR, newC, tempDirection});
                    roomMap[newR][newC] = 2;
                    countOfDepartmentsCleaned++;
                    break;
                } else if (i == 3){
                    tempDirection = getGoBack(rcd[2]);
                    newR = rcd[0] + dr[tempDirection];
                    newC = rcd[1] + dc[tempDirection];
                    if (0 <= newR && newR < n && 0 <= newC && newC < m && roomMap[newR][newC] != 1){
                        queue.add(new int[] {newR, newC, rcd[2]});
                    } else {
                        return countOfDepartmentsCleaned;
                    }
                }
            }
        }

        return countOfDepartmentsCleaned;
    }

    public static void main(String[] args) {
        // 57 가 출력되어야 합니다!
        System.out.println(getCountOfDepartmentsCleanedByRobotVacuum(currentR, currentC, currentD, currentRoomMap));
    }
}