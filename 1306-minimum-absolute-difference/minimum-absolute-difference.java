class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        
        // find min diff

        for(int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            minDiff = Math.min(minDiff, diff);
        }


        for(int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i] - arr[i - 1]) == minDiff) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return ans;



    }
}