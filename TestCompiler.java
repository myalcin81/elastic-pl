
import elastic.pl.interpreter.ASTCompilationUnit;
import elastic.pl.interpreter.ElasticPLParser;
import elastic.pl.interpreter.ParseException;
import elastic.pl.interpreter.RuntimeEstimator;
import elastic.pl.interpreter.SimpleNode;
import elastic.pl.interpreter.MyNode;

public class TestCompiler {

	/** Main entry point. */
	public static void main(String args[]) {
		ElasticPLParser parser;
		if (args.length == 1) {
			System.out.println(
					"Elastic Programming Language Interpreter Version 0.1:  Reading from file " + args[0] + " . . .");
			try {
				parser = new ElasticPLParser(new java.io.FileInputStream(args[0]));
			} catch (java.io.FileNotFoundException e) {
				System.out.println(
						"Elastic Programming Language Interpreter Version 0.1:  File " + args[0] + " not found.");
				return;
			}
		} else {
			System.out.println("Elastic Programming Language Interpreter Version 0.1:  Usage :");
			System.out.println("         java TestCompiler inputfile");
			return;
		}
		try {
			parser.CompilationUnit();
			((ASTCompilationUnit) parser.rootNode()).reset();
			((ASTCompilationUnit) parser.rootNode()).fillRandomIntNumber();
			long WCET = RuntimeEstimator.worstWeight((SimpleNode) parser.rootNode());

			boolean tooMuchStackUsage = RuntimeEstimator.exceedsStackUsage((SimpleNode) parser.rootNode());

			System.out.println("[!] Worst case execution time: " + WCET);
			System.out.println("[!] Stack usage exceeded: " + tooMuchStackUsage);
			parser.rootNode().interpret();
		} catch (ParseException e) {
			System.out
					.println("Elastic Programming Language Interpreter Version 0.1:  Encountered errors during parse.");
			e.printStackTrace();
		} catch (Exception e1) {
			System.out.println(
					"Elastic Programming Language Interpreter Version 0.1:  Encountered errors during interpretation/tree building.");
			e1.printStackTrace();
		}

		((ASTCompilationUnit) parser.rootNode()).debugDumpState();
		System.out.println("[!] Exit Stack Pointer: " + MyNode.top);
		boolean bountyFound = ((ASTCompilationUnit) parser.rootNode()).verifyBounty();
		System.out.println("[!] Bounty requirement met: " + bountyFound);
	}
}
