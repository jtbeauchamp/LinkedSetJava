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

public class SetText {
    public static void main(String[] args){
        SetInterface<String> setA = new LinkedSet<>();
        SetInterface<String> setB = new LinkedSet<>();
        SetInterface<String> setC = new LinkedSet<>();
        
        System.out.println("Set ADT by Joshua Beauchamp\n");

        //Testing Case 1
        setA.add("3");
        setA.add("2");
        setA.add("1");
        setB.add("3");
        setB.add("1");
        setB.add("2");
        System.out.println("Testing Case 1 for Equals and Union:");
        System.out.println("Set A = " + setA  + "\tSet B = " + setB);
        System.out.println("Testing equals: " + setA.equals(setB));

        System.out.print("Testing union: ");
        setC = setA.union(setB);    //Uses Set C to union Set A and Set B
        System.out.println(setC + "\n");

        //Testing Case 2
        setA.clear();
        setB.clear();
        setA.add("1");
        setB.add("1");
        setB.add("2");
        System.out.println("Testing Case 2 for Equals and Union:");
        System.out.println("Set A = " + setA  + "\tSet B = " + setB);
        System.out.println("Testing equals: " + setA.equals(setB));

        System.out.print("Testing union: ");
        setC = setA.union(setB);  
        System.out.println(setC + "\n");

        //Testing Case 3
        setA.clear();
        setB.clear();
        setA.add("3");
        setA.add("2");
        setA.add("1");
        setB.add("5");
        setB.add("4");
        setB.add("3");
        setB.add("2");
        System.out.println("Testing Case 3 for Equals and Union:");
        System.out.println("Set A = " + setA  + "\tSet B = " + setB);
        System.out.println("Testing equals: " + setA.equals(setB));

        System.out.print("Testing union: ");
        setC = setA.union(setB);
        System.out.println(setC + "\n");

        //Testing Case 4
        setA.clear();
        setB.clear();
        setA.add("1");
        setB.add("2");
        setB.add("3");
        System.out.println("Testing Case 4 for Equals and Union:");
        System.out.println("Set A = " + setA  + "\tSet B = " + setB);
        System.out.println("Testing equals: " + setA.equals(setB));

        System.out.print("Testing union: ");
        setC = setA.union(setB);
        System.out.println(setC + "\n");

        //Testing Case 5
        setA.clear();
        setB.clear();
        setA.add("");
        setB.add("1");
        setB.add("2");
        System.out.println("Testing Case 5 for Equals and Union:");
        System.out.println("Set A = " + setA  + "\tSet B = " + setB);
        System.out.println("Testing equals: " + setA.equals(setB));

        System.out.print("Testing union: ");
        setC = setA.union(setB);
        System.out.println(setC + "\n");

        //Tests add without allowing duplication
        System.out.println("Testing add method and checking for duplicates");
        System.out.println("Clearing set\nCurrent size: " + setA.getCurrentSize());
        System.out.println("Adding 5 \"Hi\"");
        for(int i = 0; i < 5; i++){
            setA.add("Hi");
        }
        System.out.println("Current size: " + setA.getCurrentSize() + "\n");

        //Tests toArray
        System.out.println("Testing toArray method");
        System.out.println("Clearing set");
        setA.clear();
        System.out.println("Adding: \"Hi\", \"how\", \"are\", \"you\" ");
        setA.add("Hi");
        setA.add("how");
        setA.add("are");
        setA.add("you");
        Object[] array = setA.toArray();
        System.out.println("Newly made array contents: ");
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println("");

        //Tests contains
        System.out.println("Testing contains method");
        System.out.println("Set A contains \"Joshua\" : "+ setA.contains("Joshua"));
        System.out.println("Adding \"Joshua\"");
        setA.add("Joshua");
        System.out.println("Set A contains \"Joshua\" : "+ setA.contains("Joshua") + "\n");

        //Tests both removes
        System.out.println("Testing both remove methods");
        System.out.println("Adding \"Howdy\" to setA");
        setA.add("Howdy");
        System.out.println("Adding letters \"b\" to \"d\" to setA");
        setA.add("b");
        setA.add("c");
        setA.add("d");
        System.out.println("Set A contains \"Howdy\": " + setA.contains("Howdy"));
        System.out.println("Removing \"Howdy\"");
        setA.remove("Howdy");
        System.out.println("Set A contains \"Howdy\": " + setA.contains("Howdy"));

        System.out.println("Set A's current size: " + setA.getCurrentSize());
        System.out.println("Removing random entry");
        setA.remove();
        System.out.println("Set A's current size: " + setA.getCurrentSize() + "\n");

        //Tests clear and getCurrentSize()
        System.out.println("Testing clear and getCurrentSize methods");
        System.out.println("Set A's size: "+ setA.getCurrentSize());
        setA.clear();
        System.out.println("Set A's size: " + setA.getCurrentSize());
    }
}
