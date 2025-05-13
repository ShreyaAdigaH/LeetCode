class Solution {
    final int MOD = 1_000_000_007;
    
    public int lengthAfterTransformations(String s, int t) {
        long[] initFreq = new long[26];
        long count = 0;

        for(char c : s.toCharArray()) {
            initFreq[c - 'a']++;
        }

        for(int i = 1; i <= t; i++) {
            long[] newFreq = new long[26];

            for(int j = 0; j < 26; j++) {
                if(j == 25) {
                    newFreq[0] = (newFreq[0] + initFreq[25]) % MOD;
                    newFreq[1] = (newFreq[1] + initFreq[25]) % MOD;
                } else {
                    newFreq[j + 1] = (newFreq[j + 1] + initFreq[j]) % MOD;
                }
            }
            initFreq = newFreq;
        }

        for(int i = 0; i < 26; i++) {
            count = (count + initFreq[i]) % MOD;
        }

        return (int) count;
    }
}
