class UnionFind(size: Int) {

    private val parent = IntArray(size) { it }
    private val size = IntArray(size) { 1 }

    // With comment
    fun union(x: Int, y: Int) {
        val repX = find(x)
        val repY = find(y)
        if (repX != repY) {
            // If 'repX' represents a larger community, connect
            // 'repY 's community to it.
            if (size[repX] > size[repY]) {
                parent[repY] = repX
                size[repX] += size[repY]
            } else {
                // Otherwise, connect 'repX's community to 'repY'.
                parent[repX] = repY
                size[repY] += size[repX]
            }
        }
    }

    fun find(x: Int): Int {
        if (x == parent[x]) {
            return x
        }
        // Path compression.
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun getSize(x: Int): Int {
        return size[find(x)]
    }
}

class MergingCommunities(n: Int) {

    private val uf = UnionFind(n)

    fun connect(x: Int, y: Int) {
        uf.union(x, y)
    }

    fun getCommunitySize(x: Int): Int {
        return uf.getSize(x)
    }
}
