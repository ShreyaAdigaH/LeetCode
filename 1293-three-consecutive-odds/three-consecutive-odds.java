class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
          boolean oddNumberFound = false;
        int count = 0;
        for(int index = 0; index <= arr.length - 1; index++) {
            if(arr[index] % 2 != 0) {
                if(oddNumberFound) {
                    count++;
                    if(count == 3) {
                        return true;
                    }
                } else {
                    oddNumberFound = true;
                    count = 1;
                }
            }  else {
                oddNumberFound = false;
                count = 0;
            }
        }
        return false;
    }
}