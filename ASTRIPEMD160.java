/* Generated By:JJTree: Do not edit this line. ASTMD5.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import gnu.crypto.hash.*;
public class ASTRIPEMD160 extends SimpleNode {


	public ASTRIPEMD160(int id) {

		super(id);
	}

	public ASTRIPEMD160(ElasticPLParser p, int id) {
		super(p, id);
	}

	

	public byte[] computeRIPEMD160(byte[] message) {
		IMessageDigest md = HashFactory.getInstance("RIPEMD-160");
     	md.update(message, 0, message.length);
     
     	byte[] digest = md.digest();

		return digest;
	}

	public void interpret() {

		// check when to do nothing
		Integer position_to_start = new Integer(((ASTIntConstNode)jjtGetChild(0)).val);
		Integer byte_length = new Integer(((ASTIntConstNode)jjtGetChild(1)).val);

		int max_bytes_state = 64000 * 4; // 256 integers with 4 bytes each
		int hash_length_bytes = 20;
		int hash_length_full_int = (int) Math.ceil(((double) hash_length_bytes) / 4.0);
		int bytes_length_full_int = (int) Math.ceil(((double) byte_length) / 4.0);


		if (position_to_start >= (max_bytes_state - hash_length_full_int)) {
			// Do nothing, invalid arguments ( memory beginning at position
			// cannot hold resulting hash)
			return;
		}
		if (position_to_start + bytes_length_full_int >= max_bytes_state) {
			// Do nothing, invalid arguments (cannot scan requested byte range
			// as it would go beyond the end of the state)
			return;
		}

	
		// do hash
		byte[] result = this.computeRIPEMD160(this.StateIntToBytes(position_to_start, byte_length));
		bytesBackToState(result, position_to_start);
	}

	public long weight(){
    	return 120L;
  	}

}
/*
 * JavaCC - OriginalChecksum=834e6b392c29bdde9f97d7660804c8fb (do not edit this
 * line)
 */
