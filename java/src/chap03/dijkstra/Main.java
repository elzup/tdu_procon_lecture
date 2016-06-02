package chap03.dijkstra;

import java.util.*;

// dijkstra ダイクストラ
public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vn = sc.nextInt();
        int ve = sc.nextInt();
        int s = sc.nextInt();

        // List<Edge>[] edges = new ArrayList<Edge>[vn];
        List<List<Edge>> edges = new ArrayList<>();

        for (int i = 0; i < vn; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < ve; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int f = sc.nextInt();
            edges.get(a).add(new Edge(a, b, f));
            // 無向グラフ
            // edges[b].add(new Edge(b, a, f));
        }

        int[] distance = new int[vn];
        Arrays.fill(distance, INF);
        distance[s] = 0;
        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(s, s, 0));

        while (!queue.isEmpty()) {
            Edge e1 = queue.poll();
            if (distance[e1.target] < e1.cost) {
                continue;
            }

            for (Edge e2 : edges.get(e1.target)) {
                if (distance[e2.target] > distance[e1.target] + e2.cost) {
                    distance[e2.target] = distance[e1.target] + e2.cost;
                    queue.add(new Edge(e1.target, e2.target, distance[e2.target]));
                }
            }
        }

        for (int i = 0; i < vn; i++) {
            System.out.println(distance[i] == INF ? "INF" : distance[i]);
        }
    }

    static class Edge implements Comparable<Edge> {
        public int source;
        public int target;
        public int cost;

        public Edge(int source, int target, int cost) {
            this.source = source;
            this.target = target;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

