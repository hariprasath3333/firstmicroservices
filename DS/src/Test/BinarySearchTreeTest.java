package Test;

import Tree.BinarySearchTree;

public class BinarySearchTreeTest {
	
	public static void main(String args[]) {
		BinarySearchTreeTest binarySearchTreeTest = new BinarySearchTreeTest();
		//binarySearchTreeTest.testInsert();
		binarySearchTreeTest.testDelete();
	}

	
	public void testInsert() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		
		bst.print();
		
	}
	
	public void testDelete() {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(40);
		bst.insert(50);
		
		bst.print();
		System.out.println("After Delete");
		bst.delete(30);
		bst.delete(40);
		
		bst.print();
	}
	
}
