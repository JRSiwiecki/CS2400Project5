/**
 * Driver class to test methods.
 * @author Joseph Siwiecki
 *
 */
public class Driver 
{
	public static void main(String[] args)
	{
		Graph graph = new Graph(9);
		 
        /*
         * I used numbers instead, sorry!
         * A = 0
         * B = 1
         * C = 2
         * D = 3
         * E = 4
         * F = 5
         * G = 6
         * H = 7
         * I = 8
         */
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(2, 1);
		graph.addEdge(3, 6);
		graph.addEdge(4, 5);
		graph.addEdge(4, 7);
		graph.addEdge(5, 2);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);
		graph.addEdge(8,5);
        
 
        System.out.println("Following is Breadth First Traversal of the graph starting from A/0: ");
 
        graph.BreadthFirstTraversal(0);
        
        System.out.println("\n\nFollowing is Depth First Traversal of the graph starting from A/0: ");
        
        graph.DepthFirstTraversal(0);
	}
}
