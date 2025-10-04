class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drank = numBottles;
        int empty = drank;

        while(empty >= numExchange) {
            drank += 1;
            empty = empty - (numExchange - 1);
            numExchange += 1;
        }
        return drank;
    }
}