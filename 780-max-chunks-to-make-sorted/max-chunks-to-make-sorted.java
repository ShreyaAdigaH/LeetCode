class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int max = -1;

        for(int i = 0; i < arr.length; i++) {
           if(arr[i] > max) {
               max = arr[i];
           }
           if(i == max) {
               chunks++;
               max = -1;
           }
        }
        return chunks;
    }
}