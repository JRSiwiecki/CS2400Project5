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

    /**
     * Adds an object to the stack.
     *
     * @param newEntry An object to be added to the stack.
     */
    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    } 

    /**
     * Shows what is on the top of the stack.
     *
     * @return returns the object at the top of the stack
     */
    public T peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    } 

    /**
     * removes the object at the top of the stack.
     *
     * @return returns the object at the top of the stack
     */
    public T pop()
    {
        T top = peek(); // Might throw EmptyStackException
        // Assertion: topNode != null
        topNode = topNode.getNextNode();
        return top;
    } 

    /**
     * Checks whether the stack is empty or not.
     *
     * @return returns a boolean value about whether stack is empty or not
     */
    public boolean isEmpty()
    {
        return topNode == null;
    } 

    /**
     * Clears the stack by setting topNode pointer to null.
     */
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
