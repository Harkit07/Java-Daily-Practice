import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph3 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void checkTopSort(ArrayList<Edge> graph[]) { // Directed Graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    public static void checkAllPath(ArrayList<Edge> graph[]) {// Directed Graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3, 1));

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    public static void checckDijkstra(ArrayList<Edge> graph[]) {// Directed Graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // Topological Sort - (BFS)
    public static void calIndegree(ArrayList<Edge> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSortBFS(ArrayList<Edge> graph[]) {
        int indeg[] = new int[graph.length];
        calIndegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }

        }
        System.out.println();
    }

    // Print all Path - Directed Graph
    public static void printPath(ArrayList<Edge> graph[], int src, int dest, String path) {

    }

    // Dijkstra's Algorithm

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        checkTopSort(graph);
        topSortBFS(graph);

    }
}
