/**
 * @param {number} n
 * @return {number[]}
 */
var countBits = function(n) {
    let arr = [0,1,1];
    let res = [];
    for(let i=0;i<=n;i++) {
        if(arr[i] !== undefined) {
            res.push(arr[i]);
        } else {
            if(i%2 === 0) {
                res.push(res[Math.floor(i/2)]);
            } else {
                res.push(res[i-1] + 1);
            }
        }
    }
    return res;
};
