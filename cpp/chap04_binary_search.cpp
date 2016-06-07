// 二分探索
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_4_B&lang=jp

#include <iostream>

using namespace std;
int n, q, a[10000];

bool binary_search_contains(int v) {
    int l = 0; // left
    int r = n - 1; // right
    while (l <= r) {
        int m = (r + l) / 2;
        if (a[m] == v) {
            return true;
        }
        if (a[m] > v) {
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    return false;
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    cin >> q;
    int c = 0;
    for (int i = 0; i < q; i++) {
        int t;
        cin >> t;
        // original
        c += binary_search_contains(t) ? 1 : 0;

        // binary_search
        // c += binary_search(a, a + n, t) ? 1 : 0;
    }

    cout << c << endl;
}
