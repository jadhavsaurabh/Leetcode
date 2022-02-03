/**
O(n)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let start = -1;
    let end = -1;
    
    let countobj = {}
    
    for(let i=0;i<nums.length;i++) {
        if(!countobj[nums[i]]) {
            countobj[nums[i]] = 1;
        } else {
            countobj[nums[i]]++;
        }
    }
    for(let i=0;i<nums.length;i++) {
        if(nums[i] ==target) {
            start = i;
            end = i + countobj[nums[i]] - 1
            break;
        }
    }
    return [start, end];
};

/**
O(logn)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let start = -1;
    let end = -1;
    
    let l = 0;
    let r = nums.length - 1;
    
    while(l<=r) {
        let mid = Math.floor((l+r)/2);
        if(nums[mid] === target) {
            while(l <= mid) {
                if(nums[l] === target) {
                    start = l
                    break;
                }
                l++;
            }
            while(r >= mid) {
                if(nums[r] === target) {
                    end = r
                    break;
                }
                r--;
            }
            break;
        } else if(nums[mid] > target) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }

    return [start, end];
};
