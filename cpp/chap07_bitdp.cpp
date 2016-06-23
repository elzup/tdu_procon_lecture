//
// AOJ: Traveling by Stagecoach
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=1138&lang=jp

#include<iostream>
#include<vector>
#include <queue>

#define INF 1<<29

using namespace std;

struct Edge {
    int to;
    double cost;
};

// priority queue に追加する<状態を表す構造>
struct P {
    int v;
    double cost;
    int tickets; // ticket bit 列

    bool operator<(const P& o) const {
        return cost > o.cost;
    }
};

int main() {
    while (true) {
        int n, m, rn, s, g;
        double cost[30][257], ticket[8];

        cin >> n >> m >> rn >> s >> g;
        if ((n | m | rn | s | g) == 0) {
            break;
        }
        s--;
        g--;
        for (int i = 0; i < n; ++i) {
            int t;
            cin >> t;
            ticket[i] = t;
        }

        // 頂点ごとから伸びるエッジ一覧
        vector<Edge> edges[30];

        for (int j = 0; j < rn; j++) {
            int x, y;
            double z;
            cin >> x >> y >> z;
            // 無向グラフ
            edges[x - 1].push_back((Edge) { y - 1, z } );
            edges[y - 1].push_back((Edge) { x - 1, z } );
        }
        double dp[31][1 << 9];
        for (int i = 0; i < m; ++i) {
            fill(dp[i], dp[i] + (1 << n), INF);
        }
        dp[s][(1 << n) - 1] = 0;

        priority_queue<P> que;
        // start 追加
        que.push((P) { s, 0, (1 << n) - 1 });
        while (!que.empty()) {
            P p = que.top();
            que.pop();
            for (int ei = 0; ei < edges[p.v].size(); ei++) {
                Edge e = edges[p.v][ei];
                // use any ticket
                for (int i = 0; i < n; i++) {
                    if (((p.tickets >> i) & 1 ) == 0) {
                        continue;
                    }
                    // 残っているチケット [i] を使った場合
                    int at = p.tickets - (1 << i);
                    // コストを更新できるならば更新して pq に追加

                    if (dp[e.to][at] > dp[p.v][p.tickets] + e.cost / ticket[i]) {
                        dp[e.to][at] = dp[p.v][p.tickets] + e.cost / ticket[i];
                        que.push((P) { e.to, dp[e.to][at], at });
                    }
                }
            }
        }

        double res = INF;
        // goal 頂点で書く残り枚数の最小コスト
        for (int i = 0; i < (1 << n) - 1; ++i) {
            res = min(res, dp[g][i]);
        }
        if (res == INF) {
            cout << "Impossible" << endl;
        } else {
            cout << res << endl;
        }
    }
}