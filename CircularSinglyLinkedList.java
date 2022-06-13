package com.kiddy.dataStructure;

public class CircularSinglyLinkedList<T> {

	/*
	 * @Author LwinPhyoAung(codeCat)
	 * CircularSinglyLinkedList
	 * 
	 * Methods :	addAtStart(T val) :
	 * 				addAtEnd(T val) :
	 * 				add(T val) :
	 * 
	 * 				removeAtStart() :
	 * 				removeAtEnd() :
	 * 				remove(int pos) :
	 * 
	 * 				get(int pos) : Node
	 * 				contain(T val) : boolean
	 * 				size() : int
	 * 				isEmpty() : boolean
	 * 
	 */
	
	public class Node{
		
		Node next;
		T val;
		
		Node(T val){
			this.val = val;
		}
		
		@Override
		public String toString() {
			return "" + this.val;
		}
		
		
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public CircularSinglyLinkedList(){
		
		size = 0;
		
	}
	
	public void add(T val){
		
		if(isEmpty()){
			addAtStart(val); 
		}else{
			addAtEnd(val); 
		}
		
	}
	
	public void addAtStart(T val){
		
		Node newNode = new Node(val);
		if(isEmpty()){
			// empty list
			head = newNode;
			tail = newNode;
			tail.next = newNode;
		}else{
			
			tail.next = newNode;
			newNode.next = head;
			head = newNode;
			
		}
		size += 1;
		
	}
	
	public void addAtEnd(T val){
		
		Node newNode = new Node(val);
		
		if(isEmpty()){
			// Empty List
			head = newNode;
			tail = newNode;
			tail.next = head;
		}else{
			
			tail.next = newNode;
			newNode.next = head;
			tail = newNode;
			
		}
		size += 1;
		
	}
	
	public void insert(int pos,T val){
		
		if(pos <= 0){
			addAtStart(val);
			return;
		}else if(pos >= (size-1)){
			addAtEnd(val);
			return;
		}else{
			
			Node newNode = new Node(val);
			
			Node currentNode = head;
			
			for (int i = 1; i < pos ; i++) {
				
				currentNode = currentNode.next;
				
			}
			
			newNode.next = currentNode.next;
			currentNode.next = newNode;
			size+=1;
			
		}
		
	}
	
	public void removeAtStart(){
		
		if(isEmpty()){
			System.out.println("List is Empty!");
		}else if(size == 1){
			head = null;
			tail = null;
			size -= 1;
		}else{
			
			head = head.next;
			tail.next = head;
			size -= 1;
			
		}
		
	}
	
	public void removeAtEnd(){
		
		if(isEmpty()){
			System.out.println("List is Empty");
		}else if(size == 1){
			head = null;
			tail = null;
			size-= 1;
		}else{
			
			Node currentNode = head;
			while(currentNode.next != tail){
				
				currentNode = currentNode.next;
				
			}
			tail = currentNode;
			tail.next = head;
			size -= 1;
			
		}
		
	}
	
	public void remove(int pos){
		
		if(isEmpty()){
			System.out.println("List is Empty");
			return;
		}
		
		
		if(pos <= 0){
			removeAtStart();
		}else if(pos >= (size-1)){
			removeAtEnd();
		}else{
			
			Node currentNode = head;
			for (int i = 1; i < pos; i++) {
				   
				currentNode = currentNode.next;
				
			}
			
			Node temp = currentNode.next.next;
			currentNode.next = temp;
			size -= 1;
			
		} 
		
		
		
	}
	
	public Node get(int pos){

		Node currentNode = null;
		if(isEmpty()){
			System.out.println("List is Empty!");
		}else if(pos <= 0){
			return head;
		}else if(pos >= (size - 1)){
			return tail;
		}else{
			currentNode = head;
			for (int i = 1; i <= pos; i++) {
			
				currentNode = currentNode.next;
			
			}
			
		}
		
		return currentNode;
		
	}
	
	public boolean contain(T val){
		
		Node temp = head;
		do{
			if(temp.val.equals(val)){
				return true;
			}
			temp = temp.next;
		}while(temp != head);
		return false;
		
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}

	public void displayList(){
		
		Node temp = head;
		String result = " [";
		
		do{
		
			result += " " + temp.val + ",";
			temp = temp.next;
			
		}while(temp != head);
		
		result += " ] ";
		System.out.println(result);
		
	}
	
	
	
}
