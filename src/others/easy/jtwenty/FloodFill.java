package others.easy.jtwenty;

/**
 * 733 Flood Fill
 */

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int temp = image[sr][sc];
        image[sr][sc] = newColor;
        if(sr-1>=0              &&image[sr-1][sc]==temp) floodFill(image,sr-1,sc,newColor);
        if(sc-1>=0              &&image[sr][sc-1]==temp) floodFill(image,sr,sc-1,newColor);
        if(sr+1<image.length    &&image[sr+1][sc]==temp) floodFill(image,sr+1,sc,newColor);
        if(sc+1<image[0].length &&image[sr][sc+1]==temp) floodFill(image,sr,sc+1,newColor);
        return image;
    }
}