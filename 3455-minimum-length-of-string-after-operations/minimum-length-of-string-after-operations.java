class Solution {
    public int minimumLength(String s) {
        int[] charFreq = new int[26];

        for(int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a']++;
        }

        int length = s.length();
        for(int i = 0; i < 26; i++) {
            if(charFreq[i] >= 3) {
                if(charFreq[i] % 2 == 0) {
                    length -= (charFreq[i] - 2);
                } else {
                    length -= (charFreq[i] - 1);
                }
            }
        }
        return length;
    }
}