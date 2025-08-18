class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // for every possible combination of string s2 and s1 upto index i and j check if that resulting string is possible as string till index i + j in the 
        if (s1.length() + s2.length() < s3.length() || s1.length() + s2.length() > s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        boolean res = isPossible(0, 0, s1, s2, s3, dp);
        return res;
    }

    public boolean isPossible(int i, int j, String s1, String s2, String s3, Boolean[][] dp) {
        int k = i + j;
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (k == s3.length()) {
            return true;
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (isPossible(i + 1, j, s1, s2, s3, dp)) {
                return dp[i][j] = true;
            }
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (isPossible(i, j + 1, s1, s2, s3, dp)) {
                return dp[i][j] = true;
            }
        }

        return dp[i][j] = false;

    }
}