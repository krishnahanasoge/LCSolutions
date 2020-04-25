public class Flood {

    public static void main(String[] args) {
        int[][] input = {{0,0,0},{0,1,1}};
        floodFill(input, 1,1,1);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int pixelColor = image[sr][sc];
        image[sr][sc] = newColor;
        if(sr>0 && image[sr-1][sc] == pixelColor){
            floodFill(image, sr-1, sc, newColor);
        }
        if(sr<image.length-1 && image[sr+1][sc] == pixelColor){
            floodFill(image, sr+1, sc, newColor);
        }
        if(sc>0 && image[sr][sc-1] == pixelColor){
            floodFill(image, sr, sc-1, newColor);
        }
        if(sc<image[0].length-1 && image[sr][sc+1] == pixelColor){
            floodFill(image, sr, sc+1, newColor);
        }
        return image;
    }
}
