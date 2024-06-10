class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = new int[101];

        for (int index = 0; index < heights.length; index++) {
            expected[heights[index]]++;
        }

        int heightsIndex = 0;
        int differenceCount = 0;
        for (int expectedHeight = 0; heightsIndex < heights.length; expectedHeight++) {
            if (expected[expectedHeight] > 0) {
                int heightCount = 0;
                while (++heightCount <= expected[expectedHeight]) {
                    if (heights[heightsIndex++] != expectedHeight) {
                        differenceCount++;
                    }
                }
            }
        }
        return differenceCount;
    }
}