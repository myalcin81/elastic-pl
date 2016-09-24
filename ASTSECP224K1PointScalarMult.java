
/* Generated By:JJTree: Do not edit this line. ASTSECP224K1PointScalarMult.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTSECP224K1PointScalarMult extends AbstractPointScalarMult {
  public ASTSECP224K1PointScalarMult(int id) {
    super(id);
  }

  public ASTSECP224K1PointScalarMult(ElasticPLParser p, int id) {
    super(p, id);
  }

  @Override
  public  String getCurve() { return "secp224k1"; }
  @Override
  public int getCompressedSize() {return 29; }
  @Override
  public int getUncompressedSize()  {return 57; }
  @Override
  public int getPrivkeyInputSize()  {return 28; }
}
/* JavaCC - OriginalChecksum=4b27c49383c76ca545598a0f80307d15 (do not edit this line) */

