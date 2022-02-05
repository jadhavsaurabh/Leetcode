/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {
    nums= nums.sort((a,b) => a-b);
    let prev = nums[0];
    let max = 1;
    let count = 1;
    for(let i=1;i<nums.length;i++) {
        let next = nums[i];
        if((next - 1) === prev) {
            count++;
            if(count > max) {
                max = count;
            }
        } else {
            count = 1;
        }
        prev = next;
    }
    return max;
};
