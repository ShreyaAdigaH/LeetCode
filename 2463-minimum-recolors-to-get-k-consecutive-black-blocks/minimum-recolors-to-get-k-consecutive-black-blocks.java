class Solution {
    public int minimumRecolors(String blocks, int k) {
        // window size = k
        // how to start a window traversal????


        int windowSize = 0;
        int left = 0;
        int replace = blocks.length();
        int whiteCount = 0;
        for(int i = 0; i < blocks.length(); i++) {
            windowSize++;
            if(blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        

            if(windowSize == k) {
                replace = Math.min(replace, whiteCount);
                if(blocks.charAt(left) == 'W') {
                    whiteCount--;
                }
                left++; 
                windowSize--;
            }
        }
        return replace;
    }
}