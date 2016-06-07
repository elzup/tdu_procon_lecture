// 線形探索
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_4_A&lang=jp

#include <iostream>

using namespace std;

int main() {
    int n, q, s[10000];

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }
    cin >> q;
    int c = 0;
    for (int i = 0; i < q; i++) {
        int t;
        cin >> t;
        for (int j = 0; j < n; j++) {
            if (t == s[j]) {
                c++;
                break;
            }
        }
    }

    cout << c << endl;
}