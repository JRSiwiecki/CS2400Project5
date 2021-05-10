import java.util.EmptyStackException;

/**
 * A class of stacks whose entries are stored in a chain of nodes.
 *
 * @author Joseph Siwiecki
 */

public final class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; // References the first node in the chain

    /**
     * Default constructor.
     */
    public LinkedStack()
    {
        topNode = null;
    } 

    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    } 

    public T peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    } 

    public T pop()
    {
        T top = peek(); // Might throw EmptyStackException
        // Assertion: topNode != null
        topNode = topNode.getNextNode();
        return top;
    } 

    public boolean isEmpty()
    {
        return topNode == null;
    } 

    public void clear()
    {
        topNode = null;
    } 

    /**
     * Inner class for linking objects in the stack using nodes.
     */
    private class Node
    {
        private T data; // Entry in stack
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } 

        private Node(T dataPortion, Node linkPortion)
        {
            data = dataPortion;
            next = linkPortion;
        } 

        private T getData()
        {
            return data;
        }

        private void setData(T newData)
        {
            data = newData;
        } 

        private Node getNextNode()
        {
            return next;
        } 

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
    } 
} 
