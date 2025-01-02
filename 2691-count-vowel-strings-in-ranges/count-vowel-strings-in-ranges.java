class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
          int[] result = new int[queries.length];

        int[] vowelsCount = new int[words.length + 1];

        boolean[] vowelsFlag = new boolean[26];
        vowelsFlag[0] = true;
        vowelsFlag[4] = true;
        vowelsFlag[8] = true;
        vowelsFlag[14] = true;
        vowelsFlag[20] = true;
        if(vowelsFlag[words[0].charAt(0) - 'a'] && vowelsFlag[words[0].charAt(words[0].length() - 1) - 'a']) {
            vowelsCount[1] = 1;
        }
        for(int i = 1; i < words.length; i++) {
            String word = words[i];
            if(vowelsFlag[word.charAt(0) - 'a'] && vowelsFlag[word.charAt(word.length() - 1) - 'a']) {
                vowelsCount[i + 1] = vowelsCount[i] + 1;
            } else {
                vowelsCount[i + 1] = vowelsCount[i];
            }
        }

        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            result[i] = vowelsCount[end + 1] - vowelsCount[start];
        }
        return result;
    }
}