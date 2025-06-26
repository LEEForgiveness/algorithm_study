public class Main {
    public static void main(String[] args) {
        System.out.println("정답 = 728 현재 풀이 값 = " + result(new int[] {0,3,5,6,1,2,4}));
        System.out.println("정답 = 8820 현재 풀이 값 =" + result(new int[] {3,2,1,5,9,7,4}));
        System.out.println("정답 = 270 현재 풀이 값 =" + result(new int[] {1,1,1,3,3,2,5}));
    }

    public static int result(int[] array){
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if(sum + array[i] > sum * array[i]){
                sum += array[i];
            }
            else {
                sum *= array[i];
            }
        }
        return sum;
    }
}