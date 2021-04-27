/**
 * Empty Queue Exception.
 * @author Joseph
 *
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends Exception
{
	public EmptyQueueException()
	{
		this(null);
	} 

	public EmptyQueueException(String message)
	{
		super(message);
	} 
}
