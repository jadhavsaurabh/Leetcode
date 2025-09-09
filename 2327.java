class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = (long)1e9 + 7;
        long[] dp = new long[n + 1]; // dp[i] = new people learning secret on day i
        dp[1] = 1;

        for (int day = 1; day <= n; day++) {
            if (dp[day] == 0) continue;
            // Spread the secret from day+delay ye inclusive hain to day+forget-1 ye exclusive
            
            for (int next = day + delay; next < day + forget && next <= n; next++) {
                dp[next] = (dp[next] + dp[day]) % mod;
            }
        }

        long ans = 0;
        // Count those who haven’t forgotten by day n
        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) ans = (ans + dp[day]) % mod;
        }

        return (int) ans;
    }
}
