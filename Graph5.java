import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph5 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    // Cheapest Flight with K stop
    public static void cheackCheapestFlight(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    @SuppressWarnings("unchecked")
    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        cheackCheapestFlight(flights, graph);

        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int v = e.dest;
                int wt = e.wt;
                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    // Connecting Cities with Minimum Cost - using Prim's Algorithm(Modified)
    static class City implements Comparable<City> {
        int dest;
        int cost;

        public City(int d, int c) {
            this.cost = c;
            this.dest = d;
        }

        @Override
        public int compareTo(City p2) {
            return this.cost - p2.cost;
        }
    }

    public static int citiesWithMinCost(int cities[][]) {
        boolean vis[] = new boolean[cities.length];
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            City curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;
                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new City(i, cities[curr.dest][i]));
                    }
                }
            }

        }
        return finalCost;
    }

    // Disjoint Set - (Union, Parent)
    static int n = 7;
    public static int par[] = new int[n];
    public static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) {
            return; // already in the same set, nothing to do
        }
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    // Minimum Spanning Tree - Kruskal's Algorithm(Greedy Based)
    static class Edge2 implements Comparable<Edge2> {
        int src;
        int dest;
        int wt;

        public Edge2(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge2 e2) {
            return this.wt - e2.wt;
        }
    }

    public static void createMST(ArrayList<Edge2> edges) {
        edges.add(new Edge2(0, 1, 10));
        edges.add(new Edge2(0, 2, 15));
        edges.add(new Edge2(0, 3, 30));
        edges.add(new Edge2(1, 3, 40));
        edges.add(new Edge2(2, 3, 50));
    }

    public static int kruskalAlgorithm(ArrayList<Edge2> edges, int V) {
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1; i++) {
            Edge2 e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        return mstCost;
    }

    // Flood Fill Algorithm
    public static void helper(int images[][], int sr, int sc, int color, boolean vis[][], int origCol) {
        if (sr < 0 || sc < 0 || sr >= images.length || sc >= images[0].length || vis[sr][sc]
                || images[sr][sc] != origCol) {
            return;
        }
        vis[sr][sc] = true;
        images[sr][sc] = color;
        helper(images, sr, sc - 1, color, vis, origCol);
        helper(images, sr, sc + 1, color, vis, origCol);
        helper(images, sr - 1, sc, color, vis, origCol);
        helper(images, sr + 1, sc, color, vis, origCol);
    }

    public static void floodFillAlgorithm(int images[][], int sr, int sc, int color) {
        boolean vis[][] = new boolean[images.length][images[0].length];
        helper(images, sr, sc, color, vis, images[sr][sc]);
        for (int[] row : images) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        // Cheapest Flight with K stop
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dest = 3, k = 1;
        System.out.println(cheapestFlight(flights.length, flights, src, dest, k));

        // Connecting Cities with Minimum Cost - using Prim's Algorithm(Modified)
        int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };
        System.out.println(citiesWithMinCost(cities));

        // Disjoint Set - (Union, Parent)
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        union(1, 5);

        // Minimum Spanning Tree - Kruskal's Algorithm(Greedy Based)
        init();
        ArrayList<Edge2> edges = new ArrayList<>();
        createMST(edges);
        System.out.println(kruskalAlgorithm(edges, 4));

        // Flood Fill Algorithm
        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        floodFillAlgorithm(image, sr, sc, color);
    }
}
