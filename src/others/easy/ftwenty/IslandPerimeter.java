package others.easy.ftwenty;

/**
 * 463 Island Perimeter
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 */

public class IslandPerimeter {

    private static int islandPerimeter(int[][] grid) {

        // 168ms surpass 9.86% users......
//        int count = 0, total = 0;
//
//        int[][] newGrid = new int[grid.length + 1][grid[0].length + 1];
//
//        for (int i = 0; i < grid.length; i++) {
//            System.arraycopy(grid[i], 0, newGrid[i], 0, grid[0].length);
//            newGrid[i][grid[0].length] = 0;
//        }
//        for (int i = 0; i < newGrid[0].length; i++)
//            newGrid[grid.length][i] = 0;
//
//
//        for (int i = 0; i < newGrid.length; i++) {
//            for (int j = 0; j < newGrid[0].length; j++) {
//                if (newGrid[i][j] == 1) {
//                    total++;
//                    if (newGrid[i][j + 1] == 1)
//                        count += 2;
//                    if (newGrid[i + 1][j] == 1)
//                        count += 2;
//                }
//            }
//        }
//
//        return total * 4 - count;

        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count += 4;
                    // Use a judgement to solve the OutOfBound problem
                    if(i - 1 >= 0 && grid[i - 1][j] == 1){
                        count -= 2;
                    }
                    if(j - 1 >= 0 && grid[i][j - 1] == 1){
                        count -= 2;
                    }
                }

            }
        }

        return count;
    }
}
