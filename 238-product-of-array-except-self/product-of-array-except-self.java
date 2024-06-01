class Solution {
  public int[] productExceptSelf(int[] array) {
        int[] prefixProduct = new int[array.length];
        int[] suffixProduct = new int[array.length];
        int[] result = new int[array.length];

        prefixProduct[0] = 1;
        for (int index = 1; index < array.length; index++) {
            prefixProduct[index] = prefixProduct[index - 1] * array[index - 1];
        }

        suffixProduct[array.length - 1] = 1;
        for (int index = array.length - 2; index >= 0; index--) {
            suffixProduct[index] = suffixProduct[index + 1] * array[index + 1];
        }

        for (int index = 0; index < array.length; index++) {
            result[index] = suffixProduct[index] * prefixProduct[index];
        }
        return result;
    }
}