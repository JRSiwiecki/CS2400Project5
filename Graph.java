import java.util.*;
 
/**
 * A graph depicted with an adjacency list.
 * @author Joseph
 *
 */
public class Graph
{
    private int vertices;   // Number of vertices
    private LinkedList<Integer> list[]; // Adjacency List
 
    // Constructor
    @SuppressWarnings({ "unchecked", "rawtypes" })
	Graph(int v)
    {
        vertices = v;
        list = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            list[i] = new LinkedList();
    }
 
    /**
     * Adds an edge between two vertices.
     * @param source
     * @param target
     */
    public void addEdge(int source,int target)
    {
        list[source].add(target);
    }
 
    /**
     * Prints BreadthFirstTraversal traversal
     * @param source The given source/starting point.
     */
    public void BreadthFirstTraversal(int source)
    {
        // Mark all the vertices as not visited/false.
        boolean visited[] = new boolean[vertices];
 
        // Create a queue for BreadthFirstTraversal
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[source] = true;
        queue.add(source);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from the queue and print it.
            source = queue.poll();
            System.out.print(source +" ");
 
            // Get all adjacent vertices of the dequeued vertex source.
            // If the adjacent vertex has not been visited, then mark it as
            // visited and enqueue it.
            Iterator<Integer> iterator = list[source].listIterator();
            
            while (iterator.hasNext())
            {
                int node = iterator.next();
                
                if (!visited[node])
                {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
    
    /**
     * Performs a depth first traversal of a graph from the source.
     * @param source The source by which to begin the depth first traversal.
     */
    public void DepthFirstTraversal(int source)
    {
        // Initially mark all vertices as not visited/false.
        Vector<Boolean> visited = new Vector<Boolean>(vertices);
       
        for (int i = 0; i < vertices; i++)
        {
        	visited.add(false);
        }
            
        // Create a stack for depth first traversal.
        Stack<Integer> stack = new Stack<>();
         
        // Push the current source node.
        stack.push(source);
         
        while(stack.empty() == false)
        {
            // Pop the vertex from stack and print it.
        	source = stack.peek();
            stack.pop();
             
            // If the stack contains the same vertex twice, then
            // we need to print the only what was popped
            // if it is not visited.
            if(visited.get(source) == false)
            {
                System.out.print(source + " ");
                visited.set(source, true);
            }
             
            // Get all the adjacent vertices of the popped vertex source.
            // If an adjacent has not been visited, then push it to the stack.
            Iterator<Integer> itr = list[source].iterator();
             
            while (itr.hasNext())
            {
                int vertex = itr.next();
                
                if(!visited.get(vertex))
                {
                	stack.push(vertex);
                }
                    
            }
             
        }
    }
}