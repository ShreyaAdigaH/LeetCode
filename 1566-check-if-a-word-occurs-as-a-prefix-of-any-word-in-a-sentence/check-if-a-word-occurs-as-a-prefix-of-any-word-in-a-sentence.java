class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ind = -1;
        int wordCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            boolean letterMatched = false;
            int searchIdx = 1;
            wordCount = wordCount + 1;

            if (sentence.charAt(i++) == searchWord.charAt(0)) {
                letterMatched = true;
                ind = wordCount;
                if(searchWord.length() == 1) {
                    return ind;
                }
            }
            while (i < sentence.length() && sentence.charAt(i) != ' ') {
                // to check match
                if (letterMatched) {
                    if (!(sentence.charAt(i) == searchWord.charAt(searchIdx++))) {
                        letterMatched = false;
                        ind = -1;
                    } else if (searchIdx == searchWord.length()) {
                        return ind;
                    }

                }
                i++;
            }

        }
        return -1;
    }
}