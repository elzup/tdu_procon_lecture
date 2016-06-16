#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

struct Edge {
    int source, to, cost;
    bool operator<(const Edge& o) const {
        return cost < o.cost;
    }
};

const int SIZE = 100000;

struct UnionFind {
    int gid[SIZE], rank[SIZE];
    int groups;

    void init(int n) {
        for (int i = 0; i < n; ++i) {
            gid[i] = i;
            rank[i] = 0;
        }
        groups = 0;
    }

    int find(int x) {
        if (gid[x] == x) {
            return x;
        }
        return gid[x] = find(gid[x]);
    }

    bool equals(int a, int b) {
        return find(a) == find(b);
    }

    int merge(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            if (rank[rx] < rank[ry]) {
                gid[rx] = ry;
            } else {
                gid[ry] = rx;
            }
            groups--;
        }
        return groups;
    }
};

const int MAX_V = 10000;
const int INF = 1 << 28;

int V, E;
bool done[MAX_V];

int main() {
    cin >> V >> E;
    Edge edges[E];
    for (int i = 0; i < E; ++i) {
        int s, t, w;
        cin >> s >> t >> w;
        edges[i] = (Edge) { s, t, w };
    }
    sort(edges, edges + E);
    UnionFind uf = UnionFind();
    uf.init(V);
    int costSum = 0;
    for (Edge e: edges) {
        if (uf.equals(e.source, e.to)) {
            continue;
        }
        costSum += e.cost;
        if (uf.merge(e.source, e.to) == 1) {
            break;
        }
    }

    cout << costSum << endl;
}
