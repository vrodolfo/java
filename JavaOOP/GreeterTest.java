public class GreeterTest {
    public static void main(String[] args){
        Greeter hW = new Greeter();
        String greeting = hW.greet();
        String greetingWithName = hW.greet("Eduardo", "Val");
        if (greeting.equals("Hello World") || greetingWithName.equals("Hello Eduardo Val")){
            System.out.println("Test successful");
        } else{
            System.out.println("Test Fail");
        }
    }
}