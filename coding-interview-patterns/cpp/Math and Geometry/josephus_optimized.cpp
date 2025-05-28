int josephusOptimized(int n, int k) {
    int res = 0;
    for (int i = 2; i <= n; i++) {
        // res[i] = (res[i - 1] + k) % i;
        res = (res + k) % i;
    }
    return res;
}