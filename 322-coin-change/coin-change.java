class Solution {
    public int coinChange(int[] coins, int amount) {
       int[] noCoin = new int[amount + 1];
        Arrays.fill(noCoin, amount + 1);
        noCoin[0] = 0;

        for(int amt = 1; amt <= amount; amt++) {
            for(int coin : coins) {
                if(amt >= coin) {
                    noCoin[amt] = Math.min(noCoin[amt], 1 + noCoin[amt - coin]);
                }
            }
        }
        return noCoin[amount] == amount + 1 ? -1: noCoin[amount];  
    }
}