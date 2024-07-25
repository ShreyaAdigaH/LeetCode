class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
         int sum = 0;
        for(int length = 1; length <= arr.length; length = length + 2) {
            for(int index = 0; index + length <= arr.length; index++) {
                int subArrLen = 1;
                int subArrIndex = index;
                while(subArrLen <= length) {
                    sum += arr[subArrIndex];
                    subArrLen++;
                    subArrIndex++;
                }
            }
        }
        return sum;
    }
}