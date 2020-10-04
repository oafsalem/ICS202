//import LinkedList.SLL;
//import java.util.LinkedList.SLLNode;
import java.util.LinkedList;

public class LinkedListApplication {
	public static void main(String[] args) {
		SLL<Integer> myList = new SLL<Integer>();
		for(int i = 0; i < 5; i++)
			myList.addToHead( i);

		myList.printAll();
		System.out.println();
		System.out.print("Length = " +myList.length());
		myList.insertAfter(5, 4);
		System.out.println();
		myList.printAll();
		myList.insertAfter(-1, 0);
		System.out.println();
		myList.printAll();
		myList.deleteAfter(4);
		System.out.println();
		myList.printAll();
		myList.deleteAfter(0);
		System.out.println();
		myList.printAll();
		System.out.println();
		System.out.print("Length = " +myList.length());
	}
}