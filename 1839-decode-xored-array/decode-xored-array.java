class Solution {
    public int[] decode(int[] encoded, int first) {
                int[] arr = new int[encoded.length + 1];
        arr[0] = first;

        // a ^ b = c ==> c ^ b = a
        //arr[i] ^ arr[i + 1] = encode[i] == > arr[i + 1] = encode[i] ^ arr[i] ==>arr[i] = encode[i - 1] ^ arr[i - 1]
        for(int index = 1; index < arr.length; index++) {
            arr[index] = encoded[index - 1] ^ arr[index - 1];
        }
        return arr;
    }
}