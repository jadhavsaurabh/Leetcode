/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function(c) {
    let res = 0;
    [...c].forEach((l) => {
        res *= 26;
        res += l.charCodeAt() - 64
    })
    
    return res
};
