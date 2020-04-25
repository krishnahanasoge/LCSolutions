import java.util.HashMap;
import java.util.Map;

public class WordSearch {
    public static void main(String[] args) {
        char[][] input = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.print(exist(input, "AAB"));
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        if(word.length()>rows*columns){
            return false;
        }
        for(int row=0;row<rows;row++){
            for(int column=0;column<columns;column++){
                if(word.charAt(0)==board[row][column]){
                    char temp = board[row][column];
                    board[row][column]=' ';
                    if(dfs(board, word, 1, row, column)){
                        return true;
                    }
                    board[row][column]= temp;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int indexToFind, int row, int column){
        if(indexToFind>word.length()-1){
            return true;
        }
        int minRow = row>0 ? row-1 : row;
        int maxRow = row<board.length-1 ? row+1 : row;
        int minColumn = column>0 ? column-1 : column;
        int maxColumn = column<board[row].length-1 ? column+1 : column;
        for(int i=minRow;i<=maxRow;i++){
            if(board[i][column]==word.charAt(indexToFind)){
                char temp = board[i][column];
                board[i][column] = ' ';
                if(dfs(board,word,indexToFind + 1, i, column)){
                    return true;
                }
                board[i][column] = temp;
            }
        }
        for(int j=minColumn;j<=maxColumn;j++){
            if(board[row][j]==word.charAt(indexToFind)){
                char temp = board[row][j];
                board[row][j] = ' ';
                if(dfs(board,word,indexToFind + 1, row, j)){
                    return true;
                }
                board[row][j] = temp;
            }
        }
        return false;
    }
}
