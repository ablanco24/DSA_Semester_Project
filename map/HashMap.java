package map;
import hash.HashTable;

/**
 * An implementation of Map, using HashTable
 * 
 * @author Andrew Blanco 
 * @version 11/21/16
 */
public class HashMap<K,V> implements Map<K,V>
{
    HashTable<Entry<K,V>> table = new HashTable<Entry<K,V>>();
    
    public HashMap()
    {
    }
    
    public HashMap(int capacity)
    {
        table = new HashTable<Entry<K,V>>(capacity);
    }
    
    public boolean containsKey(K key)
    {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        return table.containsKey(entry);
    }
    
    public V get(K key)
    {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        entry = table.get(entry);
        if(entry == null)
            return null;
        return entry.value;
    }
    
    public V put(K key, V value)
    {
        Entry<K,V> newEntry = new Entry<K,V>(key,value);
        Entry<K,V> oldEntry = table.get(newEntry);
        if(oldEntry == null)
        {
            table.put(newEntry);
            return null;
        }
        
        V oldValue = oldEntry.value;
        oldEntry.value = value;
        return oldValue;
        
    }
    
    public V remove(K key)
    {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        entry = table.get(entry);
        if(entry == null)
            return null;
        
        table.remove(entry);
        return entry.value;
    }
}
