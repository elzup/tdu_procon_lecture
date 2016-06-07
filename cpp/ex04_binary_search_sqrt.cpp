// 二分探索で sqrt

#include <iostream>
#include <cmath>

using namespace std;
int n;
const double accuracy = 0.00000000001;

double binary_search_sqrt(double v) {
    double l = 0; // left
    double r = v; // right
    while (r - l > accuracy) {
        double m = (r + l) / 2;
        double t = m * m;
        // double t = m * m * m;
        if (t < v) {
            l = m + accuracy;
        } else {
            r = m - accuracy;
        }
    }
    return (l + r) / 2.0;
}

int main() {
    cin >> n;
    cout << binary_search_sqrt(n) << endl;
    // cout << sqrt(n) << endl;
}
