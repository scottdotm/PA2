package PA2;

import java.util.Arrays;

public class TestCorrectness {

	public static void testBinarySearchMethods() {

		System.out.println("****************** Test Binary Search Applications Correctness ****************** \n");
		int A[] = { 1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 27, 39, 39, 39 };
		System.out.println("*** Counting the number of occurrences of key ***\n");
		System.out.println("Array is " + Arrays.toString(A));
		System.out
				.println("Number of occurrences of 1 is " + BinarySearchApplications.countNumberOfKeys(A, A.length, 1));
		System.out.println(
				"Number of occurrences of 14 is " + BinarySearchApplications.countNumberOfKeys(A, A.length, 14));
		System.out.println(
				"Number of occurrences of 39 is " + BinarySearchApplications.countNumberOfKeys(A, A.length, 39));
		System.out
				.println("Number of occurrences of 7 is " + BinarySearchApplications.countNumberOfKeys(A, A.length, 7));
		System.out.println(
				"Number of occurrences of 100 is " + BinarySearchApplications.countNumberOfKeys(A, A.length, 100));
		System.out.println(
				"Number of occurrences of -88 is " + BinarySearchApplications.countNumberOfKeys(A, A.length, -88));
		System.out.println(
				"Number of occurrences of 16 is " + BinarySearchApplications.countNumberOfKeys(A, A.length, 16));

		System.out.println("\n*** Finding Predecessor ***\n");
		int B[] = { 1, 0, 39, 47, 36, 12, 6 };
		System.out.println("Array is " + Arrays.toString(A));
		for (int i = 0; i < B.length; i++) {
			int key = B[i];
			int x = BinarySearchApplications.predecessor(A, A.length, key);
			if (x >= 0)
				System.out.println("Predecessor of " + B[i] + " is " + A[x]);
			else
				System.out.println("Predecessor of " + B[i] + " is not defined.");
		}

		System.out.println("\n*** Peak Finding ***\n");
		int C_1[] = { 15, 18, 21, 25, 29, 31, 35, 23, 14, 9, 1, -1 };
		System.out.println("Array is " + Arrays.toString(C_1) + ". Max is at index "
				+ BinarySearchApplications.findPeak(C_1, C_1.length));
		int C_2[] = { 31, 35, 23, 14, 9, 1, -1 };
		System.out.println("Array is " + Arrays.toString(C_2) + ". Max is at index "
				+ BinarySearchApplications.findPeak(C_2, C_2.length));
		int C_3[] = { 31, 35, 37, 39 };
		System.out.println("Array is " + Arrays.toString(C_3) + ". Max is at index "
				+ BinarySearchApplications.findPeak(C_3, C_3.length));
		int C_4[] = { 36, 35, 32, 29 };
		System.out.println("Array is " + Arrays.toString(C_4) + ". Max is at index "
				+ BinarySearchApplications.findPeak(C_4, C_4.length));
	}

	private static LinkedList part1LinkedList() {

		LinkedList list = new LinkedList();

		list.insertAtFront(5);
		System.out.print("Inserting 5 at front. Current list: ");
		list.printList();

		list.insertAtEnd(32);
		System.out.print("Inserting 32 at end. Current list: ");
		list.printList();

		list.insertAtFront(16);
		System.out.print("Inserting 16 at front. Current list: ");
		list.printList();

		list.insertAfter(list.getNodeAt(1), 61);
		System.out.print("Inserting 61 after position 1. Current list: ");
		list.printList();

		list.insertAfter(list.tail, 99);
		System.out.print("Inserting 99 after tail. Current list: ");
		list.printList();

		list.deleteAfter(list.getNodeAt(1));
		System.out.print("Deleting after position 1. Current list: ");
		list.printList();

		list.deleteAfter(list.getNodeAt(2));
		System.out.print("Deleting after position 2. Current list: ");
		list.printList();

		System.out.print("Trying to delete after position 2: ");
		list.deleteAfter(list.getNodeAt(2));

		list.insertAtFront(5);
		System.out.print("Inserting 5 at front. Current list: ");
		list.printList();

		list.insertAtEnd(32);
		System.out.print("Inserting 32 at end. Current list: ");
		list.printList();

		list.insertAtFront(16);
		System.out.print("Inserting 16 at front. Current list: ");
		list.printList();

		list.insertAtFront(8);
		System.out.print("Inserting 8 at front. Current list: ");
		list.printList();

		list.insertAtEnd(21);
		System.out.print("Inserting 21 at end. Current list: ");
		list.printList();

		list.insertAtEnd(50);
		System.out.print("Inserting 50 at end. Current list: ");
		list.printList();

		list.insertAtEnd(32);
		System.out.print("Inserting 32 at end. Current list: ");
		list.printList();

		list.insertAtFront(66);
		System.out.print("Inserting 66 at front. Current list: ");
		list.printList();

		list.insertAtFront(66);
		System.out.print("Inserting 66 at front. Current list: ");
		list.printList();

		return list;
	}

	private static void part2LinkedList(LinkedList list) {
		System.out.print("Trying to remove duplicates from: ");
		if (!list.removeDuplicatesSorted())
			System.out.println("Cannot remove duplicates unless sorted!");
		else
			System.out.println("You have messed up something!");

		System.out.print("Sorted List: ");
		list.selectionSort();
		list.printList();

		System.out.print("Remove duplicates: ");
		if (list.removeDuplicatesSorted())
			list.printList();
		else
			System.out.println("You have messed up something!");

		System.out.print("Push odd indexes to the back: ");
		list.pushOddIndexesToTheBack();
		list.printList();

		list.insertAtFront(-12);
		System.out.print("Inserting -12 at front. Current list: ");
		list.printList();

		System.out.print("Push odd indexes to the back: ");
		list.pushOddIndexesToTheBack();
		list.printList();
		
		System.out.print("Reversing List: ");
		list.reverse();
		list.printList();
	}

	private static void testLinkedListCorrectness() {
		System.out.println("****************** Test Linked List Correctness ****************** \n");
		LinkedList list = part1LinkedList();
		System.out.println();
		part2LinkedList(list);
	}

	private static void testDynamicArrayCorrectness() {
		DynamicArray da = new DynamicArray(1);
		System.out.println("****************** Test Dynamic Array Correctness ****************** \n");
		for (int i = 0; i < 17; i++) {
			da.insertAtEnd(i * 5);
			System.out.print(da.toString());
			System.out.println(" Num elements: " + da.numElements + ", Length: " + da.length);
		}
		System.out.println();
		for (int i = 0; i < 17; i++) {
			da.deleteLast();
			System.out.print(da.toString());
			System.out.println(" Num elements: " + da.numElements + ", Length: " + da.length);
		}
	}

	public static void main(String[] args) throws Exception {

		testBinarySearchMethods();
		System.out.println();
		testLinkedListCorrectness();
		System.out.println();
		testDynamicArrayCorrectness();
	}
}
