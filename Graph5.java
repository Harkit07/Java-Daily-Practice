public class Graph5 {

    // Cheapest Flight with K stop

    // Connecting Cities with Minimum Cost - using Prim's Algorithm(Modified)

    // Disjoint Set - (Union, Parent)

    // Minimum Spanning Tree - Kruskal's Algorithm(Greedy Based)

    // Flood Fill Algorithm

    public static void main(String[] args) {
        // Cheapest Flight with K stop
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dest = 3, k = 1;

        // Connecting Cities with Minimum Cost - using Prim's Algorithm(Modified)
        int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        // Disjoint Set - (Union, Parent)
        // union(1, 3);
        // find(3);
        // union(2, 4);
        // union(3, 6);
        // union(1,4);
        // find(3);
        // union(1, 5);

        // Minimum Spanning Tree - Kruskal's Algorithm(Greedy Based)

        // Flood Fill Algorithm
        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;

    }
}
