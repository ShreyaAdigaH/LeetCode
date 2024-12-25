class Solution {
    public List<List<Integer>> generate(int numRows) {
          List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());
        res.getFirst().add(1);

        for(int row = 1; row < numRows; row++) {
            res.add(new ArrayList<>());
            res.get(row).add(1);
            for(int col = 1; col < row; col++) {
                res.get(row).add(res.get(row - 1).get(col - 1) + res.get(row - 1).get(col));
            }
            res.get(row).add(1);
        }
        return res;
    }
}