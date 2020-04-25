public class LongestPalSub {

    public static void main(String[] args) {
        longestPalindrome("aaaa");
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if(length <= 1){
            return s;
        }
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[length][length];
        for(int j=1;j<length;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(j-i > right-left){
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right+1);

    }
}
