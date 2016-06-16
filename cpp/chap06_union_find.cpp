#include <iostream>
#include <algorithm>

using namespace std;

const int SIZE = 100000;

struct UnionFind {
    int gid[SIZE], rank[SIZE];

    void init(int n) {
        for (int i = 0; i < n; ++i) {
            gid[i] = i;
            rank[i] = 0;
        }
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

    void merge(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) { return; }

        if (rank[rx] < rank[ry]) {
            gid[rx] = ry;
        } else {
            gid[ry] = rx;
        }
    }
};

int main() {
    int N, Q;
    cin >> N >> Q;
    UnionFind uf = UnionFind();
    uf.init(N);
    for (int i = 0; i < Q; ++i) {
        int p, a, b;
        cin >> p >> a >> b;
        if (p == 0) {
            uf.merge(a, b);
        } else {
            cout << (uf.equals(a, b) ? "Yes" : "No") << endl;
        }
    }
    return 0;
}
