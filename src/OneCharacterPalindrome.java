public class OneCharacterPalindrome {

    public static void main(String[] args) {
        validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu");
    }

    public static boolean validPalindrome(String s) {
        return validPalindrome(s,0,s.length()-1,0);
    }

    public static boolean validPalindrome(String s, int fromIndx, int toIndex, int charsRemoved) {
        int i = fromIndx;
        int j = toIndex;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            if(s.charAt(i)!=s.charAt(j) && charsRemoved >= 1){
                return false;
            }else if(s.charAt(i)!=s.charAt(j)){
                if(!validPalindrome(s,i+1,j,1)){
                    return validPalindrome(s,i,j-1,1);
                }else{
                    return true;
                }
            }
        }
        return true;
    }
}
