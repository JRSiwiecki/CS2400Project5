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
	
	/**
	 * Obtain a list of neighbors of a specified vertex of this Graph.
	 * @param vertex The vertex.
	 * @return The list of neighbors.
	 */
	public int[] neighbors(int vertex)
	{
		int i;
		int count = 0;
		int[] answer;
		
		for (i = 0; i < labels.length; i++)
		{
			if (edges[vertex][i])
				count++;
		}
		
		answer = new int[count];
		count = 0;
		
		for (i = 0; i < labels.length; i++)
		{
			if (edges[vertex][i])
				answer[count++] = i;
		}
		
		return answer;
	}
	
	/**
	 * Remove an edge.
	 * @param source The source.
	 * @param target The target.
	 */
	public void removeEdge(int source, int target)
	{
		edges[source][target] = false;
	}
	
	/**
	 * Change the label of a vertex of this Graph.
	 * @param vertex The vertex.
	 * @param newLabel The new label to be set to the vertex.
	 */
	public void setLabel(int vertex, E newLabel)
	{
		labels[vertex] = newLabel;
	}
	
	/**
	 * Accessor method to determine the number of vertices in this Graph.
	 * @return The number of labels in the graph.
	 */
	public int size()
	{
		return labels.length;
	}
}
