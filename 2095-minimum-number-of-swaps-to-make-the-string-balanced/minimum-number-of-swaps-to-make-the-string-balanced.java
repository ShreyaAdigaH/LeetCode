class Solution {
    public int minSwaps(String s) {
 int lp = 0;
        int rp = s.length() - 1;
        int bp = 0;
        int swapCount = 0;
        while(lp < rp) {
            if(s.charAt(lp) == '[') {
                bp++;
            } else {
                bp--;
            }

            if(bp < 0) {
                while (s.charAt(rp) != '[') {
                    rp--;
                }
                swapCount++;
                bp = 1;
                rp--;
            }
            lp++;
        }
        return swapCount;
    }
}