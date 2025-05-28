#include <vector>
#include <algorithm>
#include <tuple>
#include <cstdlib> 

class UnionFind {
public:
    std::vector<int> parent;
    std::vector<int> size;
    UnionFind(int size) {
        parent.resize(size);
        this->size.resize(size, 1);
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    
    bool unionSets(int x, int y) {
        int repX = findSet(x);
        int repY = findSet(y);
        if (repX != repY) {
            if (size[repX] > size[repY]) {
                parent[repY] = repX;
                size[repX] += size[repY];
            } else {
                parent[repX] = repY;
                size[repY] += size[repX];
            }
            // Return true if both groups were merged.
            return true;
        }
        // Return false if the points belong to the same group.
        return false;
    }

    int findSet(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = findSet(parent[x]);
        return parent[x];
    }
};

int connectTheDots(std::vector<std::vector<int>>& points) {
    int n = points.size();
    // Create and populate a list of all possible edges.
    std::vector<std::tuple<int, int, int>> edges;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            // Manhattan distance.
            int cost = std::abs(points[i][0] - points[j][0]) + std::abs(points[i][1] - points[j][1]);
            edges.push_back(std::make_tuple(cost, i, j));
        }
    }
    // Sort the edges by their cost in ascending order.
    std::sort(edges.begin(), edges.end());
    UnionFind uf(n);
    int totalCost = 0;
    int edgesAdded = 0;
    // Use Kruskal's algorithm to create the MST and identify its minimum cost.
    for (auto& edge : edges) {
        int cost, p1, p2;
        std::tie(cost, p1, p2) = edge;
        // If the points are not already connected (i.e. their representatives are
        // not the same), connect them, and add the cost to the total cost.
        if (uf.unionSets(p1, p2)) {
            totalCost += cost;
            edgesAdded++;
            // If n - 1 edges have been added, the MST is complete.
            if (edgesAdded == n - 1) {
                return totalCost;
            }
        }
    }
    return totalCost;
}