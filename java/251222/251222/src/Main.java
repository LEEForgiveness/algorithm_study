// start = [0, 0] end = [8, 8]
// start = [0, 1] end = [8, 9]
// start = [1, 0] end = [9, 8]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<char[]> chess = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] list = bf.readLine().toCharArray();
            chess.add(list);
        }

        int total = 64;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int temp = 0;
                char start = chess.get(i)[j];
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if(chess.get(k)[l] != start){
                            temp++;
                        }
                        if(start == 'W'){
                            start = 'B';
                        } else {
                            start = 'W';
                        }
                    }
                    if(start == 'W'){
                        start = 'B';
                    } else {
                        start = 'W';
                    }

                }
                temp = Math.min(64 - temp, temp);

                total = Math.min(temp, total);
            }
        }
        System.out.println(total);
    }
}
