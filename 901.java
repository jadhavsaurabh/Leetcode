class StockSpanner {

    Stack<int[]> stocks;
    public StockSpanner() {
        stocks = new Stack<>();
    }

    public int next(int price) {
        int span = 0;
        while(!stocks.empty()) {
            if(stocks.peek()[0] > price) {
                break;
            }
            span += stocks.pop()[1];
        }
        stocks.push(new int[]{price, span + 1});

        return span + 1;
    }
}
