class Solution {
    public int trap(int[] height) {
        int area = 0;
        int[] maxLeftHeight = new int[height.length];
        int[] maxRightHeight = new int[height.length];

        int[] minHeight = new int[height.length];

        

        for(int i = 1; i < height.length; i++) {
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], height[i - 1]);
        }

        for(int i = height.length - 2; i > 0; i--) {
            maxRightHeight[i] = Math.max(maxRightHeight[i + 1], height[i + 1]);
        }


        for(int i = 1; i < height.length; i++) {
            minHeight[i] = Math.min(maxLeftHeight[i], maxRightHeight[i]);

            if(minHeight[i] > height[i]) {
             area += (minHeight[i] - height[i]);
            }
        }

        return area;
    }
}