public class buysellstock {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println("max profit: " + sol.maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int p = 0, lp = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] < prices[lp]){
                lp = i;
            }else{
                p = Math.max(p, prices[i] - prices[lp]);
            }
        }
        return p;
    }
}