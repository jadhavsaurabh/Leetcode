/**
 * @param {string} digits
 * @return {string[]}
 */
// 2=a,b,c
// 3=d,e,f
// r=""
// 1="a" "b"
// 2="ad" "ae" "af" "b"

/*
a
ad, 
*/
var letterCombinations = function(digits) {
    let res = [];
    let dictionary = {
        2: ["a", "b", "c"],
        3: ["d", "e", "f"],
        4: ["g", "h", "i"],
        5: ["j", "k", "l"],
        6: ["m", "n", "o"],
        7: ["p", "q", "r", "s"],
        8: ["t", "u", "v"],
        9: ["w", "x", "y", "z"]
    }
    
    if(digits == ""){
        return [];
    }
    function recursive(string, digits, depth) {
        if(depth === digits.length) {
            res.push(string);
        } else {
            for(let i=0;i<dictionary[digits[depth]].length;i++) {
                string = string.concat(dictionary[digits[depth]][i]);
                recursive(string, digits, depth+1);
                string = string.substring(0, string.length - 1);
            }
        }   
    }
    
    recursive("", digits, 0);
    return res;
};
