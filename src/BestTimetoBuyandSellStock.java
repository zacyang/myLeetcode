public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {

        int mxProfit=0;
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minVal = Math.min(prices[i], minVal);
            mxProfit = Math.max(prices[i] - minVal, mxProfit);
        }


        return mxProfit;

    }
}
