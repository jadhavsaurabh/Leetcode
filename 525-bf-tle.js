/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
    let max = 0
    for (let i = 0; i < nums.length; i++) {
        let one = 0;
        let zero = 0;

        for(let j=i;j< nums.length;j++) {
            if(nums[j] === 1) {
                one++;
            } else {
                zero++;
            }
            if(one === zero && (one + zero) > max) {
                max = one+zero;
            }
        }
    }
    return max;
};
