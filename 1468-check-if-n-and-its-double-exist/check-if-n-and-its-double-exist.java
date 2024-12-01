class Solution {
 public boolean checkIfExist(int[] arr) {
   HashMap<Integer, Integer> arrMap = new HashMap<>();
        int product, quotient;
        for (int index = 0; index < arr.length; index++) {

            product = arr[index] * 2;
            if (arrMap.containsValue(product) && !arrMap.containsKey(index)) {
                return true;
            }

            if (arr[index] % 2 == 0) {
                quotient = arr[index] / 2;
                if (arrMap.containsValue(quotient) && !arrMap.containsKey(index)) {
                    return true;
                }
            }
            arrMap.put(index, arr[index]);
        }
        return false;
    }
}