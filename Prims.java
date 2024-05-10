import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertex];

        create(graph);
        Prim(graph, vertex);

        
    }

    static class  Edge {
        int src;
        int dest;
        int weight;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }    
    }


    public static void create(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();  
        }


        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        

    } 


    public static class Pair implements Comparable<Pair> {
        int node;
        int cost;
        public Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }   

        @Override 
        public int compareTo(Pair p2) {
            return this.cost-p2.cost;
        }

    }

    public static void Prim( ArrayList<Edge> graph[], int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int cost = 0;

        pq.add(new Pair(0, 0));

        boolean vis[] = new boolean[V];

        while ((!pq.isEmpty())) 
        {
            Pair curr = pq.remove();
            if(!vis[curr.node]) {
                vis[curr.node] = true;
                cost = cost + curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);

                    if(!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight));
                    }
                    
                }

            }
            
        }

        System.out.println("minimum cost=" + cost);

    }
    
}
