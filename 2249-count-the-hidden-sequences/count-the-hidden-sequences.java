class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // calculate prefix sum.// max and min values are required
        long max = 0;
        long min = 0;
        long currSum = 0;
        for(int num : differences) {
            currSum += num;
            max = Math.max(max, currSum);
            min = Math.min(min, currSum);
        }

        long lowerBound = lower - min;
        long upperBound = upper - max;

        long result = upperBound - lowerBound + 1;

        if(result > 0) {
            return (int) result;
        } 

        return 0;

    }
}