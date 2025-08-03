class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        String[][] arrMap = { { "0" }, { "1" }, { "a", "b", "c" }, { "d", "e", "f" },
                { "g", "h", "i" }, { "j", "k", "l" }, { "m", "n", "o" },
                { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };

        String[] comb = new String[digits.length()];

        List<String> res = new ArrayList<>();

        computeComb(0, digits, arrMap, comb, res);
        return res;

    }

    public void computeComb(int i, String digits, String[][] arrMap, String[] comb, List<String> res) {
        if (i == digits.length()) {
            res.add(String.join("", comb));
        } else {

            char curr = digits.charAt(i);
            String[] possibleMap = arrMap[curr - '0'];

            for (String c : possibleMap) {
                comb[i] = c;
                computeComb(i + 1, digits, arrMap, comb, res);
            }
        }
    }
}