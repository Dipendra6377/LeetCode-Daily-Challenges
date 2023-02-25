class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=Integer.MAX_VALUE;
        int max=0;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<maxprofit){
                maxprofit=prices[i];
            }
            max=Math.max(max,prices[i]-maxprofit);
        }
        return max;
    }
}