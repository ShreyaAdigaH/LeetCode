class Solution {
    public int maxArea(int[] height) {
        /*
        int area = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int width = (j - i);
                int length = Math.min(height[i], height[j]);
        
                area = Math.max(area, (width * length));
            }
        }
        return area;
        */

        int area = 0;

        int lp = 0;
        int rp = height.length - 1;

        while (lp < rp) {
            int minHeight = Math.min(height[rp], height[lp]);
            int width = (rp - lp);
            area = Math.max(area, (width * minHeight));

            if(height[rp] <= height[lp]) {
                rp--;
            } else {
                lp++;
            }

        }
        return area;
    }
}