class Solution {
    public String makeFancyString(String s) {
      StringBuilder res = new StringBuilder();
        char curr = s.charAt(0);
        int len = 1;
        res.append(curr);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != curr) {
                res.append(s.charAt(i));
                len = 1;
            } else {
                len++;
                if(len < 3) {
                    res.append(s.charAt(i));
                }
            }
            curr = s.charAt(i);
        }
        return res.toString();  
    }
}