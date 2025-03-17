import java.math.BigInteger;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // //sort each strings and group them together
        // HashMap<String, List<String>> map = new HashMap<>();
        // for(String str : strs) {
        //     char[] strArr = str.toCharArray();
        //     Arrays.sort(strArr);
        //     String sortedStr = new String(strArr);
        //      if (!map.containsKey(sortedStr)) {
        //         map.put(sortedStr, new ArrayList<>());
        //      }
        //      map.get(sortedStr).add(str);
        // }
        // return new ArrayList<>(map.values());


        int[] primeNum = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 
        53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        HashMap<BigInteger, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] charArr = str.toCharArray();

                    BigInteger prod = BigInteger.ONE;

            for(char c : charArr) {
                prod = prod.multiply(BigInteger.valueOf(primeNum[c - 'a']));
            }

            if(!map.containsKey(prod)) {
                map.put(prod, new ArrayList<>());
            }
            map.get(prod).add(str);
        }
        return new ArrayList<>(map.values());
    }
}