
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

/* Copyright (c) 2006, Sun Microsystems, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Sun Microsystems, Inc. nor the names of its
 *       contributors may be used to endorse or promote products derived from
 *       this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

/* JJT: 0.2.2 */


public class ASTCompilationUnit extends SimpleNode {
	public static final int input_entropy_ints = 12;

	static long seed = System.currentTimeMillis();
	private int[] inputInts;
	static Random rn = new Random(seed);

	public static MessageDigest getMessageDigest(String algorithm) {
		try {
			return MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	public static byte[] byteHash(int randomInput[], int output[]) throws NoSuchAlgorithmException {
		MessageDigest m = getMessageDigest("SHA-256");
		m.reset();
		ByteBuffer byteBuffer = ByteBuffer.allocate(output.length * 4);
		IntBuffer intBuffer = byteBuffer.asIntBuffer();
		intBuffer.put(output);
		ByteBuffer byteBufferIn = ByteBuffer.allocate(randomInput.length * 4);
		IntBuffer intInBuffer = byteBufferIn.asIntBuffer();
		intInBuffer.put(randomInput);

		byte[] array = byteBuffer.array();
		byte[] array2 = byteBufferIn.array();
		m.update(array);
		m.update(array2);
		byte[] digest = m.digest();
		return digest;
	}

	public static BigInteger byteHashToLong(byte hash[]){
		 BigInteger bigInteger = new BigInteger(1, hash);
	     return bigInteger;
	 }

	public ASTCompilationUnit(int id) {
		super(id);
	}

	public ASTCompilationUnit(ElasticPLParser p, int id) {
		super(p, id);
	}

	public void debugDumpState() {
		String name;
		int j;

		for (j = 0; j < 64000; ++j) {
			name = "m[" + String.valueOf(j) + "]";
			if(symtab.get(name) != null && Integer.valueOf(symtab.get(name).toString())!=0)
				System.out.println(name + ": " + symtab.get(name) );
		}

		

	}

	public void reset() {
		// Initialize the internal state of all 256 internal integers with plain
		// 0
		String name;
		int j;
		for (j = 0; j < 64000; ++j) {
			name = "m[" + String.valueOf(j) + "]";
			symtab.put(name, new Integer(0));
		}
		

		// Also remove input and verify from symtab
		symtab.remove("verify");
		symtab.remove("input");

		// Reset Stack Pointer
		top = 0;
	}

	public void interpret() {

		// Interpret the program, but only 1.. k-1 children as the first is the
		// input specification and the last one is BY
		// GRAMMAR DEFINITION the bounty hook function
		int i, k = jjtGetNumChildren();
		for (i = 0; i < k - 1; i++) {
			jjtGetChild(i).interpret();
		}

	}

	

	public void fillRandomIntNumber() {
		inputInts = new int[input_entropy_ints];
		for (int i = 0; i < input_entropy_ints; ++i) {
			Integer val = new Integer(rn.nextInt());
			symtab.put("m[" + String.valueOf(i) + "]", val);
			inputInts[i] = val.intValue();
		}
	}
	
	public void fillGivenIntNumber(int[] inputIntsOuter) {
		if(inputIntsOuter.length!=input_entropy_ints)
			return;
		inputInts = new int[input_entropy_ints];
		for (int i = 0; i < input_entropy_ints; ++i) {
			Integer val = inputIntsOuter[i];
			symtab.put("m[" + String.valueOf(i) + "]", val);
			inputInts[i] = val.intValue();
		}
	}

	public int[] getRandomIntArray() {
		return inputInts;
	}

	public boolean verifyBounty() {
		boolean ret = false;

		// The verify statement MUST be the last one
		int k = jjtGetNumChildren();
		jjtGetChild(k - 1).interpret();

		try {
			Boolean symtab_result = (Boolean) symtab.get("verify");
			ret = symtab_result.booleanValue();
		} catch (Exception e) {
		}

		return ret;
	}

	public boolean verifyPOW(BigInteger target) {
		boolean ret = false;

		int in[] = getRandomIntArray();
		int out[] = getOutState();

		try {
			byte[] bsh = byteHash(in, out);
			BigInteger val = byteHashToLong(bsh);
	
			if (val.compareTo(target)==-1)
				return true;
		} catch (NoSuchAlgorithmException e) {
		}

		return ret;
	}

	private int[] getOutState() {
		int outstate[] = new int[64000];
		for (int j = 0; j < 64000; ++j) {
			String name = "m[" + String.valueOf(j) + "]";
			Integer r = (Integer) symtab.get(name);
			outstate[j] = r.intValue();
		}
		return outstate;
	}


}
