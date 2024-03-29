/**
 * Queue implementation using arrays.
 * @author Joseph
 *
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
	private T[] queue; // Circular array of queue entries and one unused location.
	private int frontIndex; // Index of front entry.
	private int backIndex; // Index of back entry.
	private boolean integrityOK; // True if data structure is created correctly, false if corrupted.
	private static final int DEFAULT_CAPACITY = 3;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayQueue()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayQueue(int initialCapacity)
	{
		integrityOK = false;
		checkCapacity(initialCapacity);
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
		integrityOK = true;
	}
	
	@Override
	public void enqueue(T newEntry) 
	{
		checkIntegrity();
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}

	@Override
	public T dequeue() throws EmptyQueueException 
	{
		checkIntegrity();
		
		if(isEmpty())
			throw new EmptyQueueException();
		
		else
		{
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	}

	@Override
	public T getFront() throws EmptyQueueException 
	{
		checkIntegrity();
		
		if (isEmpty())
			throw new EmptyQueueException();
		
		else
			return queue[frontIndex];
	}

	@Override
	public boolean isEmpty() 
	{
		checkIntegrity();
		return frontIndex == ((backIndex + 1) % queue.length);
	}

	@Override
	public void clear() 
	{
		checkIntegrity();
		
		if (!isEmpty())
		{
			// Deallocates only the used portion.
			for (int index = frontIndex; index != backIndex; index = (index + 1) % queue.length)
			{
				queue[index] = null;
			}
			
			queue[backIndex] = null;
		}
		
		frontIndex = 0;
		backIndex = queue.length - 1;
	}
	
	/**
	 * Ensure capacity if array becomes full.
	 */
	private void ensureCapacity()
	{
		if (frontIndex == ((backIndex + 2) % queue.length))
		{
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			checkCapacity(newSize);
			integrityOK = false;
			
			// The cast is safe because the new array contains null entries.
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			
			for (int index = 0; index < oldSize - 1; index++)
			{
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			
			frontIndex = 0;
			backIndex = oldSize - 2;
			integrityOK = true;
		}
	}
	
	/**
     * Throws an exception if this object is not initialized. 
     */
    private void checkIntegrity()
    {
        if (!integrityOK)
        {
            throw new SecurityException("ArrayQueue object is corrupt.");
        }
    }
    
    /**
     * Checks capacity of the queue to make sure it is larger than the array should be.
     * @param capacity The capacity to be checked.
     */
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a queue whose " +
                                        "capacity exceeds allowed " +
                                        "maximum of " + MAX_CAPACITY);
        }
    }
}
