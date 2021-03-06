package elastic.pl.interpreter;

/* Generated By:JJTree: Do not edit this line. ASTSECP224R1PointAdd.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTSECP224R1PointAdd extends AbstractPointAdd {
  public ASTSECP224R1PointAdd(int id) {
    super(id);
  }

  public ASTSECP224R1PointAdd(ElasticPLParser p, int id) {
    super(p, id);
  }

  @Override
  public  String getCurve() { return "secp224r1"; }
  @Override
  public int getCompressedSize() {return 29; }
  @Override
  public int getUncompressedSize()  {return 57; }
  @Override
  public int getPrivkeyInputSize()  {return 28; }

}
/* JavaCC - OriginalChecksum=149c51669bb00582aa47fef7b7b566b1 (do not edit this line) */
