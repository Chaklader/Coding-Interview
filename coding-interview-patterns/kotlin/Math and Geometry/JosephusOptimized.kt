fun josephusOptimized(n: Int, k: Int): Int {
    var res = 0
    for (i in 2..n) {
        // res[i] = (res[i - 1] + k) % i.
        res = (res + k) % i
    }
    return res
}
