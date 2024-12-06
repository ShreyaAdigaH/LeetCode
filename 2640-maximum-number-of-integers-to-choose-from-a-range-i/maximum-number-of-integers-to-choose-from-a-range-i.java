class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
         boolean[] bannedArr = new boolean[10001];
        for(int num : banned) {
            bannedArr[num] = true;
        }

        int sum = 0;
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!bannedArr[i]) {
                sum += i;
                if(sum <= maxSum) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}