import java.util.*;

class ExceptionsTest2{
    public static void main(String[] args) {


		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add("13");
		myList.add("hello world");
		myList.add(48);
		myList.add("Goodbye World");

		int test;

		for(int i=0;i<myList.size();i++){
			try{

				test = (Integer) myList.get(i);	
			}
			catch(Exception exception){
				System.out.println("Error on index: " + i);
			}
			

		}

    }
}
