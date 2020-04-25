public class Backspace {
    public static boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '#' && i>0 && sb.length() > 0){
                sb.deleteCharAt(sb.length()-1);
            }else if(S.charAt(i) != '#' ){
                sb.append(S.charAt(i));
            }
        }
        for(int i=0;i<T.length();i++){
            if(T.charAt(i) == '#' && i>0 && tb.length() > 0){
                tb.deleteCharAt(tb.length()-1);
            }else if(T.charAt(i) != '#' ){
                tb.append(T.charAt(i));
            }
        }
        return sb.toString().equals(tb.toString());
    }

    public static void main(String[] args) {
        backspaceCompare("a##c","#a#c");
    }
}
