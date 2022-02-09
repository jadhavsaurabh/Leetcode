var maxProfit = function(prices) {
    let len = prices.length;
    let minPrice = 10001;
    let maxProf = 0;
    
    for(let i=0;i<len;i++) {
        minPrice = Math.min(minPrice, prices[i])
        maxProf = Math.max(maxProf, prices[i]-minPrice)
    }
    return maxProf
};
