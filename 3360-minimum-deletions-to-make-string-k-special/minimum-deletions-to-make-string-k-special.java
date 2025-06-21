class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character, Integer> freMap = new HashMap<>();

        for(char c : word.toCharArray()) {
            if(freMap.containsKey(c)) {
                freMap.replace(c, freMap.get(c) + 1);
            } else {
                freMap.put(c, 1);
            }
        }

        int res = word.length();

        for(int i : freMap.values()) {
            int deleted = 0;
            for(int j : freMap.values()) {
                if(j > i + k) {
                    // delete excess
                    deleted += (j - (i + k));
                } else if(j < i) {
                    deleted += j;
                }
            }
            res = Math.min(res, deleted);
        }
        return res;
    }
}