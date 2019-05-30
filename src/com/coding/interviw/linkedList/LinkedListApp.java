package com.coding.interviw.linkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LinkedListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleLinkedList mylist = new SingleLinkedList();
		mylist.insertFirst(100);
		mylist.insertFirst(50);
		mylist.insertFirst(51);
		mylist.insertFirst(99);
		mylist.insertFirst(98);
		
		mylist.displayList();
		
		//removeDupsBetter(mylist.getFirst());
		//System.out.println(nthToLast(mylist.getFirst(),4).data);
		//deleteMidNodeBetter(mylist.getFirst().next.next);
		partionBetter(mylist.getFirst(),52);
		
		SingleLinkedList listOne = new SingleLinkedList();
		listOne.insertFirst(7);
		listOne.insertFirst(1);
		listOne.insertFirst(6);
		
		SingleLinkedList listTwo = new SingleLinkedList();
		listTwo.insertFirst(4);
		listTwo.insertFirst(5);
		listTwo.insertFirst(9);
		listTwo.insertFirst(2);
		
		
		addListMuchBetter(listOne.getFirst(),listTwo.getFirst());
		SingleLinkedList listPalin = new SingleLinkedList();
		listPalin.insertFirst(0);
		listPalin.insertFirst(1);
		listPalin.insertFirst(5);
		listPalin.insertFirst(1);
		listPalin.insertFirst(0);
		System.out.println("isPalindrome: " +isPalindrome3(listPalin.getFirst()));

		// findIntersection2 Data
		Node first = new Node(3);
		Node node2 = new Node(1);
		Node node3 = new Node(5);
		Node node4 = new Node(9);
		Node node5 = new Node(7);
		Node node6 = new Node(2);
		Node node7 = new Node(1);
		
		first.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		Node second = new Node(4);
		Node node9 = new Node(6);
		
		second.next = node9;
		// intersect here
		node9.next = node5;
		
		
		findIntersection2(first,second);

		// LoopDetection Data
		Nodee nodeA = new Nodee("A");
		Nodee nodeB = new Nodee("B");
		Nodee nodeC = new Nodee("C");
		Nodee nodeD = new Nodee("D");
		Nodee nodeE = new Nodee("E");

		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		nodeD.next = nodeE;
		nodeE.next = nodeD;


		loopDetection(nodeA);
		int a = 0;
				
	}
	
	/* Remove Dups
	 * 
	 */
	
	// Solution #1
   private static Node removeDups(SingleLinkedList linkedList){
	   List<Integer> list = new ArrayList();
	   System.out.println("before removal: ");
	   linkedList.displayList();
	   
	   Node result = new Node();
	   Node current = linkedList.getFirst();
	   while(current != null){
		   if(!list.contains(current.data)){
			   Node newNode = new Node(current.data);
			   newNode.next = result;
			   result = newNode;
			   
			   list.add(current.data);
		 }
		   current = current.next;
	   }
	   return result;
   }
	
 // Solution #2
   private static Node removeDupsBetter(Node node){
	   Node current = node;
	   while(current != null){
		   // Remove all future nodes that have the same value
		   Node runner = current;
		   while(runner.next != null){
			   if(runner.next.data == current.data){
				   runner.next = runner.next.next;
			   }else{
				   runner = runner.next;
			   }
		   }
		   current = current.next;
	   }
	   return node;
   }
   
   /* Return Kth to Last
    * 
    */
   
   // Solution 1
   private static int printKthToLast(Node head, int k){
	   if(head == null){
		   return 0;
	   }
	   int index = printKthToLast(head.next,k)+1;
	   if(index == k){
		   System.out.println(k + "th to last node is " + head.data);
	   }
	   return index;
   }
   
   // Solution 2
   static Node  nthToLast(Node head, int k){
	   Node p1 = head;
	   Node p2 = head;
	   
	   //Move p1 k nodes into the list
	   for (int i = 0; i < k; i++) {
		 if(p1 == null){
			 return null;
		 }
		 p1 = p1.next;
	   }
	   
	   // Move them at the same pace. When p1 hits the end, p2 will be at the right element.
	   while(p1 != null){
		  p1 = p1.next;
		  p2 = p2.next;
	   }
	   return p2;
   }
    
   // given the middle node delete it
   static boolean deleteMidNodeBetter(Node node){
	   if(node == null || node.next == null){
		   return false;
	   }
	   Node next = node.next;
	   node.data = next.data;
	   node.next = next.next;
	   return true;
   }
   
   /* Partition
    * 
    */
   
   // Solution 1
   static Node partition(Node node, int partition){
	   
	   Node current = node;
	   Node lessThanPivot = new Node();
	   Node greaterThanPivot = new Node();
	  
	   while(current != null){
		   
		  if(current.data < partition){
			 Node newNode = new Node(current.data); 
			 newNode.next = lessThanPivot;
			 lessThanPivot = newNode;
		  }else{
			  Node newNode = new Node(current.data); 
			  newNode.next = greaterThanPivot;
			  greaterThanPivot = newNode;
		  }
		   current = current.next;
	   }
	   // merging both
	   mergingLinkeList(lessThanPivot, greaterThanPivot);
	   return lessThanPivot;
   }
   private static void mergingLinkeList(Node lessThanPivot, Node greaterThanPivot){
	   Node current = greaterThanPivot;
	   while(current != null){
		   Node newNode = new Node();
		   
		   Node lessPivot = lessThanPivot;
		   while(lessPivot.next != null){
			  lessPivot = lessPivot.next; 
		   }
		   lessPivot.data = current.data;
		   lessPivot.next = newNode;
		   
		  
		   current = current.next;
	   }
   }
   
   // Solution 2
   private static Node partitionBook(Node node, int x){
	   Node beforeStart = null;
	   Node beforeEnd = null;
	   Node afterStart = null;
	   Node afterEnd = null;
	   
	   //Partition list
	   while(node != null){
		   Node next = node.next;
		   node.next = null;
		   if(node.data < x){
			   //insert node into end of before list
			   if(beforeStart == null){
				   beforeStart = node;
				   beforeEnd = beforeStart;
			   }else{
				   beforeEnd.next = node;
				   beforeEnd = node;
			   }
		   }else{
			   //Insert node into end of after list
			   if(afterStart == null){
				   afterStart = node;
				   afterEnd = afterStart;
			   }else{
				   afterEnd.next = node;
				   afterEnd = node;
			   }
		   }
		   node = next;
	   }
	   if(beforeStart == null){
		   return afterStart;
	   }
	   // Merge before list and after list
	   beforeEnd.next = afterStart;
	   return beforeStart;
   }
   
   // Solution 3
   private static Node partionBetter(Node node, int x){
	   Node head = node;
	   Node tail = node;
	   
	   while(node != null){

		   Node next = node.next;
		   if(node.data < x){
			   //insert node at head
			   node.next = head;
			   head = node;
		   }else{
			   tail.next = node;
			   tail = node;
		   }
		   node = next;
	   }
	   tail.next = null;
	   //the head has changed, so we need to return it to the user
	   return head;
   }
   
   /* Sum Lists
    * 
    */
   
   // Solution 1
   private static Node addLists(Node listOne, Node listTwo){
	   StringBuilder listOneArr = new StringBuilder();
	   StringBuilder listTwoArr = new StringBuilder();
	   
	   Node current = listOne;
	   while(current != null){
		   listOneArr.append(current.data);
		   current = current.next;
	   }
	   
	   Node current2 = listTwo;
	   while(current2 != null){
		   listTwoArr.append(current2.data);
		   current2 = current2.next;
	   }
	   
	   int  sum = Integer.parseInt(listOneArr.reverse().toString()) + 
			   Integer.parseInt(listTwoArr.reverse().toString());
	   
	   Node result = new Node();
	   while(sum > 0){
		   Node newNode = new Node(sum % 10);
		   newNode.next = result;
		   result = newNode;
		   sum /=10;
	   }
	   return result;
   }
   
   // Solution 2
   
   //this only works when both list have the same size
   private static Node addListBetter(Node l1, Node l2, int carry){
	   if(l1 == null && l2== null && carry==0){
		   return null;
	   }
	   
	   Node result = new Node();
	   int value = carry;
	   
	   if(l1 != null){
		   value += l1.data;
	   }
	   if(l2 != null){
		   value += l2.data;
	   }
	   
	   result.data = value % 10; // Second digit of number
	   
	   //Recurse
	   if(l1 != null || l2 != null){
		   Node more = addListBetter(l1 == null ? null: l1.next, 
				                     l2 == null ? null: l2.next,
				                     value >= 0 ? 1 : 0);
		   result.next = more;
	   }
	   return result;
   }
   
   // Solution 3
   static Node addListMuchBetter(Node l1, Node l2){
	   int len1 = length(l1);
	   int len2 = length(l2);
	   
	   // Pad the shorter list with zeros
	   if(len1 < len2){
		   l1 = padList(l1,len2 - len1);
	   }else{
		   l2 = padList(l2, len1 - len2);
	   }
	   
	   // Add lists
	   PartialSum sum = addListHelper(l1, l2);
	   
	   // if there was a carry value left over, insert this at the front of the list
	   // otherwise, just return the linked list
	   if(sum.carry ==0 ){
		   return sum.sum;
	   }else{
		   Node result = insertBefore(sum.sum, sum.carry);
		   return result;
	   }
   }
   
   static PartialSum addListHelper(Node l1, Node l2){
	   if(l1== null && l2 == null){
		   LinkedListApp app = new LinkedListApp();
		   LinkedListApp.PartialSum  sum = app.new PartialSum(); 
		   return  sum;
	   }
	   
	   // Add smaller digits recursively
	   PartialSum  sum  = addListHelper(l1.next, l2.next);
	   
	   // Add carry to current data
	   int val = sum.carry + l1.data + l2.data;
	   
	   // Insert sum of current digits
	   Node full_result = insertBefore(sum.sum, val % 10);
	   
	   //Return sum so far, and the carry value
	   sum.sum = full_result;
	   sum.carry = val /10;
	   return sum;
   }
   private static Node padList(Node l1, int padding) {
	  Node head = l1;
	  for (int j = 0; j < padding; j++) {
		head = insertBefore(head, 0);
	  }
	  return head;
   }

   private static Node insertBefore(Node list, int data) {
	  Node node = new Node(data);
	  if(list != null){
		  node.next = list;
	  }
	  return node;
   }

  static int length(Node node){
	   int count = 0;
	   Node current = node;
	   while(current != null){
		   count++;
		   current = current.next;
	   }
	   return count;
   }
   class PartialSum{
	   public Node sum = null;
	   public int carry = 0;
   }
   
   
   /* Palindrome: Implement a function to check if a linked list
    * is palindrome
    */
   
   // Solution 1
   static boolean isPalindrome(Node node){
	   Node reverseOne = reverseAndClone(node);
	   return isEqual(node, reverseOne);
   }
   
   static boolean isEqual(Node one, Node two){
	   
	   while(one != null && two != null){
		   if(one.data != two.data){
			   return false;
		   }
		   one = one.next;
		   two = two.next;
	   }
	   return one==null && two==null;
   }
   static Node reverseAndClone(Node node){
	   
	   Node head = null;
	   while(node != null){
		   Node n = new Node(node.data);
		   n.next = head;
		   head = n;
		   node = node.next;
	   }
	   return head;
   }
   
   // Solution #2
   static boolean isPalindromeUsingSlowAndFashAproach(Node head){
	   Node fast = head;
	   Node slow = head;
	   
	   Stack<Integer> stack = new Stack();
	   
	   /* Push elements from first half of linked list onto stack. When fast runner
	    * (which is moving at 2x speed) reaches the end of the linked list, then
	    * know we're at the middle */
	   
	   while(fast != null && fast.next != null){
		   stack.push(slow.data);
		   slow = slow.next;
		   fast = fast.next.next;
	   }
	   
	   /* Has odd number of elements, so skip the middle element  */
	   if(fast != null){
		   slow = slow.next;
	   }
	   
	   while(slow != null){
		   int top = stack.pop().intValue();
		   
		   /*If values are different, then it's not a palindrome */
		    if(top != slow.data){
		    	return false;
		    }
		    slow = slow.next;
	   }
	   return true;
   }
   
   // Solution 3
  static boolean isPalindrome3(Node head){
	  int length = length(head);
	  Result p = isPalindromeRecurse(head, length);
	  return p.result;
  }
   
   static Result isPalindromeRecurse(Node head, int length){
	   if(head == null  ||  length <= 0 ){ // Even number of nodes
		   return new Result(head, true);
	   }else if(length == 1){  // Odd number of nodes
		   return new Result(head.next, true);
	   }
	   
	   /* Recurse on sublist. */
	   Result res = isPalindromeRecurse(head.next, length -2);
	   
	   /* If child calls are not a palindrome, pass back up
	    * a failure */
	   if(!res.result || res.node == null){
		   return res;
	   }
	   
	   // Check if matches corresponding node on other side
	   res.result = (head.data == res.node.data);
	   
	   //Return corresponding node
	   res.node = res.node.next;
	   
	   return res;
	   
   }
   
   
   /* Finding the intersecting node
    * 
    */
   
   
   // SolutionOne
   static Node findIntersection1(Node one, Node two){
	   
	   Node curent = one;
	   while(curent != null){
		   
		   Node current2 = two;
		   while(current2 != null){
			   if(curent == current2 ){
				   return curent;
			   }
			   current2 = current2.next;
		   }
		   curent = curent.next;
		 
	   }
     return null;
   }
   
   // Solution 2
   static Node findIntersection2(Node list1, Node list2){
	   
	   int len1 = length(list1);
	   int len2 = length(list2);
	   
	// Pad the shorter list with zeros
	   if(len1 < len2){
		   list1 = padList(list1,len2 - len1);
	   }else{
		   list2 = padList(list2, len1 - len2);
	   }
	   
	   while(list1 != null && list2 != null){
		   if(list1 == list2){
			   return list1;
		   }
		   list1 = list1.next;
		   list2 = list2.next;
	   }
	   return null;
   }
  static Node findIntersection3(Node list1, Node list2){
	  if(list1 == null || list2 == null) return null;
	  
	  // Get tail and sizes
	  ResultIntersection result1 = getTailAndSize(list1);
	  ResultIntersection result2 = getTailAndSize(list2);
	  
	  // If different tail nodes, then there's no intersection
	  if(result1.tail != result2.tail){
		  return null;
	  }
	  
	  // Set pointers to the start of each linked list
	  Node shorter = result1.size < result2.size ? list1 : list2;
	  Node longer = result1.size < result2.size ? list2 : list1;
	  
	  /* Advance the pointer for the longer linked list 
	   * by difference in lengths.
	   */
	  longer = getKthNode(longer, Math.abs(result1.size - result2.size));
	  
	  // Move both pointers until you have a collision
	  while(shorter != longer){
		  shorter = shorter.next;
		  longer = longer.next;
	  }
	  
	  // Return either one
	  return longer;
  }
  
  static ResultIntersection getTailAndSize(Node list){
	  if(list == null) return null;
	  
	  int size =1;
	  Node current = list;
	  while(current.next != null){
		  size++;
		  current = current.next;
	  }
	  return new ResultIntersection(current, size);
  }
  
  static Node getKthNode(Node head, int k){
	  Node current = head;
	  while(k > 0 && current != null){
		  current = current.next;
		  k--;
	  }
	  return current;
  }

  static Nodee loopDetection(Nodee head){

  	Nodee fast = head;
  	Nodee slow = head;

  	//fast and slow technique
// find meeting point. this will be LOOP_SIZE - k steps into the linked list
  	while(fast != null && fast.next != null){

  		fast = fast.next.next;
  		slow = slow.next;
  		if(slow == fast){
  			break;
		}
	}

	// Error check - no meeting point, and therefore no loop
	if(fast ==  null || fast.next ==  null){
        return null;
	}

	slow = head;
	while(slow != fast){
		slow = slow.next;
		fast = fast.next;
	}

	// Both now point to the start of the loop
	return fast;
  }

}
