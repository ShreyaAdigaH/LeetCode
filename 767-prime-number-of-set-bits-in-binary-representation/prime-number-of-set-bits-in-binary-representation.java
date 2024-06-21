class Solution {
    public int countPrimeSetBits(int left, int right) {
       final int[] primeFlags = new int[20];
        primeFlags[2] = 1; primeFlags[3] = 1; primeFlags[5] = 1; primeFlags[7] = 1;
        primeFlags[11] = 1; primeFlags[13] = 1; primeFlags[17] = 1; primeFlags[19] = 1;
        int result = 0;
        for(int num = left; num <= right; num++) {
            int num1 = num;
            int bitCount = 0;
            while(num1 > 0) {
                bitCount += (num1 & 1);
                num1 = num1 >> 1;
            }
            result += primeFlags[bitCount];
        }
        return result;
    }
}