import java.util.PriorityQueue

fun shortestPath(n: Int, edges: List<List<Int>>, start: Int): List<Int> {
    val graph = hashMapOf<Int, MutableList<Pair<Int, Int>>>()
    val distances = MutableList(n) { Int.MAX_VALUE }
    distances[start] = 0
    // Represent the graph as an adjacency list.
    for ((u, v, w) in edges) {
        graph.computeIfAbsent(u) { mutableListOf() }.add(v to w)
        graph.computeIfAbsent(v) { mutableListOf() }.add(u to w)
    }
    val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    minHeap.add(0 to start) // (distance, node)
    // Use Dijkstra's algorithm to find the shortest path between the start node
    // and all other nodes.
    while (minHeap.isNotEmpty()) {
        val (currDist, currNode) = minHeap.poll()
        // If the current distance to this node is greater than the recorded
        // distance, we've already found the shortest distance to this node.
        if (currDist > distances[currNode]) {
            continue
        }
        // Update the distances of the neighboring nodes.
        for ((neighbor, weight) in graph[currNode] ?: emptyList()) {
            val neighborDist = currDist + weight
            // Only update the distance if we find a shorter path to this
            // neighbor.
            if (neighborDist < distances[neighbor]) {
                distances[neighbor] = neighborDist
                minHeap.add(neighborDist to neighbor)
            }
        }
    }
    // Convert all infinity values to -1, representing unreachable nodes.
    return distances.map { if (it == Int.MAX_VALUE) -1 else it }
}
