import java.util.Random;

/* Generated By:JJTree: Do not edit this line. ASTMD5.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */

public class ASTInputSpecificationStatement extends SimpleNode {
	
	public ASTInputSpecificationStatement(int id) {
		super(id);
	}

	public ASTInputSpecificationStatement(ElasticPLParser p, int id) {
		super(p, id);
	}

	public void interpret() {
		symtab.put("inputs", new Integer(((ASTIntConstNode)jjtGetChild(0)).val));
	}
}
/*
 * JavaCC - OriginalChecksum=834e6b392c29bdde9f97d7660804c8fb (do not edit this
 * line)
 */
