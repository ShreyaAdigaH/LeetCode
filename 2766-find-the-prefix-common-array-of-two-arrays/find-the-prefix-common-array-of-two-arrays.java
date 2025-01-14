class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
         int[] freqArrA = new int[51];
        int[] freqArrB = new int[51];

        int[] res = new int[A.length];
        freqArrA[A[0]]++;
        freqArrB[B[0]]++;
        if(A[0] == B[0]) {
            res[0] = 1;
        }

        for(int i = 1; i < A.length; i++) {
            freqArrA[A[i]]++;
            freqArrB[B[i]]++;
            res[i] = res[i - 1];
            if(A[i] == B[i]) {
                res[i] += 1;
            } else {
                if (freqArrA[B[i]] > 0) {
                    freqArrA[B[i]]--;
                    res[i] += 1;
                }
                if (freqArrB[A[i]] > 0) {
                    freqArrB[A[i]]--;
                    res[i] += 1;
                }
            }
        }
        return res;
    }
}