class Solution {
    public int takeCharacters(String s, int k) {
         int lp = 0;
        int rp = 0;

        int[] charFreqMap = new int[3];
        // 0 -> a ; 1 -> b ; 2 -> c

        for(char c : s.toCharArray()) {
            charFreqMap[c - 'a']++;
        }

        if(charFreqMap[0] < k || charFreqMap[1] < k || charFreqMap[2] < k) {
            return -1;
        }


        // condition - freq of each letter outside the window must be >= k

        int min = Integer.MAX_VALUE;

        while(rp < s.length()) {
            charFreqMap[s.charAt(rp) - 'a']--;

            while(charFreqMap[0] < k || charFreqMap[1] < k || charFreqMap[2] < k) {
                charFreqMap[s.charAt(lp) - 'a']++;
                lp++;
            }
            min = Math.min(min, s.length() - (rp - lp + 1));
            rp++;
        }
        return min;
    }
}