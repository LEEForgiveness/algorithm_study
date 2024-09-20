class Solution {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        for(int i = 0; i < photo.length;  i++){
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++){
                for(int k = 0; k < name.length; k++){
                    if(photo[i][j].equals(name[k])){
                        sum += yearning[k];
                    }
                }
            }
            answer[i] = sum;
        }

        for(int i : answer){
            System.out.println(i);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[] {"may", "kein", "kain", "radi"},
                new int[] {5, 10, 1, 3}, new String[][] {{"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}));
    }
}