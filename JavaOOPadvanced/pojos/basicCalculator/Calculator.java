public class Calculator{
	private String operation;
	private double operand1;
	private double operand2;
	private double result;

	public Calculator(){

	}

	public void setOperand1(double operand){
		operand1 = operand;
	}

	public void setOperand2(double operand){
		operand2 = operand;
	}

	public void setOperation(String op){
		operation = op;
	} 

	public void performOperation(){
		if (operation == "+"){
			result = (operand1 + operand2);
		}
		else if(operation == "-"){
			result = (operand1 - operand2);
		}
	}

	public double getResults(){
		return result;
	}
}