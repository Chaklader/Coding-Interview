#include <vector>
#include <queue>
#include <limits>

std::vector<int> shortestPath(int n, std::vector<std::vector<int>>& edges, int start) {
    std::vector<std::vector<std::pair<int, int>>> graph(n);
    std::vector<int> distances(n, std::numeric_limits<int>::max());
    distances[start] = 0;
    // Represent the graph as an adjacency list.
    for (auto& edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];
        graph[u].push_back({v, w});
        graph[v].push_back({u, w});
    }
    using P = std::pair<int, int>;
    std::priority_queue<P, std::vector<P>, std::greater<P>> minHeap;
    minHeap.push({0, start});
    // Use Dijkstra's algorithm to find the shortest path between the start node 
    // and all other nodes.
    while (!minHeap.empty()) {
        int currDist = minHeap.top().first;
        int currNode = minHeap.top().second;
        minHeap.pop();
        // If the current distance to this node is greater than the recorded 
        // distance, we've already found the shortest distance to this node.
        if (currDist > distances[currNode]) {
            continue;
        }
        // Update the distances of the neighboring nodes.
        for (auto& neighborPair : graph[currNode]) {
            int neighbor = neighborPair.first;
            int weight = neighborPair.second;
            int neighborDist = currDist + weight;
            // Only update the distance if we find a shorter path to this 
            // neighbor.
            if (neighborDist < distances[neighbor]) {
                distances[neighbor] = neighborDist;
                minHeap.push({neighborDist, neighbor});
            }
        }
    }
    // Convert all infinity values to -1, representing unreachable nodes.
    for (int i = 0; i < n; i++) {
        if (distances[i] == std::numeric_limits<int>::max()) {
            distances[i] = -1;
        }
    }
    return distances;
}