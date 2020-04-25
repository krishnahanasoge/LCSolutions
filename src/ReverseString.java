public class ReverseString {

    public static void reverseString(char[] s) {
        for(int i=0;i<s.length;i++){
            char temp = s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    }

    public static void main(String args[]){
        char[] arr = "Hello".toCharArray();
        reverseString(arr);
    }
}
