import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Solution for: https://www.hackerrank.com/challenges/even-tree

public class EvenTree {
    public static class Graph {
        Map<Integer, LinkedList<Integer>> adj;
        private int removed = 0;
    
        public Graph(int nodes){
            adj = new HashMap<Integer, LinkedList<Integer>>();
            for(int i = 1; i <= nodes; i++){
                adj.put(i, new LinkedList<Integer>());
            }
        }
    
        public void addNeighbor(int v1, int v2) {
            adj.get(v1).add(v2);
        }

        public List<Integer> getNeighbors(int v) {
            return adj.get(v);
        }
        
        public int getRemoved(){
            return removed;
        }
        
        public int processVertex(int edge, int parent, int count){
            List<Integer> neighbors = this.getNeighbors(edge);
            
            // is a leaf node
            if (neighbors.size() == 1){
                return count+1;
            }
            else{
                for (int node : this.getNeighbors(edge)){
                    if (node != parent){
                        int tempCount = processVertex(node, edge, 0);
                        if (tempCount%2 != 0)
                            count+=tempCount;
                    }
                }
            }
            if (count%2 != 0){
                //System.out.println(edge+" "+parent+" "+count);
                this.removed++;
                return 0;
            }
            
            return count+1;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numVertices = Integer.parseInt(in.next());
        int numEdges = Integer.parseInt(in.next());
        Graph g = new Graph(numVertices);
        //set up the graph
        for(int i = 0; i < numEdges; i++){
            int v1 = Integer.parseInt(in.next());
            int v2 = Integer.parseInt(in.next());
            g.addNeighbor(v1, v2);
            g.addNeighbor(v2, v1);
        } 
        
        // setting the root to the 1 vertex then processing all of the child nodes
        int removed = 0;
        for (int edge : g.getNeighbors(1)){
            int test = g.processVertex(edge, 1, 0);
        }
        System.out.println(g.getRemoved());
        
    }
}