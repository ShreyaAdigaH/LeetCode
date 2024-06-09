class Solution {
    int[] stairs;
    public int climbStairs(int n) {
        /**
       stairs = new int[n + 1];
        // Number of ways to reach nth step = Number of ways to reach (n-1)th step + Number of ways to reach (n-2)th step
        // because you can reach come to nth step either from n-1th step or (n-2)th step
        return calculateSteps(n); 
    }

    public int calculateSteps(int n) {
        if(stairs[n] == 0) {
            if (n == 1)
                return 1;

            if (n == 2)
                return 2;

            stairs[n] = calculateSteps(n - 1) + calculateSteps(n - 2);

        }
        return stairs[n];
        **/

         if(n == 1 || n == 0) 
            return 1;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int stair = 3; stair <= n; stair++) {
            dp[stair] = dp[stair - 1] + dp[stair - 2];
        }
        return dp[n];
    }
}