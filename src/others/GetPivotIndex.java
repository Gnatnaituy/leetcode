package others;

class GetPivotIndex {
	public static void main(String[] args) {
		int[] testArray = {1, 7, 3, 6, 5, 6};
		int result = pivotIndex(testArray);
		System.out.println(result);
	}

    public static int pivotIndex(int[] nums) {
        int numsLength = nums.length;
        int leftSummation = 0, rightSummation = 0;
        int index = 0;
        int middleIndex = 1;

        if (numsLength < 1) {
        	index = -1;
        } else {
        	leftSummation = 0;
        	for (int i = 1; i < numsLength; i++) {
        		rightSummation += nums[i];
        	}

        	if (leftSummation == rightSummation) {
        		index = 0;
        	} else {
        		while (leftSummation != rightSummation && middleIndex < numsLength - 1) {
        			leftSummation += nums[middleIndex];
        			rightSummation -= nums[middleIndex + 1];
        			middleIndex += 1;
        		}
        		if (middleIndex < numsLength && leftSummation == rightSummation) {
        			index = middleIndex;
        		} else {
        			index = -1;
        		}
        	}
        }
        
        return index;

        
    	// for (int i = 0; i < middleIndex; i++) {
    	// 	leftSummation += nums[i];
    	// }
    	// for (int i = middleIndex + 1; i < numsLenght; i++) {
    	// 	rightSummation += nums[i];
    	// }

    	// if (leftSummation == rightSummation) {
    	// 	index = middleIndex;
    	// } else if (leftSummation > rightSummation) {
    	// 	while (leftSummation > rightSummation) {
    	// 		leftSummation -= nums[middleIndex - 1];
    	// 		rightSummation += nums[middleIndex];
    	// 		middleIndex -= 1;
    	// 	}
    	// 	index = (leftSummation == rightSummation) ? middleIndex : -1;
    	// } else {
    	// 	while (leftSummation < rightSummation) {
    	// 		leftSummation += nums[middleIndex];
    	// 		rightSummation -= nums[middleIndex + 1];
    	// 		middleIndex += 1;
    	// 	}
    	// 	index = (leftSummation == rightSummation) ? middleIndex : -1;
    	// }

    	// if (leftSummation == rightSummation) {
    	// 	index = middleIndex;
    	// } else {
    	// 	while (leftSummation != rightSummation) {
    	// 		if (leftSummation > rightSummation) {
    	// 			if (nums[middleIndex] >= 0) {
    	// 				leftSummation -= nums[middleIndex - 1];
    	// 				rightSummation += nums[middleIndex];
    	// 				middleIndex--;
    	// 			} else {
    	// 				leftSummation += nums[middleIndex];
    	// 				rightSummation -= nums[middleIndex + 1];
    	// 				middleIndex++;
    	// 			}
    	// 		} else (leftSummation < rightSummation) {
    	// 			if (nums[middleIndex] >= 0) {
    	// 				leftSummation += nums[middleIndex];
    	// 				rightSummation -= nums[middleIndex + 1];
    	// 				middleIndex++;
    	// 			} else {
    	// 				leftSummation -= nums[middleIndex - 1];
    	// 				rightSummation += nums[middleIndex];
    	// 				middleIndex--;
    	// 			}
    	// 		}
    	// 	}
    	// 	index = (leftSummation == rightSummation) ? middleIndex : -1;
    	// }
    }
}