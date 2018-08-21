//---------------------------------------------------------------------------
// ArrayCollection.java          by Dale/Joyce/Weems                Chapter 5
//
// Implements the CollectionInterface using an array.
//
// Null elements are not permitted in this collection.
//
// Two constructors are provided: one that creates a collection of a default
// capacity, and one that allows the calling program to specify the capacity.
//---------------------------------------------------------------------------

package ch05.collections;

public class ArrayCollection<T> implements CollectionInterface<T>
{
    protected final int DEFCAP = 100; // default capacity
    protected T[] collection;         // array to hold collection’s elements
    protected int numElements = 0;    // number of elements in this collection

    // set by find method
    protected boolean found;  // true if element found, otherwise false
    protected int location;   // indicates location of element if found

    public ArrayCollection()
    {
        collection = (T[]) new Object[DEFCAP];
    }

    public ArrayCollection(int capacity)
    {
        collection = (T[]) new Object[capacity];
    }

    protected int comparisons = 0;

    public int compareCount(){
        return comparisons;
    }

    protected void find(T target)
    // Searches collection for an occurrence of an element e such that
    // e.equals(target). If successful, sets instance variables
    // found to true and location to the array index of e. If
    // not successful, sets found to false.
    {
        location = 0;
        found = false;

        while (location < numElements)
        {
            comparisons++;
            if (collection[location].equals(target))
            {
                found = true;
                return;
            }
            else
                location++;
        }
    }

    public boolean add(T element)
    // Adds element to this collection.
    {
        if (isFull())
            return false;
        else
        {
            collection[numElements] = element;
            numElements++;
            return true;
        }
    }

    public boolean remove (T target)
    // Removes an element e from this collection such that e.equals(target)
    // and returns true; if no such element exists, returns false.
    {
        find(target);
        if (found)
        {
            collection[location] = collection[numElements - 1];
            collection[numElements - 1] = null;
            numElements--;
        }
        return found;
    }

    public int size()
    // Returns the number of elements in this collection.
    {
        return numElements;
    }

    public boolean contains (T target)
    // Returns true if this collection contains an element e such that
    // e.equals(target); otherwise, returns false.
    {
        find(target);
        return found;
    }

    public T get(T target)
    // Returns an element e from this collection such that e.equals(target);
    // if no such element exists, returns null.
    {
        find(target);
        if (found)
            return collection[location];
        else
            return null;
    }

    public boolean isEmpty()
    // Returns true if this collection is empty; otherwise, returns false.
    {
        return (numElements == 0);
    }

    public boolean isFull()
    // Returns true if this collection is full; otherwise, returns false.
    {
        return (numElements == collection.length);
    }
}