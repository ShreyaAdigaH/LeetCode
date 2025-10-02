class Solution {
    public String longestCommonPrefix(String[] strs) {
      // horizontal scanning

      String currPrefix = strs[0];

      for(int i = 1; i < strs.length; i++) {
        String curr = strs[i];
        int j = 0;
        //update prefix
        while(j < curr.length() && j < currPrefix.length() && currPrefix.charAt(j) == curr.charAt(j)) {
            j++;
        }
        currPrefix = currPrefix.substring(0, j);
      }

      return currPrefix;
    }
}