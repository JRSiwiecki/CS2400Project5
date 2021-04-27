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
	
	/**
	 * Accessor method to get the label of a vertex of this Graph
	 * @param vertex The vertex.
	 * @return The label of the vertex.
	 */
	public E getLabel(int vertex)
	{
		return labels[vertex];
	}
	
	/**
	 * Test whether an edge exists
	 * @param source The source.
	 * @param target The target.
	 * @return
	 */
	public boolean isEdges(int source, int target)
	{
		return edges[source][target];
	}
	
	/**
	 * Add an edge. 
	 * @param source The source.
	 * @param target The target.
	 */
	public void addEdge(int source, int target)
	{
		edges[source][target] = true;
	}
}
