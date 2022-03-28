/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let prod = 1;
    let zerocount = 0;
    let nonzerocount = 0;
    nums.forEach((num) => {
        if(num !== 0) {
            nonzerocount = nonzerocount + 1;
            prod = prod * num;
        } else {
            zerocount = zerocount + 1;
        }
    });
    //console.log(nonzerocount, zerocount);
    let newar = nums.map((num) => {
        if(nonzerocount === 1 && zerocount === 1) {
            //console.log("in1st", num===0)
            if(num === 0) {
                return prod;
            } else {
                return 0;
            }
        }
        if(zerocount > 1) {
            console.log("in2st")
            return 0
        }
        if(zerocount ===  1) {
            return num === 0 ? prod : 0
        }
        return prod/num
    });
    return newar;
}; 
