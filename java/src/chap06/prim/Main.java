package chap06.prim;

import java.util.*;

// http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=GRL_2_A&lang=jp
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        @SuppressWarnings("unchecked")
        List<Edge>[] edges = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            edges[s].add(new Edge(s, t, w));
            edges[t].add(new Edge(t, s, w));
        }

        boolean[] done = new boolean[V];
        Arrays.fill(done, false);
        Queue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(0, 0, 0));
        int costSum = 0;
        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (done[e.t]) {
                continue;
            }
            done[e.t] = true;
            costSum += e.w;
            q.addAll(edges[e.t]);
        }
        System.out.println(costSum);
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
        }
    }
}
