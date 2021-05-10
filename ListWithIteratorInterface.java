import java.util.Iterator;
/**
 An interface for the ADT list that has an iterator.

 @author Joseph Siwiecki
 */
public interface ListWithIteratorInterface<T> extends ListInterface<T>, Iterable<T>
{
    public Iterator<T> getIterator();

} 