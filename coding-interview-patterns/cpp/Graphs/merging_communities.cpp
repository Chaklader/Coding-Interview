#include <vector>

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

    void unionSets(int x, int y) {
        int repX = findSet(x);
        int repY = findSet(y);
        if (repX != repY) {
            // If 'repX' represents a larger community, connect 
            // 'repY's community to it.
            if (size[repX] > size[repY]) {
                parent[repY] = repX;
                size[repX] += size[repY];
                // Otherwise, connect 'repX's community to 'repY'.
            } else {
                parent[repX] = repY;
                size[repY] += size[repX];
            }
        }
    }

    int findSet(int x) {
        if (x == parent[x]) {
            return x;
        }
        // Path compression.
        parent[x] = findSet(parent[x]);
        return parent[x];
    }

    int getSize(int x) {
        return size[findSet(x)];
    }
};

class MergingCommunities {
public:
    UnionFind uf;
    MergingCommunities(int n) : uf(n) {}

    void connect(int x, int y) {
        uf.unionSets(x, y);
    }
    
    int getCommunitySize(int x) {
        return uf.getSize(x);
    }
};