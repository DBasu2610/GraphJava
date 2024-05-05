
import java.util.ArrayList;

public class cycleDetection {
    
    
    //   1--->0<---|
    //        |    |
    //        v    |
    //        2--->3      
    
    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        boolean vis[] = new boolean[vertex];
        boolean rec[] =new boolean[vertex];

        createGraph(graph);


        depthFirst(graph,0,vis,rec);
        System.out.println();
    }


    static class  Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }   
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        
        graph[1].add(new Edge(1,0));
        
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
        
      
    }

   public static boolean depthFirst(ArrayList<Edge> graph[],int curr, boolean vis[], boolean rec[]) {
       vis[curr] = true;
       rec[curr] = true;

       for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if(!rec[e.dest]) {
            return true;
        } else if (!vis[e.dest]) {
            if(depthFirst(graph, e.dest, vis, rec)) {
                return true;
            } 
        }
        rec[curr] = false;
        
    }
    return false;
}

    
}
