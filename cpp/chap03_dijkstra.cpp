// ダイクストラ
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_1_A&lang=jp

#include<cstdio>
#include<iostream>
#include<queue>

using namespace std;

#define MAX_V 100000
#define INF 2147483647

struct edge {
    int to, cost;
};
//to,cost
typedef pair<int, int> P;//first:Minimum distance/second:Vertex number


int main() {
    int V, E, s;
    cin >> V >> E >> s;

    vector<edge> edges[MAX_V];

    for (int i = 0; i < E; ++i) {
        int a, b, f;
        cin >> a >> b >>f;
        edge ed = {b, f};
        edges[a].push_back(ed);
    }

    // ダイクストラ
    priority_queue<P, vector<P>, greater<P> > queue;
    int distance[MAX_V];
    fill(distance, distance + V, INF);
    distance[s] = 0;
    queue.push(P(0, s));

    while (!queue.empty()) {
        P p = queue.top();
        queue.pop();
        int e1_target = p.second;
        if (distance[e1_target] < p.first) {
            continue;
        }
        for (int i = 0; i < edges[e1_target].size(); i++) {
            edge e2 = edges[e1_target][i];
            if (distance[e2.to] > distance[e1_target] + e2.cost) {
                distance[e2.to] = distance[e1_target] + e2.cost;
                queue.push(P(distance[e2.to], e2.to));
            }
        }
    }

    for (int i = 0; i < V; ++i) {
        if (distance[i] >= INF) {
            cout << "INF" << endl;
        } else {
            cout << distance[i] << endl;

        }
    }
    return 0;
}