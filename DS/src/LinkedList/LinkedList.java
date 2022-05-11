package LinkedList;

public class LinkedList {
	Node head = null;
	Node tail = null;
	int size = 0;
	
	public LinkedList(){
		
	}
	
	public LinkedList(int data){
		insert(data);
	}
	
	public void insert(int d){
		Node node = createNewNode(d);
		size++;
		if(head == null) {
			head = node;
			tail = node;
		}else if(head == tail) {
			tail = node;
			tail.next = null;
			tail.prev = head;
			
			head.next = tail;
			head.prev = null;
		}else {
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
	}
	
	private Node createNewNode(int d) {
		Node node = new Node (d);
		node.prev=null;
		node.next=null;
		return node;
	}
	
	private void insertAtBegining(Node node) {
		head.prev=node;
		node.next=head;
		head=node;
	}
	
	
	private void insertAtEnd(Node node) {
		node.prev = tail;
		tail.next = node;
		tail=node;
	}
	
	public void insertAtEnd(int d) {
		Node node = createNewNode(d);
		size++;
		insertAtEnd(node);
	}
	
	public void insertAtBeginning(int d) {
		Node node = createNewNode(d);
		size++;
		insertAtBegining(node);
	}
	
	private boolean validteBeforeInsert(int position) {

		if(position <=0) {
			System.out.println("Position has to be greater than 0");
			return false;
		}
		
		if(position > (size+1)) {
			System.out.println("Cannot insert at position:"+ position);
			System.out.println("Total size of list as of now is :"+size+" so you can insert anywhere between 1 - "+ (size+1) );
			return false;
		}
		return true;
	}
	
	public void insert(int d, int position) {
		boolean validationSuccess = validteBeforeInsert(position);
		if(!validationSuccess) {
			return;
		}
			
		Node node = createNewNode(d);
		size++;
		
		if(position==1) {
			insertAtBegining(node);
			return;
		}
		
		if(position== size) {
			insertAtEnd(node);
			return;
		}
		
		Node temp = head; 
		for(int i=1; i<position; i++) {
				temp = temp.next;
		}
		node.prev = temp.prev;
		node.next=temp;
		temp.prev.next=node;
		temp.prev=node;
	}
	
	private void deleteMiddleElement(Node temp) {
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp.prev = null;
		temp.next = null;
		size--;
	}
	
	
	public void deleteBasedOnPosition(int position) {
		boolean validationSuccess = validateBeforeDelete(position);
		if(!validationSuccess) {
			return;
		}
		
		if(position == 1) {
			deleteFirstElement(head);
			return;
		}
		
		if(position == size) {
			deleteLastElement(tail);
			return;
		}
		
		Node temp = head;
		for(int i=1; i<position ;i++) {
			temp = temp.next;
		}
		
		deleteMiddleElement(temp);
	}
	
	public void delete(int data) {
		int elementPresentAt = isElementPresent(data);
		if(elementPresentAt == -1) {
			return;
		}
		
		if(elementPresentAt == 1) {
			deleteFirstElement(head);
			return;
		}
		
		if(elementPresentAt == size) {
			deleteLastElement(tail);
			return;
		}
		
		Node temp = head;
		for(int i=1; i<elementPresentAt; i++) {
			temp = temp.next;
		}
		
		deleteMiddleElement(temp);
		
	}
	
	public int isElementPresent(int data) {
		if(isListEmpty()) {
			return -1;
		}
		
		Node temp = head;
		for(int i =1; i<=size; i++) {
			if(temp.data == data) {
				return i;
			}
			temp = temp.next;
		
		}
		return -1;
	}
	
	private boolean isListEmpty() {
		if(head==null) {
			System.out.println("The list is empty");
			return true;
		}
		return false;
	}
	
	private boolean validateBeforeDelete(int position) {
		if(isListEmpty()) {
			return false;
		}
		
		if(position <=0 || position >size) {
			System.out.println("Invalid position");
			return false;
		}
		
		return true;
	}
	
	private void deleteLastElement(Node node) {
		tail = node;
		tail.prev.next = null;
		tail = tail.prev;
		node.prev = null;
		size--;
	}
	
	private void deleteFirstElement(Node node) {
		head = node;
		head.next.prev=null;
		head = head.next;
		node.next=null;
		size--;
	}

	public void print() {
		if(head==null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	public void printReversedList() {
		if(head==null) {
			System.out.println("List is empty");
			return;
		}
		Node temp = tail;
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.prev;
		}
	}
	
	
	class Node {
		Node next;
		Node prev;
		int data;
		
		Node(){
			
		}
		
		Node(int d){
			data = d;
			prev = next = null;
		}
		
	}

}
