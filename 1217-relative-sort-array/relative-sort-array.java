class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr1FreqMap = new int[1001];
        int[] result = new int[arr1.length];
        for(int num : arr1) {
            arr1FreqMap[num]++;
        }

        int resultIndex = 0;
        for(int num : arr2) {
            if(arr1FreqMap[num] != 0) {
                int count = 0;
                while(++count <= arr1FreqMap[num]) {
                    result[resultIndex++] = num;
                }
                arr1FreqMap[num] = 0;
            }
        }

        for(int index = 0; index <= 1000; index++) {
            if(arr1FreqMap[index] != 0) {
                int count = 0;
                while(++count <= arr1FreqMap[index]) {
                    result[resultIndex++] = index;
                }
            }
        }
        return result;
    }
}