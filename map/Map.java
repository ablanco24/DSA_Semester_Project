package map;


/**
 * A map consists of entries.
 * Each Entry is a key-value pair. 
 * Access is fast for Keys, No duplicate keys
 * 
 * @author Andrew Blanco
 * @version 11/18/16
 */
public interface Map<K,V>
{
    /**
     * @return true if this map contains entry with the given key
     */
    boolean containsKey(K key);
    
    /**
     * @return the value of the entry which has the given key, 
     * or null if not in this map
     */
    V get(K key);
    
    /**
     * Put an entry with given key and value into this map.
     * @return old value, or null if not in Map
     */
    V put(K key, V value);
    
    /**
     * Remove the entry having the given key, from this map
     * @return the value of that entry or null if not in this map
     */
    V remove(K key);
  
}
