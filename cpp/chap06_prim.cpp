#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

struct Edge {
    int to, cost;
    bool operator<(const Edge& o) const {
        return cost > o.cost;
    }
};

const int MAX_V = 10000;
const int INF = 1 << 28;

int V, E;
vector<Edge> edges[MAX_V];
bool done[MAX_V];

int main() {
    cin >> V >> E;
    for (int i = 0; i < E; ++i) {
        int s, t, w;
        cin >> s >> t >> w;
        edges[s].push_back((Edge) { t, w });
        edges[t].push_back((Edge) { s, w });
    }

    int res = 0;
    priority_queue<Edge> que;
    fill(done, done + V, false);
    que.push((Edge) { 0, 0 });
    while (!que.empty()) {
        Edge e = que.top();
        que.pop();
        if (done[e.to]) { continue; }
        done[e.to] = true;
        res += e.cost;
        for (Edge e2: edges[e.to]) {
            que.push(e2);
        }
    }
    cout << res << endl;
}
