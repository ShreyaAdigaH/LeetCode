class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if(s2.length() < s1.length())
            return false;

        int s1Len = s1.length();
        int[] s1FreqMap = new int[26];
        int[] s2FreqMap = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1FreqMap[s1.charAt(i) - 'a']++;
            s2FreqMap[s2.charAt(i) - 'a']++;
        }

        int matchedChars = 0;
        for(int i = 0; i < 26; i++) {
            if(s1FreqMap[i] == s2FreqMap[i]) {
                matchedChars++;
            }
        }


        int left = 0;
        for(int right = s1Len; right < s2.length(); right++) {
            if(matchedChars == 26)
                return true;

            int index = s2.charAt(right) - 'a';
            s2FreqMap[index]++;

            if(s1FreqMap[index] == s2FreqMap[index])
                matchedChars++;
            else if (s1FreqMap[index] + 1 == s2FreqMap[index])
                matchedChars--;

            index = s2.charAt(left) - 'a';
            s2FreqMap[index]--;

            if(s1FreqMap[index] == s2FreqMap[index])
                matchedChars++;
            else if (s1FreqMap[index] - 1 == s2FreqMap[index])
                matchedChars--;

            left++;
        }
        return matchedChars == 26;
    }
}