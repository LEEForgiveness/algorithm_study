import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] sanguen;
        String sanguenCards = bufferedReader.readLine();
        sanguen = Arrays.stream(sanguenCards.split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] search;
        String searchCards = bufferedReader.readLine();
        search = Arrays.stream(searchCards.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(search));
        Arrays.sort(sanguen);
        System.out.println(Arrays.toString(sanguen));
        for (int i = 0; i < M; i++) {
            stringBuilder.append(high(sanguen, search[i]) - low(sanguen, search[i])).append(" ");
        }
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int low(int[] cards, int key){
        int lo = 0;
        int hi = cards.length;
        while(lo < hi){
            System.out.println("hi: " + hi + " lo: " + lo);
            int middle = (lo + hi) / 2;
            System.out.println("middle: " + middle);
            if (key <= cards[middle]) {
                hi = middle;
            } else {
                lo = middle + 1;
            }
        }
        return lo;
    }

    static int high(int[] cards, int key){
        int lo = 0;
        int hi = cards.length;
        while(lo < hi){
            int middle = (lo + hi) / 2;
            if (key < cards[middle]) {
                hi = middle;
            } else {
                lo = middle + 1;
            }
        }
        return hi;
    }
}
