package easy.ktwenty;

/**
 * 812 Largest Triangle Area
 */

public class LargestTriangleArea {
    
    public double largestTriangleArea(int[][] points) {
        double area = 0, x1, y1, x2, y2;
        
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = 0; j < points.length - 1; j++) {
                x1 = points[j][0] - points[i][0];
                y1 = points[j][1] - points[i][1];
                for (int k = j + 1; k < points.length; k++) {
                    x2 = points[k][0] - points[i][0];
                    y2 = points[k][1] - points[i][1];
                    area = Math.max(area, Math.abs(x1 * y2 - x2 * y1));
                }
            }
        }
        
        return area / 2;
    }
}
