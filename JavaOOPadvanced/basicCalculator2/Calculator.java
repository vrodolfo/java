public class Calculator{
	private String operation;
	private double operand;
	private double result;

	public Calculator(){
		result = 0;
		operand = 0;

	}

	public void performOperation(double number){
		if (operation == "+" || operation == "" || operation == null){
			result = result + number;
		}
		else if(operation == "-"){
			result = result - number;
		}
		else if(operation == "*"){
			result = result * number;
		}
		else if(operation == "/"){
			result = result / number;
		}
	}

	public void performOperation(String op){
		if(op == "="){
			System.out.println("Result: "+ result);
		}
		else{
			operation = op;
		}
	}

	public double getResults(){
		return result;
	}
}