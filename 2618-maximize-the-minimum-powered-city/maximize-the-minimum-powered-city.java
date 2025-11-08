class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] diff = new long[n + 1];  // Use long for safe arithmetic

        // Step 1: Build the difference array (each station affects [i - r, i + r])
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n, i + r + 1); // note: n (not n - 1), to mark the end boundary
            diff[left] += stations[i];
            diff[right] -= stations[i];
        }

        // Step 2: Binary search on the answer
        long lo = Arrays.stream(stations).min().getAsInt();
        long hi = Arrays.stream(stations).asLongStream().sum() + k;
        long res = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (isPossible(mid, diff, r, k)) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    private boolean isPossible(long target, long[] diffArr, int r, long available) {
        int n = diffArr.length - 1;
        long[] diff = diffArr.clone();
        long sum = 0;
        long remaining = available;

        for (int i = 0; i < n; i++) {
            sum += diff[i]; // current city’s total power
            if (sum < target) {
                long add = target - sum; // how much we need to fix this city
                if (remaining < add) return false; // not enough stations left
                remaining -= add;
                sum += add;

                // subtract the influence after the station’s range ends
                int end = Math.min(n, i + 2 * r + 1);
                diff[end] -= add;
            }
        }
        return true;
    }
}
