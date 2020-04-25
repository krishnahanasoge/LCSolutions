public class NumDecodings {
    public static int numDecodings(String s) {
        return numDecodings(s,0);
    }

    public static int numDecodings(String s, int index) {
        if(index > s.length()-1 || (index == s.length()-1 && s.charAt(index) != '0')){
            return 1;
        }
        if(s.charAt(index)=='0'){
            return 0;
        }

        char currentChar = s.charAt(index);
        char nextChar = s.charAt(index+1);
        if(currentChar == '1' || (currentChar== '2' && (nextChar == '1' || nextChar == '2' || nextChar == '3' || nextChar == '4' || nextChar == '5' || nextChar == '6'))){
            return numDecodings(s, index+1) + numDecodings(s, index+2);
        }else{
            return numDecodings(s, index+2);
        }

    }

    public static void main(String args[]){
        System.out.print(numDecodings("230"));
    }
}
