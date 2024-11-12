class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] answer = new int[queries.length];

        int[][] indexQuery = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            indexQuery[i][0] = queries[i];
            indexQuery[i][1] = i;
        }
        Arrays.sort(indexQuery, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        int max = 0;
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            while (j < items.length && items[j][0] <= indexQuery[i][0]) {
                max = Math.max(items[j][1], max);
                j++;

            }
            answer[indexQuery[i][1]] = max;
        }
        return answer;
    }
}