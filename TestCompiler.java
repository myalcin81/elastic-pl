public class TestCompiler {

  /** Main entry point. */
  public static void main(String args[]) {
    ElasticPLParser parser;
    if (args.length == 1) {
      System.out.println("Elastic Programming Language Interpreter Version 0.1:  Reading from file " + args[0] + " . . .");
      try {
        parser = new ElasticPLParser(new java.io.FileInputStream(args[0]));
      } catch (java.io.FileNotFoundException e) {
        System.out.println("Elastic Programming Language Interpreter Version 0.1:  File " + args[0] + " not found.");
        return;
      }
    } else {
      System.out.println("Elastic Programming Language Interpreter Version 0.1:  Usage :");
      System.out.println("         java TestCompiler inputfile");
      return;
    }
    try {
      parser.CompilationUnit();
      ((ASTCompilationUnit)parser.jjtree.rootNode()).reset();
      ((ASTCompilationUnit)parser.jjtree.rootNode()).fillRandomIntNumber();
      long WCET = RuntimeEstimator.worstWeight((SimpleNode)parser.jjtree.rootNode());
      System.out.println("[!] Worst case execution time: " + WCET);
      int input = ((ASTCompilationUnit)parser.jjtree.rootNode()).getRandomIntNumber();
      System.out.println("[!] Random integers specified: " + input);
      parser.jjtree.rootNode().interpret();
    } catch (ParseException e) {
      System.out.println("Elastic Programming Language Interpreter Version 0.1:  Encountered errors during parse.");
      e.printStackTrace();
    } catch (Exception e1) {
      System.out.println("Elastic Programming Language Interpreter Version 0.1:  Encountered errors during interpretation/tree building.");
      e1.printStackTrace();
    }

    ((ASTCompilationUnit)parser.jjtree.rootNode()).debugDumpState();

    boolean bountyFound = ((ASTCompilationUnit)parser.jjtree.rootNode()).verifyBounty();
    System.out.println("[!] Bounty requirement met: " + bountyFound);
  }
}
