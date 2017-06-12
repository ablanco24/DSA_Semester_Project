package map;


/**
 * An Entry consists of a Key and a Value
 * 
 * @author Andrew Blanco
 * @version 11/18/16
 */
@SuppressWarnings("unchecked")
class Entry<K,V> implements Comparable<Entry<K,V>>
{
    K key;
    V value;
    Entry(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    
    public int compareTo(Entry<K,V> other)
    {
        Comparable thisKey = (Comparable) key;
        Comparable otherKey = (Comparable) (other.key);
        return thisKey.compareTo(otherKey);
    }
    
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Entry))
            return false;
        Entry other = (Entry) obj;
        
        return key.equals(other.key);
    }
    
    public int hashCode()
    {
        return key.hashCode();
    }
}
