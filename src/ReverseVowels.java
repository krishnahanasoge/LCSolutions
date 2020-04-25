public class ReverseVowels {
    public static void main(String[] args) {
        reverseVowels(" ");
    }

    public static String reverseVowels(String s) {
        String vowels = "AEIOUaeiou";
        int len = s.length();
        char[] stringArr = new char[len];
        int i = 0;
        int j = len-1;
        for(int k=0;k<len;k++){
            stringArr[k] = s.charAt(k);
        }
        while(true){
            while(i<=len-1 && vowels.indexOf(stringArr[i]) == -1){
                i++;
            }
            while(j>=0 && vowels.indexOf(stringArr[j]) == -1){
                j--;
            }
            if(i<j){
                char temp = stringArr[i];
                stringArr[i] = stringArr[j];
                stringArr[j] = temp;
            }else{
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for(char c : stringArr){
            result.append(c);
        }
        return result.toString();

    }
}
