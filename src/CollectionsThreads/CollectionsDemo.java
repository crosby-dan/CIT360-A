package CollectionsThreads;

import java.util.*;

public class CollectionsDemo {
    Character[] appleJacks = {'A', 'P', 'P', 'L', 'E', ' ', 'J', 'A', 'C', 'K', 'S'};
    Character[] riceCrispies = {'R', 'I', 'C', 'E', ' ', 'C', 'R', 'I', 'S', 'P', 'I', 'E', 'S'};

    public void DemoList() {
        System.out.println("***************************************");
        System.out.println("**  Java Collections Demonstration  ***");
        System.out.println("**            By Dan Crosby         ***");
        System.out.println("***************************************");

        System.out.println("For purposes of this demonstration, we have defined a list of characters containing the following values:");
        //System.out.println(Arrays.toString(appleJacks));

        System.out.println("******************************************************************************");
        System.out.println("**\tA List is a simple collection.");
        System.out.println("**\t\t1) Duplicates are allowed.");
        System.out.println("**\t\t2) List items are not sorted.");
        System.out.println("**\t\t3) List items can be accessed by index number.");
        System.out.println("******************************************************************************");

        //Copy the AppleJacks string into an the ArrayList
        ArrayList listDemo = new ArrayList(appleJacks.length);
        for (int i = 0; i < appleJacks.length; i++) {
            listDemo.add(appleJacks[i]);
        }

        System.out.println("LIST/ArrayList RESULT:\n");
        System.out.format("Here is the resulting ArrayList (listDemo): %s\n", listDemo.toString());
        System.out.println("Point 1) Because duplicates are allowed, the finished list contains 2 A's and 2 P's.");
        System.out.println("Point 2) The list has not been automatically sorted");
        System.out.println("Point 3) We can access the array list using an iterator.");
        System.out.format("\tExample 3a:  listDemo.get(0)=%s\n", listDemo.get(0));
        System.out.format("\tExample 3b:  listDemo.get(4)=%s\n", listDemo.get(4));
        System.out.format("\tExample 3c:  listDemo.get(6)=%s\n", listDemo.get(6));
        Util.Util.promptEnterKey();
    }

    public void DemoHashSet() {
        System.out.println("\n\n\n\n\n\n******************************************************************************");
        System.out.println("**\tA HashSet organizes elements by value and cannot be used to reconstruct the original list.");
        System.out.println("**\t\t1) Duplicates are removed or not retained.");
        System.out.println("**\t\t2) Set items are not sorted in a HashSet).");
        System.out.println("**\t\t3) Set items are accessed by value rather than iteration index.");
        System.out.println("******************************************************************************");
        HashSet setDemo = new HashSet();
        for (int i = 0; i < appleJacks.length; i++) {
            setDemo.add(appleJacks[i]);
        }
        HashSet setDemo2 = new HashSet(riceCrispies.length);
        for (int i = 0; i < riceCrispies.length; i++) {
            setDemo2.add(riceCrispies[i]);
        }

        System.out.println("HASHSET RESULT:\n");
        System.out.format("Here is the resulting HashSet (appleJacks): %s\n", setDemo.toString());
        System.out.format("Here is the resulting HashSet (riceCrispies): %s\n", setDemo2.toString());
        System.out.println("Point 1) Because duplicates are NOT allowed, the finished list does not contain 2 A's or 2 P's.");
        System.out.println("Point 2) The list has NOT been automatically sorted since it is based on hash rather than tree.");
        System.out.println("Point 3) We can check for elements in the set by using .contains.");
        System.out.format("\tExample 3a:  appleJacks contains('A')=%s\n", setDemo.contains("A".charAt(0)));
        System.out.format("\tExample 3b:  appleJacks contains('X')=%s\n", setDemo.contains("X".charAt(0)));
        System.out.println("Point 4) Because these are sets, we can use the union, intersection, and difference properties to compare sets.");

        // Create intersection which contains data from both sets.
        Set<Character> intersection = new HashSet<>(setDemo);
        //Perform an intersection of numSet1 and numSet2.
        intersection.retainAll(setDemo2);
        System.out.format("\tExample 4a:  appleJacks intersecting  riceCrispies is %s\n", intersection.toString());

        //Create a difference set with characters from appleJacks that are not in riceCrispies
        Set<Character> difference = new HashSet<>(setDemo);
        //Find the difference between setDemo and setDemo2.
        difference.removeAll(setDemo2);
        System.out.format("\tExample 4b:  appleJacks difference to riceCrispies is %s\n", difference.toString());

        //Create a difference set with characters from appleJacks that are not in riceCrispies
        difference = new HashSet<>(setDemo2);
        //Find the difference between setDemo and setDemo2.
        difference.removeAll(setDemo);
        System.out.format("\tExample 4c:  riceCrispies difference to appleJacks is %s\n", difference.toString());

        Util.Util.promptEnterKey();
    }

    public void DemoMap() {
        System.out.println("\n\n\n\n\n\n******************************************************************************");
        System.out.println("**\tA TreeMap or HashMap organizes elements by value pair.");
        System.out.println("**\t\t1) All key values must be unqiue for a given value.");
        System.out.println("**\t\t2) Map items ARE sorted (in a TreeMap, but not in a HashMap).");
        System.out.println("**\t\t3) Map items are accessed by key rather than iteration index.");
        System.out.println("******************************************************************************");
        TreeMap<Integer, String> mapDemo = new TreeMap<>();

        mapDemo.put(1, "Dan");
        mapDemo.put(2, "Steve");
        mapDemo.put(3, "Stacie");

        System.out.println("TREEMAP RESULT:  Using mapDemo.add(key,value), we now have a map demo object containing 3 employee ID's and names.");
        System.out.format("Here is the resulting treeMap: %s\n", mapDemo.toString());
        System.out.format("\tExample 1a:  Showing name of employee 1 using mapDemo.get(1)=%s\n", mapDemo.get(1));
        System.out.format("\tExample 1b:  Showing name of employee 2 using mapDemo.get(2)=%s\n", mapDemo.get(2));
        System.out.format("\tExample 1c:  Showing name of employee 3 using mapDemo.get(3)=%s\n", mapDemo.get(3));

        Util.Util.promptEnterKey();
    }

    public void DemoQueueFIFO() {
        System.out.println("\n\n\n\n\n\n******************************************************************************");
        System.out.println("**\tA queue can be used to manage items in a FIFO fashion.");
        System.out.println("**\t\t1) Uniqueness is not enforced.");
        System.out.println("**\t\t2) Items are sorted only by the sequence in which they are added to the queue.");
        System.out.println("**\t\t3) Only the first items in the queue are readily accessed.");
        System.out.println("******************************************************************************");
        Queue<String> queueDemo = new LinkedList<>();

        System.out.println("LinkedList/FIFO Queue:  Adding Dan, Steve, and Stacie to the queue in that order.");

        queueDemo.add("Dan");
        queueDemo.add("Steve");
        queueDemo.add("Stacie");

        System.out.println("LinkedList/Queue RESULT:  Using queueDemo.add(value), we now have a queue object containing 3 employees.");
        System.out.format("Here is the resulting LinkedList: %s\n", queueDemo.toString());
        System.out.format("\tExample 1a:  The first name dequeued using queueDemo.poll() is %s\n", queueDemo.poll());
        System.out.format("\tExample 1b:  The next name dequeued using queueDemo.poll() is %s\n", queueDemo.poll());
        System.out.format("\tExample 1c:  The next name dequeued using queueDemo.poll() is %s\n", queueDemo.poll());
        System.out.println("Since the names came out of the queue in the order they were added, this is a successful FIFO test.");

        Util.Util.promptEnterKey();
    }
    public void DemoQueueLIFO() {
        System.out.println("\n\n\n\n\n\n******************************************************************************");
        System.out.println("**\tA LinkedList can be used to manage items in a FIFO or LIFO fashion.");
        System.out.println("**\t\t1) Uniqueness is not enforced.");
        System.out.println("**\t\t2) Items are sorted only by the sequence in which they are added to the queue.");
        System.out.println("**\t\t3) Only the first or last items in the queue are readily accessed");
        System.out.println("******************************************************************************");

        LinkedList<String> queueDemoLIFO = new LinkedList<>();
        queueDemoLIFO.add("Dan");
        queueDemoLIFO.add("Steve");
        queueDemoLIFO.add("Stacie");

        System.out.println("LinkedList/Queue RESULT:  Using queueDemo.add(value), we now have a queue object containing 3 employees.");
        System.out.format("Here is the resulting LinkedList: %s\n", queueDemoLIFO.toString());
        System.out.format("\tExample 1a:  The first name dequeued using queueDemoLIFO.removeLast() is %s\n", queueDemoLIFO.removeLast());
        System.out.format("\tExample 1b:  The next name dequeued using queueDemoLIFO.removeLast() is %s\n", queueDemoLIFO.removeLast());
        System.out.format("\tExample 1c:  The next name dequeued using queueDemoLIFO.removeLast() is %s\n", queueDemoLIFO.removeLast());
        System.out.println("Since the names came out of the queue in reverse order, this is a successful LIFO test.");

        Util.Util.promptEnterKey();
    }

    public void DemoTreeSet() {
        System.out.println("\n\n\n\n\n\n******************************************************************************");
        System.out.println("**\tA TreeSet organizes elements by value and cannot be used to reconstruct the original list.");
        System.out.println("**\t\t1) Duplicates are not retained.");
        System.out.println("**\t\t2) Set items ARE sorted.");
        System.out.println("******************************************************************************");
        TreeSet setDemo = new TreeSet();
        for (int i = 0; i < appleJacks.length; i++) {
            setDemo.add(appleJacks[i]);
        }
        System.out.println("TREESET RESULT:");
        System.out.format("Here is the resulting ArrayList (appleJacks): %s\n", setDemo.toString());
        System.out.println("Point 1) Because duplicates are NOT allowed, the finished list does not contain 2 A's or 2 P's.");
        System.out.println("Point 2) The list has been automatically sorted, with the space between APPLE JACKS coming first.");
        System.out.println("Point 3) We can check for elements in the Treeset by using .contains.");
        System.out.format("\tExample 3a:  setDemo.contains('A')=%s\n", setDemo.contains("A".charAt(0)));
        System.out.format("\tExample 3b:  setDemo.contains('J')=%s\n", setDemo.contains("J".charAt(0)));
        System.out.format("\tExample 3c:  setDemo.contains('X')=%s\n", setDemo.contains("X".charAt(0)));
        Util.Util.promptEnterKey();
    }

    public void DemoMapGrades() {
        System.out.println("\n\n\n\n\n\n******************************************************************************");
        System.out.println("**\tA TreeMap organizes elements by the key in a value pair.");
        System.out.println("**\tIn this example we will grade a map of minimal acceptable scores to get a grade.  ");
        System.out.println("**\tA random number generator then runs, and the map is used to locate the best score.");
        System.out.println("******************************************************************************");
        //Note that we are defining this treemap in reverseOrder so that the highest scores come first.   This will make the application faster if a majority of students have better grades.
        TreeMap<Integer, String> mapDemo = new TreeMap<>(Collections.reverseOrder());

        mapDemo.put(92, "A");
        mapDemo.put(89, "A-");
        mapDemo.put(86, "B+");
        mapDemo.put(82, "B");
        mapDemo.put(79, "B-");
        mapDemo.put(76, "C+");
        mapDemo.put(72, "C");
        mapDemo.put(69, "C-");
        mapDemo.put(66, "D+");
        mapDemo.put(62, "D");
        mapDemo.put(59, "D-");
        mapDemo.put(0, "F");

        System.out.format("Here is the resulting treeMap of minimum scores and resulting grades: %s\n", mapDemo.toString());
        System.out.format("\tExample 1a:  Now searching for the appropriate grade for random scores.\n");
        for (int i=0;i<5;i++) {
            int grade = 50 + (int)(Math.random()*50);  //This will give us a random grade between 50 and 100.
            for (Map.Entry<Integer, String> entry : mapDemo.entrySet()) {
                //System.out.format ("comparing grade %d to key %d\n",grade,entry.getKey());
                if (entry.getKey() < grade) {
                    // return first value with a key greater than the inputted value
                    System.out.format("\tFor a scored percentage of %d, your grade is %s\n", grade, entry.getValue());
                    break;
                }

            }
        }
        Util.Util.promptEnterKey();

    }

}
