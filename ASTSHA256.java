/* Generated By:JJTree: Do not edit this line. ASTMD5.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=MyNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */

public class ASTSHA256 extends SimpleNode {


	private static final int[] k = { 0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4,
			0xab1c5ed5, 0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
			0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da, 0x983e5152,
			0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967, 0x27b70a85, 0x2e1b2138,
			0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85, 0xa2bfe8a1, 0xa81a664b, 0xc24b8b70,
			0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070, 0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5,
			0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3, 0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa,
			0xa4506ceb, 0xbef9a3f7, 0xc67178f2 };

	private static final int BLOCK_SIZE = 64; // inner block size in bytes
	private static final int[] w = new int[64];
	private static Boolean valid;
	private int h0, h1, h2, h3, h4, h5, h6, h7;
	private long count = 0;
	private byte[] buffer = new byte[BLOCK_SIZE];

	protected void transform(byte[] in, int offset) {
		int[] result = sha(h0, h1, h2, h3, h4, h5, h6, h7, in, offset);

		h0 = result[0];
		h1 = result[1];
		h2 = result[2];
		h3 = result[3];
		h4 = result[4];
		h5 = result[5];
		h6 = result[6];
		h7 = result[7];
	}

	protected byte[] padBuffer() {
		int n = (int) (count % BLOCK_SIZE);
		int padding = (n < 56) ? (56 - n) : (120 - n);
		byte[] result = new byte[padding + 8];

		// padding is always binary 1 followed by binary 0s
		result[0] = (byte) 0x80;

		// save number of bits, casting the long to an array of 8 bytes
		long bits = count << 3;
		result[padding++] = (byte) (bits >>> 56);
		result[padding++] = (byte) (bits >>> 48);
		result[padding++] = (byte) (bits >>> 40);
		result[padding++] = (byte) (bits >>> 32);
		result[padding++] = (byte) (bits >>> 24);
		result[padding++] = (byte) (bits >>> 16);
		result[padding++] = (byte) (bits >>> 8);
		result[padding] = (byte) bits;

		return result;
	}

	protected byte[] getResult() {
		return new byte[] { (byte) (h0 >>> 24), (byte) (h0 >>> 16), (byte) (h0 >>> 8), (byte) h0, (byte) (h1 >>> 24),
				(byte) (h1 >>> 16), (byte) (h1 >>> 8), (byte) h1, (byte) (h2 >>> 24), (byte) (h2 >>> 16),
				(byte) (h2 >>> 8), (byte) h2, (byte) (h3 >>> 24), (byte) (h3 >>> 16), (byte) (h3 >>> 8), (byte) h3,
				(byte) (h4 >>> 24), (byte) (h4 >>> 16), (byte) (h4 >>> 8), (byte) h4, (byte) (h5 >>> 24),
				(byte) (h5 >>> 16), (byte) (h5 >>> 8), (byte) h5, (byte) (h6 >>> 24), (byte) (h6 >>> 16),
				(byte) (h6 >>> 8), (byte) h6, (byte) (h7 >>> 24), (byte) (h7 >>> 16), (byte) (h7 >>> 8), (byte) h7 };
	}

	protected void resetContext() {
		// magic SHA-256 initialisation constants
		h0 = 0x6a09e667;
		h1 = 0xbb67ae85;
		h2 = 0x3c6ef372;
		h3 = 0xa54ff53a;
		h4 = 0x510e527f;
		h5 = 0x9b05688c;
		h6 = 0x1f83d9ab;
		h7 = 0x5be0cd19;
	}

	private static final synchronized int[] sha(int hh0, int hh1, int hh2, int hh3, int hh4, int hh5, int hh6, int hh7,
			byte[] in, int offset) {
		int A = hh0;
		int B = hh1;
		int C = hh2;
		int D = hh3;
		int E = hh4;
		int F = hh5;
		int G = hh6;
		int H = hh7;
		int r, T, T2;

		for (r = 0; r < 16; r++) {
			w[r] = (in[offset++] << 24 | (in[offset++] & 0xFF) << 16 | (in[offset++] & 0xFF) << 8
					| (in[offset++] & 0xFF));
		}
		for (r = 16; r < 64; r++) {
			T = w[r - 2];
			T2 = w[r - 15];
			w[r] = ((((T >>> 17) | (T << 15)) ^ ((T >>> 19) | (T << 13)) ^ (T >>> 10)) + w[r - 7]
					+ (((T2 >>> 7) | (T2 << 25)) ^ ((T2 >>> 18) | (T2 << 14)) ^ (T2 >>> 3)) + w[r - 16]);
		}

		for (r = 0; r < 64; r++) {
			T = (H + (((E >>> 6) | (E << 26)) ^ ((E >>> 11) | (E << 21)) ^ ((E >>> 25) | (E << 7)))
					+ ((E & F) ^ (~E & G)) + k[r] + w[r]);
			T2 = ((((A >>> 2) | (A << 30)) ^ ((A >>> 13) | (A << 19)) ^ ((A >>> 22) | (A << 10)))
					+ ((A & B) ^ (A & C) ^ (B & C)));
			H = G;
			G = F;
			F = E;
			E = D + T;
			D = C;
			C = B;
			B = A;
			A = T + T2;
		}

		return new int[] { hh0 + A, hh1 + B, hh2 + C, hh3 + D, hh4 + E, hh5 + F, hh6 + G, hh7 + H };
	}

	public void update(byte b) {
		// compute number of bytes still unhashed; ie. present in buffer
		int i = (int) (count % BLOCK_SIZE);
		count++;
		buffer[i] = b;
		if (i == (BLOCK_SIZE - 1)) {
			transform(buffer, 0);
		}
	}

	public void update(byte[] b) {
		update(b, 0, b.length);
	}

	public void update(byte[] b, int offset, int len) {
		int n = (int) (count % BLOCK_SIZE);
		count += len;
		int partLen = BLOCK_SIZE - n;
		int i = 0;

		if (len >= partLen) {
			System.arraycopy(b, offset, buffer, n, partLen);
			transform(buffer, 0);
			for (i = partLen; i + BLOCK_SIZE - 1 < len; i += BLOCK_SIZE) {
				transform(b, offset + i);
			}
			n = 0;
		}

		if (i < len) {
			System.arraycopy(b, offset + i, buffer, n, len - i);
		}
	}

	public byte[] digest() {
		byte[] tail = padBuffer(); // pad remaining bytes in buffer
		update(tail, 0, tail.length); // last transform of a message
		byte[] result = getResult(); // make a result out of context

		reset(); // reset this instance for future re-use

		return result;
	}

	public void reset() { // reset this instance for future re-use
		count = 0L;
		for (int i = 0; i < BLOCK_SIZE;) {
			buffer[i++] = 0;
		}

		resetContext();
	}

	byte[] StateIntToBytes(int starting_value, int numbytes) {
		byte[] bytes = new byte[numbytes];
		for (int i = 0; i < numbytes; ++i) {
			int num_int = starting_value + i / 4;
			int nth = 3 - (i % 4);
			int rawval = (int) symtab.get("m[" + num_int + "]");
			byte rel = (byte) ((rawval >> (nth * 8)) & 0xff);
			bytes[i] = rel;
		}
		return bytes;
	}

	public void bytesBackToState(byte[] barr, int starting_value) {
		int size = (barr.length / 4) + ((barr.length % 4 == 0) ? 0 : 1);
		for (int i = 0; i < size; ++i) {
			int int_converted = ((barr[(i * 4)] & 0Xff) << 24) | ((barr[(i * 4) + 1] & 0Xff) << 16)
					| ((barr[(i * 4) + 2] & 0Xff) << 8) | ((barr[(i * 4) + 3] & 0Xff));
			symtab.put("m[" + String.valueOf(starting_value + i) + "]", int_converted);
		}
	}

	public ASTSHA256(int id) {

		super(id);
	}

	public ASTSHA256(ElasticPLParser p, int id) {
		super(p, id);
	}

	public byte[] computeSHA256(byte[] message) {
		this.update(message);
		byte[] result = this.digest();
		return result;
	}

	public void interpret() {

		// check when to do nothing
		Integer position_to_start = new Integer(((ASTIntConstNode)jjtGetChild(0)).val);
		Integer byte_length = new Integer(((ASTIntConstNode)jjtGetChild(1)).val);

		// Remove that from the stack! No need to keep

		int max_bytes_state = 64000 * 4; // 256 integers with 4 bytes each
		int hash_length_bytes = 32;
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

		// Reset Context
		resetContext();

		// do hash
		byte[] result = this.computeSHA256(this.StateIntToBytes(position_to_start, byte_length));
		bytesBackToState(result, position_to_start);
	}

	public long weight(){
    	return 100L;
  	}

}
/*
 * JavaCC - OriginalChecksum=834e6b392c29bdde9f97d7660804c8fb (do not edit this
 * line)
 */
