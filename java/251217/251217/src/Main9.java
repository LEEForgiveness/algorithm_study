import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] origin = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(origin);
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] target = new int[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] found = new int[M];
        for (int i = 0; i < M; i++) {
            boolean find = false;
            for (int j = 0; j < N; j++) {
                if(target[i] == origin[j]){
                    find = true;
                    break;
                }
            }
            if(find){
                found[i] = 1;
            } else {
                found[i] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v: found){
            sb.append(v).append('\n');
        }
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
