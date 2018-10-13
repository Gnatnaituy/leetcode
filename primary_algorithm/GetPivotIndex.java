class GetPivotIndex {
    public int pivotIndex(int[] nums) {
        int numsLenght = nums.length;
        int leftSummation = 0, rightSummation = 0;
        int index = 0;
        for (int i = numsLenght/2; i > 0; i--) {
        	for (int j = 0; j < numsLenght/2; j++) {
        		leftSummation += nums[j];
        	}
        	for (int k = numsLenght/2; k < numsLenght; k++) {
        		rightSummation += nums[k];
        	}
        	if (leftSummation == rightSummation) {
        		index = i;
        	} else if (leftSummation > rightSummation) {
        		leftSummation -= nums[i-1];
        		rightSummation += nums[i-1];
        		if (rightSummation == leftSummation) {
        		index = i;
        	}
        	} else if (leftSummation < rightSummation) {
        		leftSummation += nums[i];
        		rightSummation -= nums[i];
        		if (rightSummation == leftSummation) {
        		index = i;
        	}
        	}
        }
    return index;    
    }
}