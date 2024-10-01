class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCounts = new int[k];

        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) {
                remainder += k;  
            }
            remainderCounts[remainder]++;
        }

        for (int r = 1; r < k; r++) {
            if (remainderCounts[r] != remainderCounts[k - r]) {
                return false;
            }
        }

        
        return remainderCounts[0] % 2 == 0;
    }
}