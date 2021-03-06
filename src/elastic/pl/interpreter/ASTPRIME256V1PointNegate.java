package elastic.pl.interpreter;

/* Generated By:JJTree: Do not edit this line. ASTPRIME256V1PointNegate.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTPRIME256V1PointNegate extends AbstractPointNegate {
  public ASTPRIME256V1PointNegate(int id) {
    super(id);
  }

  public ASTPRIME256V1PointNegate(ElasticPLParser p, int id) {
    super(p, id);
  }

  @Override
  public  String getCurve() { return "prime256v1"; }
  @Override
  public int getCompressedSize() {return 33; }
  @Override
  public int getUncompressedSize()  {return 65; }
  @Override
  public int getPrivkeyInputSize()  {return 32; }
}
/* JavaCC - OriginalChecksum=4773d6afb2dcfb52e711792dda875863 (do not edit this line) */
