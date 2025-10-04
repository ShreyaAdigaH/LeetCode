class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank = numBottles;
        int empty = numBottles;

        while(empty >= numExchange) {
            int currDrank = (empty / numExchange);
            drank += currDrank;
            empty = (empty % numExchange) + currDrank;
        }

        return drank;
    }
}