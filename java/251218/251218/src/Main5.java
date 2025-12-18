import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] sanguen = new int[N];
        String sanguenCards = bufferedReader.readLine();
        sanguen = Arrays.stream(sanguenCards.split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] search = new int[M];
        String searchCards = bufferedReader.readLine();
        search = Arrays.stream(searchCards.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[M];
        Arrays.fill(result, 0);
        Arrays.sort(sanguen);
        int index = N / 2;
        for (int i = 0; i < M; i++) {
            result[i] = binarySearch(sanguen, search[i]);
        }
        for (int i = 0; i < M; i++) {
            stringBuilder.append(result[i]);
            stringBuilder.append(" ");
        }
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    static int binarySearch(int[] cards, int searchNumber){
        if (cards.length == 0) {
            return 0;
        }
        int middle = cards.length / 2;
        int result = 0;
        if(cards[middle] == searchNumber){
            result++;
            return result + binarySearch(Arrays.copyOfRange(cards, 0, middle), searchNumber) + binarySearch(Arrays.copyOfRange(cards, middle + 1, cards.length), searchNumber);
        } else if (cards[middle] <= searchNumber) {
            return binarySearch(Arrays.copyOfRange(cards, middle + 1, cards.length), searchNumber);
        } else {
            return binarySearch(Arrays.copyOfRange(cards, 0, middle), searchNumber);
        }
    }
}

//TODO: 수정필요
