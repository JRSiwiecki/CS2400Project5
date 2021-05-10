import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedLinkedDictionary<K, V> implements DictionaryInterface<K, V>
{
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    public UnsortedLinkedDictionary()
    {
        initializeDataFields();
    } 


    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    public V add(K key, V value)
    {
        if ((key == null) || (value == null))
        {
            throw new IllegalArgumentException("Cannot add null to a dictionary.");
        } else
        {
            if (this.contains(key))
            {
                return this.getValue(key);
            } else
            {
                Node newNode = new Node(key, value, firstNode);
                firstNode = newNode;
                numberOfEntries++;
                return null;
            }
        }

    }

    public V remove(K key)
    {
        if ((key == null))
        {
            throw new IllegalArgumentException("Cannot remove null from a dictionary.");
        } else
        {
            if (this.contains(key))
            {
                numberOfEntries--;
                return this.getValue(key);
            } else
            {
                return null;
            }
        }
    }

    public V getValue(K key)
    {
        Node currentNode = firstNode;
        Node nodeBefore = null;
        while (currentNode != null)
        {
            if (key.equals(currentNode.getKey()))
            {
                return (V) currentNode.getValue();
            }
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } 
        return null;
    }

    public boolean contains(K key)
    {
        boolean contains = false;
        Node currentNode = firstNode;
        Node nodeBefore = null;
        while ((currentNode != null))
        {
            if (key.equals(currentNode.getKey()))
            {
                contains = true;
                break;
            }
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        } 
        return contains;
    }

    public Iterator<K> getKeyIterator()
    {
        return new KeyIterator();
    }

    public Iterator<V> getValueIterator()
    {
        return new ValueIterator();
    }

    public boolean isEmpty()
    {
        if (numberOfEntries == 0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    public int getSize()
    {
        return numberOfEntries;
    }

    public void clear()
    {
        initializeDataFields();
    }

    private class Node<k, v>
    {
        private K key;
        private V value;

        private Node next; // Link to next node

        private Node(K keyPortion, V dataPortion)
        {
            key = keyPortion;
            value = dataPortion;
            next = null;
        } 

        private Node(K keyPortion, V dataPortion, Node nextNode)
        {
            key = keyPortion;
            value = dataPortion;
            next = nextNode;
        } 

        private Node getNextNode()
        {
            return next;
        } 

        private K getKey()
        {
            return key;
        }

        private V getValue()
        {
            return value;
        }

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } 

    }

    private class KeyIterator implements Iterator<K>
    {
        private Node nextNode;

        private KeyIterator()
        {
            nextNode = firstNode;
        }

        public boolean hasNext()
        {
            return nextNode != null;
        }

        public K next()
        {
            K result;
            if (hasNext())
            {
                result = (K) nextNode.getKey();
                nextNode = nextNode.getNextNode();
            } else
            {
                throw new NoSuchElementException("Illegal call to next(); iterator is after end of list");
            }
            return result;
        }
    } 


    private class ValueIterator implements Iterator<V>
    {
        private Node nextNode;

        private ValueIterator()
        {
            nextNode = firstNode;
        }

        public boolean hasNext()
        {
            return nextNode != null;
        }

        public V next()
        {
            V result;
            if (hasNext())
            {
                result = (V) nextNode.getValue();
                nextNode = nextNode.getNextNode();
            } else
            {
                throw new NoSuchElementException("Illegal call to next(); iterator is after end of list");
            }
            return result;
        }
    }
}
