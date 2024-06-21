class Solution {
    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for(int num = left; num <= right; num++) {
            int num1 = num;
            int bitCount = 0;
            while(num1 > 0) {
                bitCount += (num1 & 1);
                num1 = num1 >> 1;
            }
            if(bitCount == 2 || bitCount == 3 || bitCount == 5 || bitCount == 7 || bitCount == 11 || bitCount == 13
               || bitCount == 17 || bitCount == 19) {

                result++;
            }
        }
        return result; 
    }
}