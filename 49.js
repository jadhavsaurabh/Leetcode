/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let hash = {};
    for(let i=0;i<strs.length;i++) {
        const sorted = strs[i].split("").sort().join("")
        if(!hash[sorted]){
            hash[sorted] = [strs[i]]
        }else{
            hash[sorted].push(strs[i])
        }
    }
    return Object.values(hash);
};
