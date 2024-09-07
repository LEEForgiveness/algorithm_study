import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        int n = data.length;
        int m = data[0].length;
        List<int[]> answer = new ArrayList<>();

        int extNumber = 0;
        int sortNumber = 0;
        String[] extRange = {"code", "date", "maximum", "remain"};

        for(int i = 0; i < extRange.length; i++){
            if(extRange[i].equals(ext)){
                extNumber = i;
            }
            if(extRange[i].equals(sort_by)){
                sortNumber = i;
            }
        }

        for(int i = 0; i < data.length; i++){
            if (data[i][extNumber] < val_ext){
                answer.add(data[i]);
            }
        }

        //람다 표현식에서 사용되는 변수는 사실상 final 변수로 해야지 됨.
        int finalSortNumber = sortNumber;
        answer.sort(((o1, o2) -> Integer.compare(o1[finalSortNumber], o2[finalSortNumber])));

//        for(int[] s : answer){
//            System.out.println(Arrays.toString(s));
//        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][] {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}},
                "date", 20300501, "remain"));
    }
}