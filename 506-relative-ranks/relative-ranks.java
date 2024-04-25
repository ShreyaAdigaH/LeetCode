class Solution {
    public String[] findRelativeRanks(int[] score) {
                PriorityQueue<Integer> scores = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, String> rank = new HashMap<>();
        String[] result = new String[score.length];
        for(int idx = 0; idx < score.length; idx++) {
            scores.add(score[idx]);
        }

        for(int idx = 0; idx < score.length; idx++) {
            if(idx == 0)
                rank.put(scores.poll(), "Gold Medal");
            else if(idx == 1)
                rank.put(scores.poll(), "Silver Medal");
            else if(idx == 2)
                rank.put(scores.poll(), "Bronze Medal");
            else
                rank.put(scores.poll(), Integer.toString(idx + 1));
        }

        for(int idx = 0; idx < score.length; idx++) {
            result[idx] = rank.get(score[idx]);
         }
        return result;
    }
    
}