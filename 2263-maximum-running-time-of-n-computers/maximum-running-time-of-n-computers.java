class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        int bn = batteries.length;
        long extra = 0;
        int[] running = new int[n];

        for(int i = 0; i < (bn - n); i++) {
            extra += batteries[i];
        }

        int j = 0;
        for(int i = bn - n; i < bn; i++) {
            running[j++] = batteries[i];
        }

        for(int i = 0; i < n - 1; i++) {
            int diff = running[i + 1] - running[i];
            int required = (i + 1) * diff; // need the diff amount of charge for all previous batteries

            if(extra < required) {
                return running[i] + extra / (long) (i + 1);
            } 

            extra -= required;
        }

        return running[n - 1] + extra / n;
    }
}