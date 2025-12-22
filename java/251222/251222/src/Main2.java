import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] cards = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cards);
        int M = Integer.parseInt(bf.readLine());
        int[] searchCards = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < M; i++) {
            sb.append(solve(cards, searchCards[i])).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static int solve(int[] cards, int searchNumber){
        return high(cards, searchNumber) - low(cards, searchNumber);
    }

    static int low(int[] cards, int searchNumber){
        int lo = 0;
        int hi = cards.length;

        while(lo < hi){
            int middle = (lo + hi) / 2;
            if(cards[middle] < searchNumber){
                lo = middle + 1;
            } else {
                hi = middle;
            }
        }

        return lo;
    }

    static int high(int[] cards, int searchNumber){
        int lo = 0;
        int hi = cards.length;

        while(lo < hi){
            int middle = (lo + hi) / 2;
            if(cards[middle] <= searchNumber){
                lo = middle + 1;
            } else {
                hi = middle;
            }
        }

        return hi;
    }
}
