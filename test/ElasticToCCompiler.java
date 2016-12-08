
import elastic.elastic.pl.interpreter.ASTCompilationUnit;
import elastic.elastic.pl.interpreter.ElasticPLParser;
import elastic.elastic.pl.interpreter.ParseException;
import elastic.elastic.pl.interpreter.RuntimeEstimator;
import elastic.elastic.pl.interpreter.SimpleNode;
import elastic.elastic.pl.interpreter.MyNode;
import java.io.PrintWriter;

public class ElasticToCCompiler {

	/** Main entry point. */
	public static void main(String args[]) {
		ElasticPLParser parser;
		if (args.length == 1) {
			
			try {
				parser = new ElasticPLParser(new java.io.FileInputStream(args[0]));
			} catch (java.io.FileNotFoundException e) {
				
				return;
			}
		} else {
			
			return;
		}
		try {
			parser.CompilationUnit();
			String c_code = ((SimpleNode)parser.rootNode()).compile();
			System.out.println( c_code );
			


		} catch (ParseException e) {
		
			System.exit(1);
		} catch (Exception e1) {
			
			System.exit(1);
		}
	}
}
