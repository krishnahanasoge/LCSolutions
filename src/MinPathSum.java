
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] input = {{1,3,1},{1,5,1},{4,2,1}};
        minPathSum(input);
    }
    public static int minPathSum(int[][] grid) {
        Map<Pair<Integer,Integer>,Integer> minSumMap = new HashMap<>();
        int rows = grid.length;
        int columns = grid[0].length;
        int rowSum = grid[rows-1][columns-1];
        int colSum = grid[rows-1][columns-1];
        minSumMap.put(new Pair(rows-1,columns-1),rowSum);
        for(int j=columns-2;j>=0;j--){
            rowSum += grid[rows-1][j];
            minSumMap.put(new Pair(rows-1,j),rowSum);
        }
        for(int j=rows-2;j>=0;j--){
            colSum += grid[j][columns-1];
            minSumMap.put(new Pair(j,columns-1),colSum);
        }
        return minSumFrom(grid,0,0,minSumMap);
    }

    public static int minSumFrom(int[][] grid, int row, int column, Map<Pair<Integer,Integer>,Integer> minSumMap){
        Pair<Integer, Integer> elemPair = new Pair(row, column);
        if(minSumMap.containsKey(elemPair)){
            return minSumMap.get(elemPair);
        }
        int minSum = grid[row][column] + Math.min(minSumFrom(grid,row,column+1,minSumMap),minSumFrom(grid,row+1,column,minSumMap));
        minSumMap.put(elemPair,minSum);
        return minSum;

    }
}
