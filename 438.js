/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
//LeetCode: 438
function arrayequal(arr1, arr2) {
    let count = 0;
    arr1.forEach((data, i) => {
        if(data === arr2[i]) {
            count++;
        }
    });
    return count === 26;
}

var findAnagrams = function(s, p) {
    let parr = new Array(26).fill(0);
    let sarr = new Array(26).fill(0);
    let result = [];
    for(let i=0;i<p.length;i++) {
        parr[p.charCodeAt(i) - 97]++
    }
    for(let i=0;i<p.length;i++) {
        sarr[s.charCodeAt(i) - 97]++
    }
    
    for(let i=0;i<s.length-p.length+1;i++) {
        if(arrayequal(parr, sarr)) {
            result.push(i);
        }
        sarr[s.charCodeAt(i) - 97]--;
        sarr[s.charCodeAt(i+p.length) - 97]++;
    }
    return result;
};
