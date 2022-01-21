package classify.slidingwindow;

import tools.ParseArray;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
        if (fruits.length < 3) {
            return fruits.length;
        }

        int[][] baskets = new int[][]{{-1, -1}, {-1, -1}};
        int max = 0, left = 0, right = 0, rightType;
        while (right < fruits.length) {
            rightType = fruits[right];
            if (baskets[0][0] == -1) {
                baskets[0][0] = rightType;
                baskets[0][1]++;
                right++;
            } else if (rightType == baskets[0][0]) {
                baskets[0][1]++;
                right++;
            } else if (baskets[1][0] == -1) {
                baskets[1][0] = rightType;
                baskets[1][1]++;
                right++;
            } else if (rightType == baskets[1][0]) {
                baskets[1][1]++;
                right++;
            } else {
                if (fruits[left] == baskets[0][0]) {
                    baskets[0][1]--;
                    if (baskets[0][1] == -1) {
                        baskets[0][0] = -1;
                    }
                } else {
                    baskets[1][1]--;
                    if (baskets[1][1] == -1) {
                        baskets[1][0] = -1;
                    }
                }
                left++;
            }
            max = Math.max(max, right - left);
            System.out.println("left: " + left + " right: " + right + " max: " + max);
        }

        return max;
    }

    public static void main(String[] args) {
        totalFruit(ParseArray.parseArray("[1,2,1,1,1,1,1,2,2,2,1,3,3,3,4,4,4]"));
    }
}
