class Solution {
    public int heightChecker(int[] heights) {
         int[] expected = new int[101];

        for(int index = 0; index < heights.length; index++) {
            expected[heights[index]]++;
        }

        int heightsIndex = 0;
        int differenceCount = 0;
        for(int index = 0; heightsIndex < heights.length; index++) {
            if(expected[index] > 0) {
                int temp = 0;
                while(++temp <= expected[index]) {
                    if (heights[heightsIndex++] != index) {
                        differenceCount++;
                    }
                }
            }
        }
        return differenceCount;
    }
}