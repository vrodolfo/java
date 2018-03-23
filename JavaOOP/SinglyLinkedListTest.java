public class SinglyLinkedListTest{
	public static void main(String[] args){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		SinglyLinkedList list1 = new SinglyLinkedList();

		list1.addNode(node1);
		list1.addNode(node2);
		list1.addNode(node3);
		list1.addNode(node4);
		list1.addNode(node5);

		list1.showList();
		list1.removeLast();
		list1.removeLast();
		list1.removeLast();
		list1.showList();

		Node result = new Node();
		result = list1.find(1);
		if (result == null){
			System.out.println("Not exist");
		}
		else{
			System.out.println(result.getValue());
		}

		

		result = list1.find(5);
		if (result == null){
			System.out.println("Not exist");
		}
		else{
			System.out.println(result.getValue());
		}
	 }
}