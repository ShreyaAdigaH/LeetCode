class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 1;
        int count = 1;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] == prices[i - 1] - 1) {
                count++;
            } else {
                count = 1;
            }

            res += count;
        }

        return res;
    }
}