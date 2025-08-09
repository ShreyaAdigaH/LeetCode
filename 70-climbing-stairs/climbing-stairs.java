class Solution {
    int[] map = new int[46];

    // public int climbStairs(int n) {
    //     // for nth step once you reach step (n - 1) and (n - 2) you can hop over
    //     // base case 0th step (ground level) and 1st step - 1 way to reach
    //     if (map[n] == 0) {
    //         if (n == 0 || n == 1) {
    //             map[n] = 1;
    //             return 1;
    //         }

    //     // int ways = climbStairs(n - 1) + climbStairs(n - 2);
    //         int ways = 0;
    //         for(int i = 1; i <= 2; i ++) {
    //             ways += climbStairs(n - i);
    //         }
    //         map[n] = ways;
    //         return ways;
    //     } else {
    //         return map[n];
    //     }
    // }

    public int climbStairs(int n) {
        // sliding window technique
        int[] map = new int[n + 1];
        map[0] = 1;
        map[1] = 1;
        int currSum = 1;
        int maxStep = 2;
        for(int i = 2; i < n + 1; i++) {

            int windowStart = i - maxStep;
            int windowEnd = i - 1;

            if(windowStart - 1 >= 0)
                currSum = currSum - map[windowStart - 1];

            currSum = currSum + map[windowEnd];
            map[i] = currSum;
        }
        return map[n];
    }
}