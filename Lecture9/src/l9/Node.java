package l9;

public class Node {
	
	public int element;
	public Node next;
	
	public static int length(SinglyLinkedList list) {
		return 0;
	}
	
	public static int get(SinglyLinkedList list, int position) { 
		assert list != null && position < length(list);
		
		int index = 0;
		Node current = list.head;
		while( index < position) {
			index++;
			current = current.next;
		}
		return current.element;
	}

	public static void add(SinglyLinkedList list, int position, int element) {
		assert list != null && position < list.length;
		
		Node node = new Node();
		node.element = element;
		if( list.head == null) {
			list.head = node;
		} else {
			int index = 0;
			Node previous = list.head;
			while( index < position -1) {
				index++;
				previous = previous.next;
			}
			node.next = previous.next;
			previous.next = node;
		}
	}
}
