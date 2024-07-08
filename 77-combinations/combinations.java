class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(n, 1, k, combination, combinations);
        return combinations;
    }

    public static void backtrack(int n, int count, int k, List<Integer> combination, List<List<Integer>> combinations) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        for (int num = count; num <= n; num++) {
            combination.add(num);
            System.out.println(combination);
            backtrack(n, num + 1, k, combination, combinations);
            combination.removeLast();
        }
    }
}