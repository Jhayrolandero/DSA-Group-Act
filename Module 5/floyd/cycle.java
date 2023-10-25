import java.util.LinkedList;
import java.util.Scanner;

//Although Java doesn't feature pointers explicitly, 
//the required output of this activity can be done with the usage of the list index and value for a pre-declared map.

public class cycle {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        // Declare cycle map
        list.add(0, 6);
        list.add(1, 6);
        list.add(2, 0);
        list.add(3, 1);
        list.add(4, 4);
        list.add(5, 3);
        list.add(6, 3);
        list.add(7, 4);
        list.add(8, 0);

        // Prompt user for location of first sequence.
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose an element to begin the sequence from: ");
        int elem = scan.nextInt();
        int count = 0, hare = elem, tortoise = elem;

        // Find cycle.
        System.out.println("Hare: " + hare + "     Tortoise: " + tortoise);

        // Traverse the linkedlist
        while (list.get(hare) != null) {
            // One step for tortoise and hare
            // list.get essentially replaces current index with the value it represents int
            // the list as the new index.
            tortoise = list.get(tortoise);
            hare = list.get(hare);

            // Another step for hare
            if (list.get(hare) != null) {
                hare = list.get(hare);
            } else {
                break;
            }

            // Check if tortoise and hare finds each other per iteration
            if (tortoise == hare) {
                System.out.println("Hare: " + hare + "     Tortoise: " + tortoise);
                System.out.println("A cycle has been found with the given starting point.");
                System.exit(0);
            }
            System.out.println("Hare: " + hare + "     Tortoise: " + tortoise);
        }
        System.out.println("A no cycle has been found with the given starting point.");
    }
}
