class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int[] tempArr = new int[arr.length];
        int[] rankResult = new int[arr.length];
        HashMap<Integer, Integer> numRank = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }

        Arrays.sort(tempArr);
        int rank = 0;
        for(int i = 0; i < tempArr.length; i++) {
            int curr = tempArr[i];
            rank++;
            numRank.put(curr, rank);
            while(i + 1 < tempArr.length && tempArr[i + 1] == curr) {
                i++;
            }
        }


        for(int i = 0; i < arr.length; i++) {
            rankResult[i] = numRank.get(arr[i]);
        }
        return rankResult;  
    }
}