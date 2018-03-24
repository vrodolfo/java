public class CalculatorTest{
	public static void main(String[] args){
		Calculator calc = new Calculator();

		calc.setOperand1(10.5);
		calc.setOperation("+");
		calc.setOperand2(5.2);
		calc.performOperation();
		System.out.println(calc.getResults());

	}
}