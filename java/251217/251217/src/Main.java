import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        int[][] apartment = new int[15][15];
        for (int i = 0; i < 15; i++) {
            apartment[0][i] = i;
            apartment[i][0] = 0;
        }
        for (int j = 0; j < T; j++) {
            int floor = Integer.parseInt(bufferedReader.readLine());
            int unit = Integer.parseInt(bufferedReader.readLine());
            for (int i = 1; i <= floor; i++) {
                for (int k = 1; k <= unit; k++) {
                    apartment[i][k] = apartment[i - 1][k] + apartment[i][k - 1];
                }
            }
            System.out.println(apartment[floor][unit]);
        }
    }
}