import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] airFreshUp;
    static int[] airFreshDown;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[r + 1][c + 1];
        int[][] dustMap = new int[r + 1][c + 1];
        airFreshUp = new int[2];
        airFreshDown = new int[2];

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= c; j++) {
                int dust = Integer.parseInt(st.nextToken());
                if (dust == -1) {
                    if (airFreshUp[0] == 0) {
                        airFreshUp = new int[] {i, j};
                    } else {
                        airFreshDown = new int[] {i, j};
                    }

                }
                map[i][j] = dust;
            }
        }
        System.out.println(getRemainDust(map, dustMap, r, c, t));
    }
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int getRemainDust(int[][] map, int[][] dustMap, int r, int c, int t){
        int remainDust = 0;
        int currentTime = 0;
        while(currentTime != t){
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    if (map[i][j] != -1 && map[i][j] != 0) {
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            int nextR = i + dr[k];
                            int nextC = j + dc[k];
                            if (0 < nextC && nextC <= c && 0 < nextR && nextR <= r && map[nextR][nextC] != -1) {
                                count++;
                                dustMap[nextR][nextC] += map[i][j] / 5;
                            }
                        }
                        map[i][j] -= (map[i][j] / 5) * count;
                    }
                }
            }

            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    map[i][j] += dustMap[i][j];
                }
            }

//            for (int i = 1; i <= r; i++) {
//                for (int j = 1; j <= c; j++) {
//                    System.out.print(map[i][j]);
//                    System.out.print(" ");
//                }
//                System.out.println();
//            }

            rotateAir(map, r, c);
//            System.out.println("-----------------");
//            for (int i = 1; i <= r; i++) {
//                for (int j = 1; j <= c; j++) {
//                    System.out.print(map[i][j]);
//                    System.out.print(" ");
//                }
//                System.out.println();
//            }
//            System.out.println("-----------------");
            currentTime++;
            for (int i = 1; i <= r; i++) {
                Arrays.fill(dustMap[i], 0);
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                remainDust += map[i][j];
            }
        }
        remainDust += 2;

        return remainDust;
    }

    static void rotateAir(int[][] map, int r, int c){
        for (int i = airFreshUp[0] - 1; i > 1; i--) {
            map[i][1] = map[i - 1][1];
        }

        for (int i = 1; i < c; i++) {
            map[1][i] = map[1][i + 1];
        }

        for (int i = 1; i < airFreshUp[0]; i++) {
            map[i][c] = map[i + 1][c];
        }

        for (int i = c; i > 1; i--) {
            map[airFreshUp[0]][i] = map[airFreshUp[0]][i - 1];
        }

        map[airFreshUp[0]][2] = 0;

        for (int i = airFreshDown[0] + 1; i < r; i++) {
            map[i][1] = map[i + 1][1];
        }

        for (int i = 1; i < c; i++) {
            map[r][i] = map[r][i + 1];
        }

        for (int i = r; i > airFreshDown[0]; i--) {
            map[i][c] = map[i - 1][c];
        }

        for (int i = c; i > 2; i--) {
            map[airFreshDown[0]][i] = map[airFreshDown[0]][i - 1];
        }

        map[airFreshDown[0]][2] = 0;
    }
}
