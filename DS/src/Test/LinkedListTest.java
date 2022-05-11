package Test;

import LinkedList.LinkedList;

public class LinkedListTest {
	
	public static void main(String args[]) {
		LinkedListTest test = new LinkedListTest();
		//test.testInsert();
		//test.testInsertAtPosition();
		//test.testDelete();
		test.testDeleteByPosition();
	}
	
	public void testInsert() {
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		//list.print();
		list.printReversedList();
	}
	
	public void testInsertAtPosition() {
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30,2);
		list.insert(50);
		list.insert(40,4);
		list.insert(60, 6);
		list.insert(70, 1);
		
		//list.print();
		list.printReversedList();
	}
	
	public void testDelete() {
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		list.print();
		System.out.println("After Delete");
		list.delete(30);
		list.delete(10);
		list.delete(50);
		list.print();
	}
	
	public void testDeleteByPosition() {
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		list.print();
		System.out.println("After Delete");
		list.deleteBasedOnPosition(3);
		list.deleteBasedOnPosition(1);
		list.deleteBasedOnPosition(3);
		list.print();
	}
	

}
