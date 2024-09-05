class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        String[] arr1map = new String[n];
        String[] arr2map = new String[n];
        String[] totalMap = new String[n];

        // 시간 초과남
        for(int i = 0; i < n; i++){
            String temp = "";
            while (arr1[i] != 1){
                temp = String.valueOf(arr1[i] % 2) + temp;
                arr1[i] /= 2;
            }
            temp = '1' + temp;
            while(temp.length() != n){
                temp = '0' + temp;
            }
            arr1map[i] = temp;
            System.out.println(arr1map[i]);
        }

        System.out.println();

        for(int i = 0; i < n; i++){
            String temp = "";
            while (arr2[i] != 1){
                temp = String.valueOf(arr2[i] % 2) + temp;
                arr2[i] /= 2;
            }
            temp = '1' + temp;
            while(temp.length() != n){
                temp = '0' + temp;
            }
            arr2map[i] = temp;
            System.out.println(arr2map[i]);
        }

        //제출한 방법
        for(int i = 0; i < n; i++){
            String temp = "";
            String b1 = Integer.toBinaryString(arr1[i]);
//            System.out.println(b1);
            String b2 = Integer.toBinaryString(arr2[i]);
//            System.out.println(b2);
            while(b1.length() != n){
                b1 = "0" + b1;
            }
            while(b2.length() != n){
                b2 = "0" + b2;
            }
            for(int j = 0; j < n; j++){
                if(b1.charAt(j) == '1' || b2.charAt(j) == '1'){
                    temp += "#";
                }
                else {
                    temp += " ";
                }
            }

            totalMap[i] = temp;
            System.out.println(totalMap[i]);
        }

        //시간초과
        for(int i = 0; i < n; i++){
            String temp = "";
            for(int j = 0; j < n; j++){
                if(arr1map[i].charAt(j) == '1' || arr2map[i].charAt(j) == '1'){
                    temp += "#";
                }
                else {
                    temp += " ";
                }
            }

            totalMap[i] = temp;
            System.out.println(totalMap[i]);
        }

        answer = totalMap;
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28}));
    }
}