package com.coding.interviw.linkedList;

public class SingleLinkedList {

	private Node first;
	private Node last;
	private int count = 0;
	
	public SingleLinkedList(){}
	
	public void insertFirst(int data){
		Node newNode = new Node(data);
		newNode.next = first;
		first = newNode;
		
		if(count == 0){
			count++;
			last = first;
		}
	}
	
	public Node deleteFirst(){
		Node temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		System.out.println("List (list --> last)");
		Node current = first;
		while(current != null){
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	public void insertLastNew(int data){
		Node newNode = new Node(data);
		last.next = newNode;
	}
	
	public void insertLast(int data){
		Node current = first;
		while(current != null){
			current = current.next;
		}
		Node newNode = new Node(data);
		current.next = newNode;
	}
	public boolean isEmpty(){
		return first == null;
	}
	
	public Node getFirst(){
		return first;
	}
}
