class UnionFind:
    def __init__(self, size: int):
        self.parent = [i for i in range(size)]
        self.size = [1] * size

    def union(self, x: int, y: int) -> None:
        rep_x, rep_y = self.find(x), self.find(y)
        if rep_x != rep_y:
            # If 'rep_x' represents a larger community, connect
            # 'rep_y 's community to it.
            if self.size[rep_x] > self.size[rep_y]:
                self.parent[rep_y] = rep_x
                self.size[rep_x] += self.size[rep_y]
                # Otherwise, connect 'rep_x's community to 'rep_y'.
            else:
                self.parent[rep_x] = rep_y
                self.size[rep_y] += self.size[rep_x]
        
    def find(self, x: int) -> int:
        if x == self.parent[x]:
            return x
        # Path compression.
        self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def get_size(self, x: int) -> int:
        return self.size[self.find(x)]


class MergingCommunities:
    def __init__(self, n: int):
        self.uf = UnionFind(n)

    def connect(self, x: int, y: int) -> None:
        self.uf.union(x, y)

    def get_community_size(self, x: int) -> int:
        return self.uf.get_size(x)