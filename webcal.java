import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Calculator {

	public static void main(String[] args) {
		Calculator.calculate(1, 1, "ADD");
		Calculator.calculate(2, 3, "MULT");
		Calculator.calculate(5, 2, "asdf");

		Endpoint.publish("http://localhost:12345/calc", new Calculator());
	}

	public int compute(int x, int y, String operation) {
		return Calculator.calculate(x, y, operation);
	}

	public static int calculate(int x, int y, String operation) {
		int result;
		String op;

		if ("ADD".equals(operation)) {
			result = x + y;
			op = "+";
		} else if ("SUB".equals(operation)) {
			result = x - y;
			op = "-";
		} else if ("MULT".equals(operation)) {
			result = x * y;
			op = "*";
		} else if ("DIV".equals(operation)) {
			result = x / y;
			op = "/";
		} else {
			// defaults to SUB
			result = x - y;
			op = "-";
		}

		log(x, y, result, op);

		return result;
	}

	private static void log(int x, int y, int result, String op) {
		System.out.format("%d %s %d = %d%n", x, op, y, result);
	}

}
