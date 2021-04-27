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
		// TODO Auto-generated method stub
		
	}

	@Override
	public T dequeue() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFront() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		
	}

}
