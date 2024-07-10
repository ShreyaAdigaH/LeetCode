class Solution {
    public int minOperations(String[] logs) {
        int level = 0;
        for (String dir : logs) {
            if (dir.equals("../")) {
                if (level > 0) {
                    level -= 1;
                }
            } else if (!dir.equals("./")) {
                level += 1;
            }
        }
        return level;
    }
}