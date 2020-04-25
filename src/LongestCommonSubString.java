public class LongestCommonSubString {

    public static String longestCommonSubString(String s1, String s2){
        StringBuilder sub = new StringBuilder();
        String longestSubString = "";
        for(int i=0;i<s1.length();i++){
            sub.append(s1.charAt(i));
            if(!s2.contains(sub.toString())){
               sub = new StringBuilder();
            }else{
                if(longestSubString.length()<sub.length()) {
                    longestSubString = sub.toString();
                }
            }
        }
        return longestSubString;
    }

    public static void main(String args[]){
        longestCommonSubString("abc","testabsrc");
    }
}
