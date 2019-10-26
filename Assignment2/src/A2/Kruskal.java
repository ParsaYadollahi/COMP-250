/*
Contributors:
    Nicholas Nikas
    Mia Zhou
    Nikolai Peram
    Gaurav Karna
 */
package A2;
import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){

        WGraph new_g = new WGraph(); // graph to return

        DisjointSets set = new DisjointSets(g.getNbNodes()); // vertices in own components

        ArrayList<Edge> sorted_e = g.listOfEdgesSorted();

        for (int i = 0; i < sorted_e.size(); i++){ // loop while adding the safe edges
            Edge e = sorted_e.get(i); // gives edge
            if (IsSafe(set, e)) { // safe edge check
                new_g.addEdge(e);
            }
        }
        return new_g;

    }

    public static Boolean IsSafe(DisjointSets p, Edge e){
        int i = e.nodes[0];
        int j = e.nodes[1];

        // The two parents
        int i_par = p.find(i);
        int j_par = p.find(j);

        if (i_par != j_par) { // If not the same root
            p.union(e.nodes[0], e.nodes[1]); // union
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);
   }
}
