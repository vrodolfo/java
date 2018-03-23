import java.util.*;

public class PuzzleJava{
	public static void main(String[] args){
		//Puzzle1
		int[] myArr = {3,5,1,2,7,9,8,13,25,32};
		ArrayList<Integer> result = new ArrayList<Integer>();
		result = Puzzle1(myArr);
		printArrayList(result);

		//Puzzle2
		String[] myStringArray    = new String[]{"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
		ArrayList<String> result2 = new ArrayList<String>();
		result2 = Puzzle2(myStringArray);
		printArrayListString(result2);

		//Puzzle3
		ArrayList<String> letters = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J" ));
		Puzzle3(letters);

		int[] resul3 = new int[10];
		resul3 = Puzzle4();
		printArray(resul3);

		resul3 = Puzzle5();
		printArray(resul3);

		Puzzle6();

		Puzzle7();


	}


	public static void printArrayListString(ArrayList<String> myArr){
		for(int i=0;i<myArr.size();i++){
			System.out.println(myArr.get(i));
		}
	}

	public static void printArrayList(ArrayList<Integer> myArr){
		for(int i=0;i<myArr.size();i++){
			System.out.println(myArr.get(i));
		}
	}

	public static void printArray(int[] myArr){
		for(int i=0;i<myArr.length;i++){
			System.out.println(myArr[i]);
		}
	} 

	public static ArrayList<Integer> Puzzle1(int[] myArr){
		int sum = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<myArr.length;i++){
			sum += myArr[i];
			if(myArr[i]>10){
				result.add(myArr[i]);
			}
		}
		System.out.println("Total sum: "+sum);
		return result;
	}
	public static ArrayList<String> Puzzle2(String[] myArr){
		ArrayList<String> myStringArrayList = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		myStringArrayList.addAll(Arrays.asList(myArr));
		Collections.shuffle(myStringArrayList);
		printArrayListString(myStringArrayList);

		for(int i=0;i<myArr.length;i++){
			if (myArr[i].length() > 7){
				result.add(myArr[i]);
			}
		}
		return result;
	}

	public static void Puzzle3(ArrayList<String> myArr){
		Collections.shuffle(myArr);
		System.out.println("First letter: "+myArr.get(0));
		System.out.println("Last letter: "+myArr.get(myArr.size()-1));
		String first = myArr.get(0);
		//printArrayListString(myArr);

		if(first == "A" || first == "E" || first == "I" || first == "O" || first == "U"){
			System.out.println("YESSSSSSS ITS A VOWEL");
		}
	}

	public static int[] Puzzle4(){
		Random ran = new Random();
		int[] arr = new int[10];
		for(int i=0;i<10;i++){

			arr[i] = 55 + ran.nextInt(46);
			
		}
		return arr;
	}

	public static int[] Puzzle5(){
		Random ran = new Random();
		int[] arr = new int[10];
		for(int i=0;i<10;i++){

			arr[i] = 55 + ran.nextInt(46);
			
		}
		Arrays.sort(arr);
		System.out.println("Min: " + arr[0]);
		System.out.println("Max: " + arr[arr.length - 1]);
		return arr;
	}

	public static void Puzzle6(){
		Random ran = new Random();
		String[] arr = new String[]{"A","B","C","D","E", "F" };
		String str = "";
		//String[] myStringArray    = new String[]{"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
		for(int i=0;i<=5;i++){

			str = str + (arr[0 + ran.nextInt(6)]);
			
		}
		
		System.out.println("str: " + str);

	}

	public static void Puzzle7(){
		Random ran = new Random();
		String[] arr = new String[]{"A","B","C","D","E", "F" };
		String[] res = new String[10];
		String str = "";
		//String[] myStringArray    = new String[]{"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
		
		for(int i=0;i<10;i++){

			for(int j=0;j<=5;j++){

				str = str + (arr[0 + ran.nextInt(6)]);
			
			}
			res[i] = str;
			str = "";
			
		}

		for(int i=0;i<10;i++){
			System.out.println(res[i]);
		}
		
		

	}
}