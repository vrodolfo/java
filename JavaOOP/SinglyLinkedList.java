public class SinglyLinkedList{
	private Node head;

	public SinglyLinkedList(){
		head = null;
	}

	public SinglyLinkedList(Node head){
		this.head = head;
	}

	public void addNode(Node node){
		if (head == null){
			head = node;
		}
		else{
			Node temp = new Node();
			temp = head;
			boolean flag = true;
			while(flag){
				if(temp.getNext() == null){
					temp.setNext(node);
					flag =false;
				}
				temp = temp.getNext();
			}
		}
	}

	public void showList(){
		if (head == null){
			System.out.println("List is empty");
		}
		else{
			//loop the list up to where tem.next is null
			Node temp = new Node();
			temp = head;
			boolean flag = true;
			while(flag){
				System.out.println("Node value: " + temp.getValue());
				if(temp.getNext() == null){
					flag =false;
				}
				temp = temp.getNext();
			}
		}

	}

	public void removeLast(){
		if (head == null){
			System.out.println("List is empty");
		}
		else if(head.getNext() == null){
			head = null;
		}
		else{
			Node temp = new Node();
			Node previous = new Node();
			temp = head;
			previous = head;
			boolean flag = true;
			while(flag){
				if(temp.getNext() == null){
					flag =false;
					previous.setNext(null);
				}
				previous = temp;
				temp = temp.getNext();
			}
		}

	}

	public Node find(int value){
		Node temp = new Node();
		if (head == null){
			return null;
		}
		else{
			temp = head;
			boolean flag = true;
			while(flag){
				if(temp.getNext() == null){
					flag =false;
				}
				if(temp.getValue() == value){
					return temp;
				}
				temp = temp.getNext();
			}
			return null;
		}

	}
}