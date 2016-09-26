package elastic.pl.interpreter;
/* Generated By:JJTree: Do not edit this line. ASTMD5.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import org.bouncycastle.math.ec.*;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.ECNamedCurveTable;
import java.math.BigInteger;
public abstract class AbstractPointScalarMult extends SimpleNode {

	public abstract String getCurve();
	public abstract int getCompressedSize();
	public abstract int getUncompressedSize();
	public abstract int getPrivkeyInputSize();


	public AbstractPointScalarMult(int id) {

		super(id);
	}

	public AbstractPointScalarMult(ElasticPLParser p, int id) {
		super(p, id);
	}

	

	public byte[] computePt(byte[] pt1, BigInteger scalar, boolean compressed) {
		  try {
		    ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec(getCurve());
		    ECPoint d = spec.getCurve().decodePoint(pt1);
		    ECPoint pointQ = d.multiply(scalar);
		    return pointQ.getEncoded(compressed);
		  } catch (Exception e) {
		    return new byte[0];
		  }
	}

	public void interpret() {

		// check when to do nothing
		Integer position_to_start1 = new Integer(((ASTIntConstNode)jjtGetChild(0)).val);
		Boolean compressed1 = (jjtGetChild(1) instanceof ASTTrueNode) ? true : false;
		Integer position_to_start2 = new Integer(((ASTIntConstNode)jjtGetChild(2)).val);
		Integer scalar_len2 = new Integer(((ASTIntConstNode)jjtGetChild(3)).val);

		Boolean compressed = (jjtGetChild(4) instanceof ASTTrueNode) ? true : false;

		int max_bytes_state = 64000 * 4; // 256 integers with 4 bytes each

		int input_length_bytes1 = getUncompressedSize();
		if(compressed1)
			input_length_bytes1 = getCompressedSize();


		int hash_length_bytes = getUncompressedSize();
		if(compressed)
		 hash_length_bytes = getCompressedSize();



		int hash_length_full_int = (int) Math.ceil(((double) hash_length_bytes) / 4.0);
	

		if (position_to_start1 >= (max_bytes_state - hash_length_full_int)) {
			// Do nothing, invalid arguments ( memory beginning at position
			// cannot hold resulting hash)
			return;
		}
		if (position_to_start1 + input_length_bytes1 >= max_bytes_state) {
			// Do nothing, invalid arguments (cannot scan requested byte range
			// as it would go beyond the end of the state)
			return;
		}
		if (position_to_start2 + scalar_len2 >= max_bytes_state) {
			// Do nothing, invalid arguments (cannot scan requested byte range
			// as it would go beyond the end of the state)
			return;
		}
	
		// do hash
		BigInteger scalar = new BigInteger(1,this.StateIntToBytes(position_to_start2, scalar_len2));
		byte[] result = this.computePt(this.StateIntToBytes(position_to_start1, input_length_bytes1), scalar, compressed);
		bytesBackToState(result, position_to_start1);
	}

	public long weight(){
    	return 1000L;
  	}
public long getConsumedStackUsage(){
      return 0L;
    }
}
/*
 * JavaCC - OriginalChecksum=834e6b392c29bdde9f97d7660804c8fb (do not edit this
 * line)
 */
