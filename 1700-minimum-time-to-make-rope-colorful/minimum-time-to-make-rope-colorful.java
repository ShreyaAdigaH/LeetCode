class Solution {
    public int minCost(String colors, int[] neededTime) {
        // use 2 pointers to keep track of adjecent consecutive colors 
        // remove thr char with min needed time

        int lp = 0;
        int minTime = 0;

        for(int rp = 1; rp < colors.length(); rp++) {
            if(colors.charAt(rp) == colors.charAt(lp)) {
                if(neededTime[lp] < neededTime[rp]) {
                    minTime += neededTime[lp];
                    lp = rp;
                } else {
                    minTime += neededTime[rp];
                }
            } else {
                lp = rp;
            }
        }
        return minTime;
    }
}