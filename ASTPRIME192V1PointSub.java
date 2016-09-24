
/* Generated By:JJTree: Do not edit this line. ASTPRIME192V1PointSub.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTPRIME192V1PointSub extends AbstractPointSub {
  public ASTPRIME192V1PointSub(int id) {
    super(id);
  }

  public ASTPRIME192V1PointSub(ElasticPLParser p, int id) {
    super(p, id);
  }

  @Override
  public  String getCurve() { return "prime192v1"; }
  @Override
  public int getCompressedSize() {return 25; }
  @Override
  public int getUncompressedSize()  {return 49; }
  @Override
  public int getPrivkeyInputSize()  {return 24; }

}
/* JavaCC - OriginalChecksum=b1b7b2d1f380ae4ea1e90593f05c2551 (do not edit this line) */
