public class ExcelColumn {

    public static void main(String args[]){
        titleToNumber("A");
    }

    public static int titleToNumber(String s) {
        int result = 0;
        int size = s.length();
        for(int i=0;i<size;i++){
            char val = s.charAt(i);
            int code = val - 'A'+1;
            result+=Math.pow(26,(size-1-i))*code;
        }
        return result;
    }
}
