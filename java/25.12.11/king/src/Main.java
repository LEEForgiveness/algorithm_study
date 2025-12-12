import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<int[]> position = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            char[] input = st.nextToken().toCharArray();
            position.add(new int[]{(input[0] - 'A' + 1),Character.getNumericValue(input[1])});
        }

//        for (int i = 0; i < 2; i++) {
//            System.out.print("[");
//            for (int j = 0; j < 2; j++) {
//                System.out.print(position.get(i)[j]);
//                if(j == 1){
//                    break;
//                }
//                System.out.print(",");
//            }
//            System.out.println("]");
//        }

        Map<String, int[]> move = new HashMap<>();
        move.put("R",new int[]{1,0});
        move.put("L",new int[]{-1,0});
        move.put("B",new int[]{0,-1});
        move.put("T",new int[]{0,1});
        move.put("RT",new int[]{1,1});
        move.put("LT",new int[]{-1,1});
        move.put("RB",new int[]{1,-1});
        move.put("LB",new int[]{-1,-1});

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            moving(position,move.get(str));
        }
//        for (int i = 0; i < 2; i++) {
//            System.out.print("[");
//            for (int j = 0; j < 2; j++) {
//                System.out.print(position.get(i)[j]);
//                if(j == 1){
//                    break;
//                }
//                System.out.print(",");
//            }
//            System.out.println("]");
//        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            char col = (char) ('A' + position.get(i)[0] - 1);
            result.add(col + String.valueOf(position.get(i)[1]));
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(result.get(i));
        }
    }

    static List<int[]> moving(List<int[]> position, int[] move){
        position.get(0)[0] += move[0];
        position.get(0)[1] += move[1];
        if(Arrays.equals(position.get(0), position.get(1))){
            position.get(1)[0] += move[0];
            position.get(1)[1] += move[1];
            if(position.get(1)[0] == 0 || position.get(1)[1] == 0 || position.get(1)[0] > MAX || position.get(1)[1] > MAX){
                position.get(1)[0] -= move[0];
                position.get(1)[1] -= move[1];
                position.get(0)[0] -= move[0];
                position.get(0)[1] -= move[1];
            }
        }

        if(position.get(0)[0] == 0 || position.get(0)[1] == 0 || position.get(0)[0] > MAX || position.get(0)[1] > MAX){
            position.get(0)[0] -= move[0];
            position.get(0)[1] -= move[1];
        }
        return position;
    }
}