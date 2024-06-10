class Solution {
    public int[] countBits(int n) {
         if(n == 0) {
            return new int[] {0};
        }
        int[] bitCount = new int[n + 1];

        bitCount[0] = 0;
        bitCount[1] = 1;

        for(int num = 2; num <= n; num++) {
            bitCount[num] = bitCount[num / 2] + (num & 1);
        }
        return bitCount;
    }
      // when you right shift a number 1 time you are reducing its value by 2.
    // also when you right shift a number you just remove the least significant bit and all other bits remains the same
    // so for counting numbers of 1s in a number you can count number of 1s in number/2 and to check whats the bit that
    // got removed during shift operation perform & operation on the number to read its least significant bit
}