var sortByBits = function(arr) {
    const numOfBits = function(num) {
        const bits = num.toString(2).match(/1/g);
        return bits ? bits.length : 0;
    }
    
    return arr.sort((a, b) => numOfBits(a) - numOfBits(b) || a - b);
};
