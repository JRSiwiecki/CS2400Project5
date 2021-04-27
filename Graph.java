public class Graph<E>
{
	private boolean[][] edges; // edges[i][j] is true if thehre is a vertex from i to j
	private E[] labels; // labels[i] contains the label for vertex i
	
	@SuppressWarnings("unchecked")
	public Graph(int n)
	{
		edges = new boolean[n][n]; // All values initially false
		labels = (E[]) new Object[n]; // All values initially null
	}
}
