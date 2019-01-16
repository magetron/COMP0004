import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class ExpressionParserScriptEngine {
	
	private String getMathExpression () {
		System.out.println("Expression ?");
		Input in = new Input ();
		return in.nextLine();
	}

	private Object parseExpression (String mathExpression) throws ScriptException {
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("JavaScript");
		return engine.eval(mathExpression);
	}

	public void ioController () {
		try {
			System.out.println(parseExpression(getMathExpression()));
		} catch (ScriptException invalidExpression) {
			System.out.println("ERROR : invalid math expression.");
		}
	}
	

	public static void main (String args[]) {
		new ExpressionParserScriptEngine().ioController();
	}
}




