
import elastic.pl.interpreter.ASTCompilationUnit;
import elastic.pl.interpreter.ElasticPLParser;
import elastic.pl.interpreter.ParseException;
import elastic.pl.interpreter.RuntimeEstimator;
import elastic.pl.interpreter.SimpleNode;
import elastic.pl.interpreter.MyNode;
import java.io.PrintWriter;

public class ElasticToCCompiler {

	/** Main entry point. */
	public static void main(String args[]) {
		ElasticPLParser parser;
		if (args.length == 1) {
			System.out.println(
					"Elastic-to-C Compiler Version 0.1:  Reading from file " + args[0] + " . . .");
			try {
				parser = new ElasticPLParser(new java.io.FileInputStream(args[0]));
			} catch (java.io.FileNotFoundException e) {
				System.out.println(
						"Elastic-to-C Compiler 0.1:  File " + args[0] + " not found.");
				return;
			}
		} else {
			System.out.println("Elastic-to-C Compiler Version 0.1:  Usage :");
			System.out.println("         java ElasticToCCompiler inputfile");
			return;
		}
		try {
			parser.CompilationUnit();
			String c_code = ((SimpleNode)parser.rootNode()).compile();

			try(  PrintWriter out = new PrintWriter( args[0] + ".c" )  ){
			    out.println( c_code );
			}


		} catch (ParseException e) {
			System.out
					.println("Elastic-to-C Compiler 0.1:  Encountered errors during parse: " + e.getMessage());
			System.exit(1);
		} catch (Exception e1) {
			System.out.println(
					"Elastic-to-C Compiler Version 0.1:  Encountered errors during interpretation/tree building.");
			e1.printStackTrace();
			System.exit(1);
		}
		System.out.println("Elastic-to-C Compiler Version 0.1:  OK.");
	}
}
