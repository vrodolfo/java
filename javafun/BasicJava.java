import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava{
	public static void main(String[] args){
		//test cases
		PrintNumbers();
		PrintOddNumbers();
		PrintSum();
		int[] myArr = {1, 2, 3, 4, 5,6 ,7, 8, 9, 10};
		PrintArray(myArr);
		Average(myArr);
		CreateOdds(myArr);
		GreatherThanY(myArr, 10);

		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(Arrays.asList(-1, 2, -3, 4, 5));
		Square(arr2);
		Negatives(arr2);

		int[] res = new int[3];
		res = AvgMinMax(myArr);
		System.out.println(res[0]);
		System.out.println(res[1]);
		System.out.println(res[2]);

		Shifting(myArr);



	}

	public static void PrintNumbers(){
		for(int i=0;i<=255;i++){
			System.out.println(i);
		}
	}

	public static void PrintOddNumbers(){
		for(int i=1;i<=255;i=i+2){
			System.out.println(i);
		}
	}

	public static void PrintSum(){
		int sum = 0;
		for(int i=0;i<=255;i++){
			sum += i;
			System.out.println("New Number: " + i + " Sum: " + sum);
		}
	}

	
	public static void PrintArray(int[] myArr){
		for(int i=0; i < myArr.length ; i++){
			System.out.println(myArr[i]);
		}
	}

	public static void FindMax(int[] myArr){
		int max = myArr[0];
		for(int i=1; i < myArr.length ; i++){
			if (myArr[i] > max){
				max = myArr[i];
			}
		}
		System.out.println(max);
	}

	public static void Average(int[] myArr){
		int sum = myArr[0];
		for(int i=1; i < myArr.length ; i++){
			sum += myArr[i]; 
		}
		System.out.println(sum/myArr.length);
	}

	public static void CreateOdds(int[] myArr){
		ArrayList<Integer> odssArr = new ArrayList<Integer>();
		for(int i=0; i < myArr.length ; i++){
			if(myArr[i] % 2 != 0){
				odssArr.add(myArr[i]); 
			}
			
		}
		System.out.println(odssArr);
	}

	public static void GreatherThanY(int[] myArr, int y){
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for(int i=0; i < myArr.length ; i++){
			if(myArr[i] > y){
				arr2.add(myArr[i]); 
			}
			
		}
		System.out.println(arr2.size());
	}

	public static void Square(ArrayList<Integer> myArr){
		System.out.println(myArr);
		for(int i=0; i < myArr.size() ; i++){
			myArr.set(i, (int)Math.pow(myArr.get(i), 2));
		}
		System.out.println(myArr);
	}

	public static void Negatives(ArrayList<Integer> myArr){
		for(int i=0; i < myArr.size() ; i++){
			if(myArr.get(i)<0){
				myArr.set(i, 0);
			}
		}
		System.out.println(myArr);
	}

	public static int[] AvgMinMax(int[] myArr){
		int sum = 0;
		int min = myArr[0];
		int max = myArr[0];
		int[] results = new int[3];

		for(int i=0; i < myArr.length ; i++){
			if(myArr[i] < min){
				min = myArr[i];
			}
			if(myArr[i] > max){
				max = myArr[i];
			}
			sum += myArr[i];
		}
		results[0] = sum/myArr.length;
		results[1] = min;
		results[2] = max;
		return results;
	}

	public static void Shifting(int[] myArr){
		for(int i=0; i < myArr.length ; i++){
			if(i<myArr.length-1){
				myArr[i] = myArr[i+1];
			}
			else{
				myArr[i] = 0;
			}
			
		}
		PrintArray(myArr);
	}

}