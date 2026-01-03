class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for(String s : strs) {
            int[] freq = new int[26];
            
            for(char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);

            if(res.containsKey(key)) {
                res.get(key).add(s);
            } else {
                List<String> strList = new ArrayList<>();

                strList.add(s);
                res.put(key, strList);
            }
        }
          return new ArrayList<>(res.values());
    }
}