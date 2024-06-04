class Solution {
    public int longestPalindrome(String s) {
int[] freq = new int[60];
        int sLength = s.length();
        for(int index = 0; index < sLength; index++) {
            freq[s.charAt(index) - 'A']++;
        }

        int maxOddLength = 0;
        int palindromeLength = 0;
        int oddNumbersCount = 0;
        int oddLetterTotal = 0;
        for(int letter = 0; letter < 60; letter++) {
            if(freq[letter] % 2 == 0) {
                palindromeLength += freq[letter];
            } else {
                oddNumbersCount++;
                oddLetterTotal += freq[letter];
            }
        }

        if(oddNumbersCount > 1) {
            oddLetterTotal = (oddLetterTotal - (oddNumbersCount - 1));
        }

        return palindromeLength + oddLetterTotal;
    }
}