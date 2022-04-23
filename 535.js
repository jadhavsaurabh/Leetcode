/**
 * Encodes a URL to a shortened URL.
 *
 * @param {string} longUrl
 * @return {string}
 */

function makeid(length) {
    var result           = '';
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
   }
   return result;
}


let data = {}
var encode = function(longUrl) {
    let getID = makeid(5);
    data[getID] = longUrl;
   // console.log(data);
    return 'http://tinyurl.com/' + getID;
};

/**
 * Decodes a shortened URL to its original URL.
 *
 * @param {string} shortUrl
 * @return {string}
 */
var decode = function(shortUrl) {
    let splitted = shortUrl.split('/');
    //console.log(splitted[splitted.length - 1]);
    return data[splitted[splitted.length - 1]]
};

/**
 * Your functions will be called as such:
 * decode(encode(url));
 */
