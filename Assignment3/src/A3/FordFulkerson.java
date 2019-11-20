package A3;
import java.io.*;
import java.util.*;




public class FordFulkerson {

	
	public static ArrayList<Integer> pathDFS(Integer source, Integer destination, WGraph graph){
		ArrayList<Integer> Stack = new ArrayList<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>(); // All initialized to false

		Stack = DFSHelper(source, destination, graph, visited);

		return Stack;
	}

	public static ArrayList<Integer> DFSHelper(Integer source, Integer destination, WGraph graph, ArrayList<Integer> visited) {
		ArrayList<Integer> Stack = new ArrayList<Integer>();
		ArrayList<Integer> empty = new ArrayList<Integer>();
		ArrayList<Integer> Stack_hold= new ArrayList<Integer>();

		visited.add(source);
		Stack.add(source);
		if (source == destination) {
			return Stack;
		}
		for (int i = 0; i < graph.getEdges().size();i++) {
			ArrayList<Edge> edgy = graph.getEdges();
			Edge e = edgy.get(i);
			if (e.nodes[0] == source && e.weight != 0) {

				if (!visited.contains(e.nodes[1])) {

					Stack_hold = DFSHelper(e.nodes[1], destination, graph, visited);

					if (!Stack_hold.isEmpty() && Stack_hold.contains(destination)) {
						Stack.addAll(Stack_hold);
					}
				}
			}
			if (Stack.contains(destination)) {
				return Stack;
			}
		}
		return empty;
	}


	public static void fordfulkerson(Integer source, Integer destination, WGraph graph, String filePath){
		String answer="";
		String myMcGillID = "260869949"; //Please initialize this variable with your McGill ID
		int maxFlow = 0;

		/* YOUR CODE GOES HERE*/
		WGraph residualGraph = new WGraph(graph);
		for (int i = 0; i < graph.getEdges().size(); i++){
			Edge e = graph.getEdges().get(i);
			Edge new_edge = new Edge(e.nodes[1], e.nodes[0], 0);
			if (graph.getEdge(e.nodes[1], e.nodes[0]) == null) {
				residualGraph.addEdge(new_edge);
			}
		}


		int bottleNeck = 0;
		ArrayList<Integer> path = pathDFS(source, destination, residualGraph);

		if (!path.isEmpty()) {
			while (!path.isEmpty()) {
				bottleNeck = capacity(path, residualGraph);

				for (int i = 0; i < path.size() - 1; i++) {

					Edge forwardEdge = residualGraph.getEdge(path.get(i), path.get(i + 1)); // get forward edge
					Edge backEdge = residualGraph.getEdge(path.get(i + 1), path.get(i)); // get backward edge

					residualGraph.setEdge(path.get(i), path.get(i + 1), forwardEdge.weight - bottleNeck); // update forward edge capacity (dec cap)
					residualGraph.setEdge(path.get(i + 1), path.get(i), backEdge.weight + bottleNeck); // update back edge capacity (inc cap)
				}
				maxFlow += bottleNeck;
				path = pathDFS(source, destination, residualGraph); // diff path from source to dest
			}
			for (int x = 0; x < graph.getEdges().size() - 1; x++) { // update the current graph
				Edge edge = residualGraph.getEdges().get(x);
				int weight = residualGraph.getEdge(edge.nodes[0], edge.nodes[1]).weight;
				graph.setEdge(edge.nodes[0], edge.nodes[1], graph.getEdges().get(x).weight - weight);
			}
		} else {
			maxFlow = -1;
		}


		
		answer += maxFlow + "\n" + graph.toString();	
		writeAnswer(filePath+myMcGillID+".txt",answer);
		System.out.println(answer);
	}

	public static int capacity(ArrayList<Integer> path, WGraph graph){ // function that returns the max flow in a paths
		int[] weights = new int[path.size()-1];

		for (int i = 0; i < path.size()-1; i++){
			Edge e = graph.getEdge(path.get(i), path.get(i+1));
			weights[i] = e.weight;
		}
		Arrays.sort(weights);
		return weights[0];
	}
	
	
	public static void writeAnswer(String path, String line){
		BufferedReader br = null;
		File file = new File(path);
		// if file doesnt exists, then create it
		
		try {
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(line+"\n");	
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	 public static void main(String[] args){
		 String file = "/home/parsa/git/COMP-250-251/Assignment3/src/A3/ff2.txt";
		 File f = new File(file);
		 WGraph g = new WGraph(file);
		 fordfulkerson(g.getSource(),g.getDestination(),g,f.getAbsolutePath().replace(".txt",""));
	 }
}
