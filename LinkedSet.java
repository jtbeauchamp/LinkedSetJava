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

public class LinkedSet<T> implements SetInterface<T>{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedSet(){
        firstNode = null;
        numberOfEntries = 0;
    }

    private class Node{
        private T data; //Entry in set
        private Node next;  //Link to next node

        private Node(T dataPortion){
            this(dataPortion, null);
        }   //end constructor

        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }   //end Node
    }   //end node

    /** Tests whether two sets are equal or not
     * @param setCompare the set being compared with
     * @return true if the sets contain same entries, else false */
    public boolean equals(SetInterface setCompare){
        boolean result = true;
        Node currentNode = firstNode;
 
        if(numberOfEntries != setCompare.getCurrentSize()){
            result = false;
        }
        else{
            while(currentNode != null){
                if(!(setCompare.contains(currentNode.data))){
                    result = false;
                }
                currentNode = currentNode.next;
            }
        }
        return result;
    }

    /** Combines two sets of strings into one set
     *  @setCompare set B that is being compared the main set A
     *  @return newly made set of all the entries between set A and set B */
    public SetInterface union(SetInterface setCompare){
        SetInterface <String> unionResult = new LinkedSet<>();
        T[] arrayCompare = (T[])setCompare.toArray();
        Node currentNode = firstNode;
        while(currentNode != null){
            unionResult.add(currentNode.data.toString());
            currentNode = currentNode.next;
        }
        for(T entry : arrayCompare){
            if(getReferenceTo(entry) == null){
                unionResult.add(entry.toString());
            }
        }
        return unionResult;
    }

    /** Overrides system output for objects to a string object
     * @return newly made string of entries */
    @Override
    public String toString(){
        String result = "";
        Node currentNode = firstNode;

        while(currentNode != null){
            if(currentNode.next != null)
                result = result + (currentNode.data + ",");
            else
                result = result + (currentNode.data);
            currentNode = currentNode.next;
        }
        return "{" + result + "}";
    }

     /** Adds a new entry to the set IF it is not already in set
     * @param newEntry the object being added as a new entry
     * @return true */
    public boolean add(T newEntry) {
        //Prevent duplication
        Node newNode = new Node(newEntry);
        if(getReferenceTo(newEntry) == null){
            newNode.next = firstNode;
            firstNode = newNode;
            numberOfEntries++;
        }
        return true;
    }   //end add

    /**Retrieves all entries in the set and puts them into an array
     * @return a new array with all the entries in the set */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while((index < numberOfEntries) && (currentNode != null)){
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        return result;
    }   //end toArray

    /**Tests whether or not the set contains a given entry\
     * @param anEntry the entry we are searching for
     * @return true if the entry is in the set, else false */
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null)){
            if(anEntry.equals(currentNode.data)){
                found = true;
            }
            else{
                currentNode = currentNode.next;
            }
        }
        return found;
    }   //end contains

    /**Removes unspecified entry from the set
     * @return the entry that was removed, or null if unsuccessful */
    public T remove() {
        T result = null;
        if(firstNode != null){
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }
        return result;
    }   //end remove

    /**Remove specified entry from the set
     * @param anEntry the entry being removed
     * @return true if anEntry is successfully remove, else false */
    public boolean remove(T anEntry){
        Node removeNode = search(anEntry);
        if(removeNode != null){
            removeNode.data = firstNode.data;
            remove();
            return true;
        }
        else{
            return false;
        }
    }   //end remove

    /**Removes all entries from the set */
    public void clear() {
        while(!isEmpty()){
            remove();
        }
    }   //end clear
  
    /**Returns the current size of the set
     * @return size the number of entries in the set */
    public int getCurrentSize(){
        return numberOfEntries;
    }

    /**Searches set for node containing desired data
     * @param key data being compared to other node's data
     * @return node referencing key data */
    private Node search(T key) {
        Node currentNode = firstNode;
        boolean found = false;

        while((!found) && (currentNode != null)){
            if(currentNode.data.equals(key)){
                found = true;
            }
            else{
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }   //end search

    /**Locates given entry for within this set
     * @param anEntry the entry we are trying to locate
     * @return reference to the node containing the entry,
     * if located, else null
     */
    private Node getReferenceTo(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        
        while((!found) && (currentNode != null)){
            if(anEntry.equals(currentNode.data)){
                found = true;
            }
            else{
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }   //end getReferenceTo

    /**Checks if the set is empty
     * @return true if set is empty, else false*/
    private boolean isEmpty(){
        return numberOfEntries <= 0;
    }   //end isEmpty
}