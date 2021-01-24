public class Solution {
    public int maxProfit(int[] prices) {
        //prices 小于2 ，收益肯定为 0
        if (prices.length < 2) {
            return 0;
        }
        //表示第 0 天 持有现金的收益
        int cash = 0;
        //表示第 0 天 持有股票的收益
        int hold = -prices[0];

        //表示前一天两种情况的收益
        int preCash = cash;
        int preHold = hold;
        for (int i = 0;i < prices.length; i++) {
            //可能前一天持股，今天卖出，也可能前一天没有持股，两者最大值即为第 i 的持有现金的收益
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }
}
