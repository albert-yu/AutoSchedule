package com.opencsv;
import java.util.HashMap;


/**
 * A nested HashMap! Only works if the key type is the same for both 
 * inner and outer maps.
 * 
 * @author Albert Yu, but probably someone has already implemented this
 * before
 *
 * @param <E> The type of the keys of both the inner and outer maps
 * @param <F> The type of the value of the inner map
 */

public class HashMap2D<E, F>
{

   /**
    * The outer map
    */
   private HashMap<E, HashMap<E, F>> outerMap;
   
   /**
    * The size of the outer map
    */
   private int size;
   
   /**
    * Constructor for HashMap just creates outer map.
    */
   public HashMap2D()
   {
      clear();
   }
   
   /**
    * Removes all mappings from this map.
    */
   public void clear()
   {
      outerMap = new HashMap<E, HashMap<E, F>>();
      size = 0;
   }
   
   /**
    * Assigns a key-value pair to the inner map.
    * @param key1, for the outer map
    * @param key2, for the inner map
    * @param value, the value of the inner map
    */
   public void put(E key1, E key2, F value)
   {
      HashMap<E, F> innerMap = outerMap.get(key1);
      innerMap.put(key2, value);
   }
   
   /**
    * Assigns an empty inner map to the as the value for the given
    * outer map key
    * @param key
    */
   public void put(E key)
   {
      HashMap<E, F> innerMap = new HashMap<E, F>();
      outerMap.put(key, innerMap);
      size ++;
   }
   
   /**
    * Returns the value of given by the key1, key2 coordinates
    * @param key1
    * @param key2
    * @return
    */
   public F get(E key1, E key2)
   {
      HashMap<E, F> innerMap = outerMap.get(key1);
      return innerMap.get(key2);
   }
   
   /**
    * Returns the inner map associated with the given key
    * @param key
    * @return
    */
   public HashMap<E, F> get(E key)
   {
      return outerMap.get(key);
   }
   
   /**
    * Removes the value in the inner map given by the key1, key2 coordinates
    * @param key1
    * @param key2
    */
   public void remove(E key1, E key2)
   {
      HashMap<E, F> innerMap = outerMap.get(key1);
      innerMap.remove(key2);
   }
   
   /**
    * Removes the inner map at the given key.
    * @param key
    */
   public void remove(E key)
   {
      outerMap.remove(key);
      size--;
   }
   
   public int size()
   {
      return size;
   }
   
}
