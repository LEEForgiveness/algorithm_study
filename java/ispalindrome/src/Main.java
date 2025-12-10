public class Main {

    public static void main(String[] args) {

        System.out.println(isPalindrome("abcba"));
    }

    private static boolean isPalindrome(String string) {
        int end = string.length() - 1;
        int start = 0;
        while (start != end){
            if(string.charAt(start) != string.charAt(end)){
                return false;
            } else {
                start += 1;
                end -= 1;
            }
        }

        return true;
    }

}
