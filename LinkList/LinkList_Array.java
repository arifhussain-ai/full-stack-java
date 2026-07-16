package Java.LinkList;


public class LinkList_Array {

class Node{
	String data;
	Node next;
	
	Node(String value){
		data = value;
		next = null;
	}
}

	Node head;
	
	public void appendElement(String data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = newNode;
	}
	
	public void lengthCount() {
		int count = 0;
		Node temp = head;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		System.out.println("\nLength of List: "+count);
	}
	
	public boolean search(String key) {
		while(head != null) {
			if (head.data.equals(key))
				return true;
			head = head.next;
		}
		return false;
			
	}
	
	public void show() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}

	
	public static void main(String[] args) {
		LinkList_Array list = new LinkList_Array();
		list.appendElement("10");
		list.appendElement("20");
		list.appendElement("30");
		list.appendElement("40");
		list.show();
		list.lengthCount();
		System.out.println(list.search("20"));
	}
}
