class UnionFind(size: Int) {
    private val parent = IntArray(size) { it }
    private val size = IntArray(size) { 1 }

    fun union(x: Int, y: Int): Boolean {
        var repX = find(x)
        var repY = find(y)
        if (repX != repY) {
            if (size[repX] > size[repY]) {
                parent[repY] = repX
                size[repX] += size[repY]
            } else {
                parent[repX] = repY
                size[repY] += size[repX]
            }
            // Return true if both groups were merged.
            return true
        }
        // Return false if the points belong to the same group.
        return false
    }

    fun find(x: Int): Int {
        if (x == parent[x]) {
            return x
        }
        parent[x] = find(parent[x])
        return parent[x]
    }
}

fun connectTheDots(points: List<List<Int>>): Int {
    val n = points.size
    // Create and populate a list of all possible edges.
    val edges = mutableListOf<Triple<Int, Int, Int>>()
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            // Manhattan distance.
            val cost =
                    (Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]))
            edges.add(Triple(cost, i, j))
        }
    }
    // Sort the edges by their cost in ascending order.
    edges.sortBy { it.first }
    val uf = UnionFind(n)
    var totalCost = 0
    var edgesAdded = 0
    // Use Kruskal's algorithm to create the MST and identify its minimum cost.
    for ((cost, p1, p2) in edges) {
        // If the points are not already connected (i.e. their representatives are
        // not the same), connect them, and add the cost to the total cost.
        if (uf.union(p1, p2)) {
            totalCost += cost
            edgesAdded++
            // If n - 1 edges have been added to the MST, the MST is complete.
            if (edgesAdded == n - 1) {
                return totalCost
            }
        }
    }
    return totalCost
}
