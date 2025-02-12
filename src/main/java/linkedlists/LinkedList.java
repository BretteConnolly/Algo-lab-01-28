package linkedlists;
import java.util.Iterator;

/** A class representing a singly linked list. */
public class LinkedList {
	private Node head, tail;

	/** Constructor */
	public LinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Creates a new node with the given element and adds it to the back of the
	 * list
	 */
	public void append(int elem) {
		Node newNode = new Node(elem);
		if (head == null) {head = tail = newNode;}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	/**
	 * Insert a new node with the given element in front of the linked list
	 * @param elem element
	 */
	public void insertAtFront(int elem) {
		Node newNode = new Node(elem);
		if (head == null) {
			head = tail = newNode;
		}
		else {
			newNode.setNext(head);
			head = newNode;
		}
	}


	/** Prints all the nodes in the linked list */
	public void printNodes() {
		Node current = head;
		while (current != null) {
			System.out.print(current.getElem() + "->");
			current = current.next();
		}
		System.out.println();
	}

	/**
	 * Insert a new node with the given element at index i
	 * @param i index
	 * @param elem element
	 */
	public void insertAtIndex(int i, int elem) {
		if (head == null) {System.out.println("Empty list");}
		else if (i == 0) {insertAtFront(elem);}
		else {
			Node newNode = new Node(elem);
			Node current = head;
			int count = 0;
			while (current != null && count < i - 1){
				current = current.next();
				count++;
			}
			if (current == null) {System.out.println("Invalid index");}
			else {
				newNode.setNext(current.next());
				current.setNext(newNode);
				if (current == tail) {tail = newNode;}
			}
		}

	}

	/**
	 * Returns a reference to the middle node
	 * @return reference to the middle node
	 */
	public Node getMiddleNode() {
		Node slow = head;
		Node fast = head;
		while (fast.next().next() != null) {
			slow = slow.next();
			fast = fast.next().next();
		}
		return slow;
	}

	/**
	 * Remove the node with the given element
	 * @param elem element
	 */
	public void removeNode(int elem) {
		Node current = head;
		while (current.next().getElem() != elem) {current = current.next();}
		current.setNext(current.next().next());
	}

	public Node head() {return head;}

	public Node tail() {return tail;}

	public Node getKthFromEnd(int k) {
		if (head == null) {
			System.out.println("Empty list");
			return null;
		}
		Node fast = head;
		Node slow = head;
		int count = 0;
		while(fast != null && count < k){
			fast = fast.next();
			count++;
		}
		if (fast == null) {
			System.out.println("Index is invalid");
			return null;
		}
		while (fast != tail) {
			fast = fast.next();
			slow = slow.next();
		}
		return slow;
	}

	public Iterator <Node> iterator () {return new MyLinkedListIterator();}

	public class MyLinkedListIterator implements Iterator <Node> {
		private Node curr;

		public MyLinkedListIterator() {curr = head;}

		public boolean hasNext() {return curr != null;}

		public Node next() {
			Node temp = curr;
			if (hasNext()) {
				curr = curr.next();
				return curr;
			}
			return null;
		}
	}
}
