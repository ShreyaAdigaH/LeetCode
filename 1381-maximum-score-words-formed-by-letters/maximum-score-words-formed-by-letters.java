class Solution {
     public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] actualFrequency = new int[26];
        int[] freqCouldBeUsed = new int[26];

        for(char letter : letters) {
            freqCouldBeUsed[letter - 'a']++; //{letter - 'a'} scales down ascii values of lowercase alphabets to have values between 0 - 26 so that it could be indexed by array
        }

        int maxScore = 0;
        maxScore = returnScoreOfSubset(words, score, freqCouldBeUsed, actualFrequency, 0, 0, maxScore);
        return maxScore;
    }

    public int returnScoreOfSubset(String[] words, int[] score, int[] freqCouldBeUsed, int[] actualFrequency, int nextWordPosition, int tempScore, int maxScore) {

        for(int letter = 0; letter < 26; letter++) {
            if(actualFrequency[letter] > freqCouldBeUsed[letter]) {
                //in this case you should not use the previously calculated tempScore and return the previously calculated valid maxScore
                return maxScore;
            }
        }

        //if the above check passes then assign the maximum score calculated so far

        maxScore = Math.max(maxScore, tempScore);


        for(int word = nextWordPosition; word < words.length; word++) {
            //calculate freq of letters in each word
            for(char letter : words[word].toCharArray()) {
                actualFrequency[letter - 'a']++;
                tempScore += score[letter - 'a'];
            }

            maxScore = returnScoreOfSubset(words, score, freqCouldBeUsed, actualFrequency, word + 1, tempScore, maxScore);

            //after one recursion stack completes start backtracking to calculate other possible combination from given subset to check max score
            for(char letter : words[word].toCharArray()) {
                actualFrequency[letter - 'a']--;
                tempScore -= score[letter - 'a'];
            }

        }
        return maxScore;
    }
}