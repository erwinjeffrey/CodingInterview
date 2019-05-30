package com.coding.interviw.linkedList;

public class Node {

	int data;
	Node next;
	
	Node(){
	}
	Node(int data){
		this.data = data;
	}
	
	public void displayNode(){
		System.out.println("{" + data + "}");
	}
}
