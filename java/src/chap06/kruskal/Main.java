package chap06.kruskal;

import java.util.Arrays;
import java.util.Scanner;

// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_2_A&lang=jp
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(s, t, w);
        }
        Arrays.sort(edges);
        UnionFind uf = new UnionFind(V);
        int costSum = 0;
        for (Edge e : edges) {
            if (!uf.equals(e.s, e.t)) {
                costSum += e.w;
                uf.merge(e.s, e.t);
                if (uf.groups == 1) {
                    break;
                }
            }
        }
        System.out.println(costSum);
    }

    static class UnionFind {
        public int[] v;
        int groups;

        UnionFind(int n) {
            v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = i;
            }
            groups = n;
        }

        int find(int p) {
            if (v[p] == p) {
                return p;
            }
            return v[p] = find(v[p]);
        }

        boolean equals(int a, int b) {
            return this.find(a) == this.find(b);
        }

        int merge(int p, int q) {
            p = find(p);
            q = find(q);
            if (p != q) {
                v[q] = p;
                groups--;
            }
            return groups;
        }
    }

    public static class Edge implements Comparable<Edge> {
        public int s, t, w;

        Edge(int s, int t, int w) {
            this.s = s;
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
            // return o.w - this.w;
        }
    }
}
