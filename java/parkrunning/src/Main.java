// 지나다니는 길 O, 장애물 X, S는 시작지점
class Solution {
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int w = park[0].length();
        int h = park.length;
        int x = 0;
        int y = 0;
        String[][] road = new String[h][w];

        for(int i = 0; i < h; i++){
            String[] row = park[i].split("");
            for (int j = 0; j < w; j++){
                road[i][j] = row[j];
                if(road[i][j].equals("S")){
                    y = i;
                    x = j;
                }
            }
        }

//        System.out.println(y);
//        System.out.println(x);
//        System.out.println(w);
//        System.out.println(h);

//        for(int i = 0; i < h; i++){
//            for(int j = 0; j < w; j++){
//                System.out.println("road[" + i + "]" + road[i][j]);
//            }
//        }

        for(String route: routes){
            boolean ob = false;
            String[] temp = route.split(" ");
            if(temp[0].equals("E") && (x + Integer.parseInt(temp[1])) < w){
                for(int i = x; i <= x + Integer.parseInt(temp[1]); i++){
                    if(road[y][i].equals("X")){
                        ob = true;
                        break;
                    }
                }
                if(!ob) {
                    x += Integer.parseInt(temp[1]);
                }
            }
            if(temp[0].equals("W") && (x - Integer.parseInt(temp[1])) >= 0){
                for(int i = x; i >= x - Integer.parseInt(temp[1]); i--){
//                    System.out.println(road[y][i]);
                    if(road[y][i].equals("X")){
                        ob = true;
                        break;
                    }
                }
                if(!ob) {
                    x -= Integer.parseInt(temp[1]);
                }
            }
            if(temp[0].equals("S") && (y + Integer.parseInt(temp[1])) < h){
                for(int i = y; i <= y + Integer.parseInt(temp[1]); i++){
//                    System.out.println(road[i][x]);
                    if(road[i][x].equals("X")){
                        ob = true;
                        break;
                    }
                }
                if(!ob) {
                    y += Integer.parseInt(temp[1]);
                }
            }
            if(temp[0].equals("N") && (y - Integer.parseInt(temp[1])) >= 0){
                for(int i = y; i >= y - Integer.parseInt(temp[1]); i--){
                    if(road[i][x].equals("X")){
                        ob = true;
                        break;
                    }
                }
                if(!ob) {
                    y -= Integer.parseInt(temp[1]);
                }
            }
//            System.out.println(y +" "+ x);
        }

        answer[0] = y;
        answer[1] = x;

//        System.out.println("y: " + answer[0] + ", x: " + answer[1]);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[] {"SOO","OOO","OOO"}, new String[] {"E 2","S 2","W 1"}));
        System.out.println(Solution.solution(new String[] {"SOO","OXX","OOO"}, new String[] {"E 2","S 2","W 1"}));
        System.out.println(Solution.solution(new String[] {"OSO","OOO","OXO","OOO"}, new String[] {"E 2","S 3","W 1"}));
    }
}