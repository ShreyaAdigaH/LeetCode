class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
            HashMap<Integer, String> heightNamesMap = new HashMap<>();
        String[] descending = new String[heights.length];
        for(int name = 0; name < names.length; name++) {
            heightNamesMap.put(heights[name], names[name]);
        }

        Arrays.sort(heights);

        for(int height = 0; height <= heights.length / 2; height++) {

            descending[height] = heightNamesMap.get(heights[(heights.length - 1) - height]);
            descending[(heights.length - 1) - height] = heightNamesMap.get(heights[height]);
        }
        return descending;
    }
}