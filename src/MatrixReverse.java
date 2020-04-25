public class MatrixReverse {

    public static int[][] flipAndInvertImage(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                A[i][j] = A[i][columns-1-j];
            }
        }
        return A;

    }

    public static void main(String args[]){
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        flipAndInvertImage(A);

    }
}
