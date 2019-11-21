package A3;
// Contributors: Alone

public class BellmanFord{

	/**
	 * Utility class. Don't use.
	 */
	public class BellmanFordException extends Exception{
		private static final long serialVersionUID = -4302041380938489291L;
		public BellmanFordException() {super();}
		public BellmanFordException(String message) {
			super(message);
		}
	}

	/**
	 * Custom exception class for BellmanFord algorithm
	 *
	 * Use this to specify a negative cycle has been found
	 */
	public class NegativeWeightException extends BellmanFordException{
		private static final long serialVersionUID = -7144618211100573822L;
		public NegativeWeightException() {super();}
		public NegativeWeightException(String message) {
			super(message);
		}
	}

	/**
	 * Custom exception class for BellmanFord algorithm
	 *
	 * Use this to specify that a path does not exist
	 */
	public class PathDoesNotExistException extends BellmanFordException{
		private static final long serialVersionUID = 547323414762935276L;
		public PathDoesNotExistException() { super();}
		public PathDoesNotExistException(String message) {
			super(message);
		}
	}

    private int[] distances = null;
    private int[] predecessors = null;
    private int source;

    BellmanFord(WGraph g, int source) throws BellmanFordException{
        /* Constructor, input a graph and a source
         * Computes the Bellman Ford algorithm to populate the
         * attributes
         *  distances - at position "n" the distance of node "n" to the source is kept
         *  predecessors - at position "n" the predecessor of node "n" on the path
         *                 to the source is kept
         *  source - the source node
         *
         *  If the node is not reachable from the source, the
         *  distance value must be Integer.MAX_VALUE
         *
         *  When throwing an exception, choose an appropriate one from the ones given above
         */

        /* YOUR CODE GOES HERE */
        this.source = source;
        this.distances = new int[g.getNbNodes()];
        distances[source] = 0;

        for (int i = 0; i < g.getNbNodes(); i++) {
            distances[i] = Integer.MAX_VALUE; // set distances to max
        }

        this.predecessors = new int[g.getNbNodes()]; // make an array of nodes for the distances
        predecessors[source] = 0; // source has distance 0

        for (int i = 0; i < g.getNbNodes(); i++) {
            predecessors[i] = Integer.MAX_VALUE; // make every node to infinity
        }

        for (int i = 1; i < g.getNbNodes()-1; i++) { // loop on each node and each edge ==> O(N*E)
            for (int j = 0; j < g.getEdges().size(); j++) {

                Edge e = g.getEdges().get(j); // get the edge at i
                int src = e.nodes[0]; // source node
                int dest = e.nodes[1]; // destination node
                int weight = e.weight; // weight of the two edges
                relax(src, dest, weight); // Relax each edge
            }
        }
        // Relaxed each edge
        for (int i = 0 ; i < g.getEdges().size(); i++){
            Edge e = g.getEdges().get(i);
            if (distances[e.nodes[0]] + e.weight < distances[e.nodes[1]]) { // if this checks, then theres a loop
                throw new NegativeWeightException();
            }
        }
    }
    private void relax(int src, int destination, int weight) {
        if (destination != this.source) { // check if its the source is destination
            if (distances[src] + weight < distances[destination]) { // condition to relax
                distances[destination] = distances[src] + weight;
                predecessors[destination] = src; // set the pred to the source
            }
        }
    }

    public int[] shortestPath(int destination) throws BellmanFordException{
        /*Returns the list of nodes along the shortest path from
         * the object source to the input destination
         * If not path exists an Exception is thrown
         * Choose appropriate Exception from the ones given
         */

        /* YOUR CODE GOES HERE (update the return statement as well!) */
        int[] path = new int[distances.length];
        path[0] = destination;
        int count = 1;
        int current = destination;
        while (current != this.source){ // moving back from destination
            current = predecessors[current]; // back = node before destination
            path[count] = current; // fill the back of the array with the nodes (i.e. reverse path from destination to source)
            count++;

            if (current == Integer.MAX_VALUE){
                throw new PathDoesNotExistException();
            }
        }
        int[] ret_path = new int[count];
        for (int i = 0; i < count; i++){
            ret_path[i] = path[count-(i+1)];
        }

        return ret_path;
    }

    public void printPath(int destination){
        /*Print the path in the format s->n1->n2->destination
         *if the path exists, else catch the Error and
         *prints it
         */
        try {
            int[] path = this.shortestPath(destination);
            for (int i = 0; i < path.length; i++){
                int next = path[i];
                if (next == destination){
                    System.out.println(destination);
                }
                else {
                    System.out.print(next + "-->");
                }
            }
        }
        catch (BellmanFordException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        try{
            BellmanFord bf = new BellmanFord(g, g.getSource());
            bf.printPath(g.getDestination());
        }
        catch (BellmanFordException e){
            System.out.println(e);
        }

   }
}
