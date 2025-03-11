class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];

        int l = 0;
        int res = 0;

        for(int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'a']++;

            while(freq[0] >= 1 && freq[1] >= 1 && freq[2] >= 1) {
                res += (s.length() - r);
                freq[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return res;
    }
}