class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //sort each strings and group them together
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedStr = new String(strArr);
             if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
             }
             map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}