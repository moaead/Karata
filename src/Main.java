

public class Main {
	public static void main(String[] args) {
			Calculator calc = new Calculator();
			try {
				String data = "//;\n1;2";
				System.out.println(calc.Calc(data));
				
			} catch (NumberFormatException e) {
				System.out.println("FORMAT__ECX: " + e);
			} catch (NegativeException e) {
				// TODO Auto-generated catch block
				System.out.println("NEGATIVE__EXC: " + e);
			};
		
		
		}

	
}
