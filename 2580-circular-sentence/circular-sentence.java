class Solution {
    public boolean isCircularSentence(String sentence) {
         if(sentence.charAt(0) != sentence.charAt(sentence.length() - 1))
            return false;

        for(int i = 0; i < sentence.length() - 1; i++) {
            if(sentence.charAt(i + 1) == ' ') {
                if(sentence.charAt(i + 2) != sentence.charAt(i))
                    return false;
            }
        }
        return true;
    }
}