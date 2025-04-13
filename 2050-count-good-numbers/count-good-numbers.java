class Solution {
    final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n - evenCount;

        long count = (calculatePower(5, evenCount) * calculatePower(4, oddCount)) % MOD;
        return (int) count;
    }

    public long calculatePower(long x, long n) {
        long res = 1;
        while(n > 0) {
            if(n % 2 == 1) {
                res = (res * x) % MOD;
            }
            n = n / 2;
            x = (x * x) % MOD;
        }
        return res;
    }
}