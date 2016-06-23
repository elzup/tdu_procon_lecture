package chap07.segument_tree;

import java.util.Arrays;
import java.util.Scanner;

// AOJ Range Minimum Query
// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_A&lang=jp

// segument tree, RMQ
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        SegmentTree st = new SegmentTree(n);
        for (int i = 0; i < q; i++) {
            int com = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (com == 1) {
                System.out.println(st.find(x, y + 1));
            } else {
                st.update(x, y);
            }
        }
    }

    static class SegmentTree {
        int[] data;
        int n;
        static int INF = (1 << 31) - 1;

        SegmentTree(int n_) {
            n = 1;
            while (n < n_) {
                n *= 2;
            }
            data = new int[2 * n - 1];

            Arrays.fill(data, INF);
        }

        int find(int a, int b) {
            return find(a, b, 0, 0, 0);
        }

        int find(int a, int b, int k, int l, int r) {
            if (r <= l) {
                r = n;
            }
            if (r <= a || b <= l) {
                return INF;
            }
            if (a <= l && r <= b) {
                return data[k];
            }
            int vl = find(a, b, k * 2 + 1, l, (r + l) / 2);
            int vr = find(a, b, k * 2 + 2, (r + l) / 2, r);
            return Math.min(vl, vr);
        }

        void update(int k, int a) {
            k += n - 1;
            data[k] = a;
            while (k > 0) {
                k = (k - 1) / 2;
                data[k] = Math.min(data[k * 2 + 1], data[k * 2 + 2]);
            }
        }
    }
}
