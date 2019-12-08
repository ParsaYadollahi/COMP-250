package A4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GlobalMinCutTester {

    static final int MAX_ITERATIONS = 100;

    public static void main(String[] args) {

        String filename = "/Users/parsa/dev/COMP-250-251/Assignment4/src/A4/network_2.txt";
        System.out.println("Testing graph " + filename);
        Graph graph = new Graph(filename);
        System.out.println(graph);
        int minCutSize = graph.getExpectedMinCutSize();

        ArrayList<ArrayList<Character>> cut = GlobalMinCut.global_min_cut_repeated(graph, null, MAX_ITERATIONS);

        System.out.println("Cut found: " + cut);
        int cut_size = GlobalMinCut.get_cut_size(graph, cut);
        if (cut_size == minCutSize) {
            System.out.println("Success! Found min cut of size " + minCutSize);
        } else {
            System.out.println("Error! Found cut of size " + cut_size + " but minimal cut size is " + minCutSize);
        }
    }
}
