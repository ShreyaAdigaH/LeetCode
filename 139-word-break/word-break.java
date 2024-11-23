class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
          boolean[] dpIdx = new boolean[s.length() + 1];
        dpIdx[s.length()] = true;

        for(int i = s.length() - 1; i >= 0; i--) {
            for(String word : wordDict) {
                if(i + word.length() <= s.length()) {
                    if(s.substring(i, i + word.length()).equals(word)) {
                        dpIdx[i] = dpIdx[i + word.length()];
                    }
                    if(dpIdx[i]){
                        break;
                    }
                }
            }
        }
        return dpIdx[0];
    }
}