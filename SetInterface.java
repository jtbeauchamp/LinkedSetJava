//  
//  Name:       Beauchamp, Joshua
//  Project:    2
//  Due:        October 6, 2023
//  Course:     cs-2400-02-f23
// 
//  Description:
//              Creating a linked set ADT that utilizes the core interface
//              methods, along with a union method, an equals method, and a
//              toString method override for outputting the sets
//

public interface SetInterface<T>{

    /** Tests whether two sets are equal or not
     * @param setCompare the set being compared with
     * @return true if the sets contain same entries, else false */
    public boolean equals(SetInterface setCompare);

    /** Combines two sets of strings into one set
     *  @setCompare set B that is being compared the main set A
     *  @return newly made set of all the entries between set A and set B */
    public SetInterface union(SetInterface rhs);

    /** Overrides system output for objects to a string object
     * @return newly made string of entries */
    public String toString();

    /** Adds a new entry to the set IF it is not already in set
     * @param newEntry the object being added as a new entry
     * @return true */
    public boolean add(T newEntry);

    /**Retrieves all entries in the set and puts them into an array
     * @return a new array with all the entries in the set */
    public T[] toArray();

    /**Tests whether or not the set contains a given entry\
     * @param anEntry the entry we are searching for
     * @return true if the entry is in the set, else false */
    public boolean contains(T anEntry);

    /**Removes unspecified entry from the set
     * @return the entry that was removed, or null if unsuccessful */
    public T remove();

    /**Remove specified entry from the set
     * @param anEntry the entry being removed
     * @return true if anEntry is successfully remove, else false */
    public boolean remove(T anEntry);

    /**Removes all entries from the set */
    public void clear();

    /**Returns the current size of the set
     * @return size the number of entries in the set */
    public int getCurrentSize();
}