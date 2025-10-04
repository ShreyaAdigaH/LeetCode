class Solution {
    public int[] decrypt(int[] code, int k) {

        //idx = ((idx % n) + n) % n;
        //bruteforce
        /**** 
        int n = code.length;
        int[] res = new int[code.length];
        if(k == 0) {
            return res;
        }
        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                for (int j = 1; j <= -k; j++) { // k is negative in this case -k ==> k
                    sum += code[(((i - j) % n) + n) % n];
                }
            }
            res[i] = sum;
        }
        return res;
        */

        int start = 1;
        int end = k;
        int[] res = new int[code.length];
         int n = code.length;

        if(k < 0) {
            start = n - (-k);
            end = n - 1;
        }

        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += code[i];
        
        }

       // res[0] = sum;

        for(int i = 0; i < n; i++) {
            res[i] = sum;
            sum -= code[start % n];
            sum += code[(end + 1)% n];
            start++;
            end++;
        }
        return res;
    }
}