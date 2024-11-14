class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        /**
         * brute force
         * int max = 0;
         * for (int quantity : quantities) {
         * max = Math.max(max, quantity);
         * }
         * 
         * for(int x = 1; x <= max; x++) {
         * int storesReq = 0;
         * //calculate no of stores required for each quantity of product
         * for(int i = 0; i < quantities.length; i++) {
         * storesReq = storesReq + (quantities[i] + x - 1) / x;
         * }
         * if(storesReq <= n) {
         * return x;
         * }
         * }
         * return 0;
         */
        int max = 0;
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }

        int mid;
        int l = 1;
        int r = max;
        int min = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int storesReq = 0;
            // calculate no of stores required for each quantity of product
            for (int i = 0; i < quantities.length; i++) {
                storesReq = storesReq + (quantities[i] + mid - 1) / mid;
            }
            if (storesReq > n) {
                l = mid + 1;
            } else {
                min = mid;
                r = mid - 1;
            }
        }
        return min;
    }
}