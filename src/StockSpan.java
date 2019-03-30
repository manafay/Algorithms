public class StockSpan {

    // worst case solution
    public int[] calculateStockSpan(int[] prices) {
        int[] result = new int[prices.length];
        if (prices.length > 0) {
            result[0] = 1;
        }
        for (int i = 1; i < prices.length; ++i) {
            result[i] = 1;
            if ( prices[i] > prices[i - 1]) {
                for (int j = i - 1; j > 0; --j) {
                    if ( prices[i] > prices[j]) {
                        result[i] += 1;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(result[i]);
        }

        return result;
    }



    public static void main(String[] args) {

        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        StockSpan test =  new StockSpan();
        test.calculateStockSpan(arr);
    }
}
