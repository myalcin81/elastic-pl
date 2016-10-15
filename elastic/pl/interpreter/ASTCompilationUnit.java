package elastic.pl.interpreter;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import java.util.LinkedHashMap;
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

	public enum POW_CHECK_RESULT
	{
		OK,
		SOFT_UNBLOCKED,
		ERROR
	};

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

	public static byte[] byteHash(int randomInput[], long st1, long st2) throws NoSuchAlgorithmException {
		MessageDigest m = getMessageDigest("SHA-256");
		m.reset();

		byte[] b = new byte[16];
		for (int i = 0; i < 8; ++i) {
		  b[i] = (byte) (st1 >> (8 - i - 1 << 3));
		}
		for (int i = 0; i < 8; ++i) {
		  b[i+8] = (byte) (st2 >> (8 - i - 1 << 3));
		}


		ByteBuffer byteBufferIn = ByteBuffer.allocate(randomInput.length * 4);
		IntBuffer intInBuffer = byteBufferIn.asIntBuffer();
		intInBuffer.put(randomInput);

		byte[] array2 = byteBufferIn.array();
		m.update(b);
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
			if(symtab[j]!=0)
				System.out.println("m[" + String.valueOf(j) + "]" + ": " + symtab[j] );
		}

		

	}

	public LinkedHashMap<String, Integer> getNotNullDumpState() {
		String name;
		LinkedHashMap<String, Integer> cache = new LinkedHashMap<String, Integer>();

		int j;
		for (j = 0; j < 64000; ++j) {
			if(symtab[j]!=0)
 				 cache.put("m[" + String.valueOf(j) + "]",symtab[j]);
		}
		return cache;
	}


	public void reset() {
		symtab = new int[64001];
		top = 0;
		internal_state = 0L;
		internal_state2 = 0L;
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

	public String compile(){

		String totalCode = "#include <stdio.h>\n#include <stdint.h>\n#include <time.h>\n\nint32_t m[64000];\n\nint execute();\nint main(){\nclock_t start, end;\nint counter = 0;\nstart = clock();\nwhile(1==1){end = clock(); execute(); counter=counter+1;\nif((double)(end-start)/CLOCKS_PER_SEC >=3) break;\n}\nprintf(\"BENCHMARK: %d evaluations per second.\\n\",counter/3);\n}\n\nint execute(){\n";
    	int i, k = jjtGetNumChildren();
		for (i = 0; i < k ; i++) {
			totalCode += ((SimpleNode)jjtGetChild(i)).compile();
		}
		totalCode += "\n}\n";
		return totalCode;

  	}

	

	public void fillRandomIntNumber() {
		inputInts = new int[input_entropy_ints];
		for (int i = 0; i < input_entropy_ints; ++i) {
			Integer val = new Integer(rn.nextInt());
			symtab[i] = val;
			inputInts[i] = val.intValue();
		}
	}
	
	public void fillGivenIntNumber(int[] inputIntsOuter) {
		if(inputIntsOuter.length!=input_entropy_ints)
			return;
		inputInts = new int[input_entropy_ints];
		for (int i = 0; i < input_entropy_ints; ++i) {
			Integer val = inputIntsOuter[i];
			symtab[i]=val;
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
			Boolean symtab_result = symtab[64000] != 0 ? true : false;
			ret = symtab_result.booleanValue();
		} catch (Exception e) {
		}

		return ret;
	}

	public POW_CHECK_RESULT verifyPOW(BigInteger target, BigInteger soft_unblock) {
		POW_CHECK_RESULT ret = POW_CHECK_RESULT.ERROR;

		int in[] = getRandomIntArray();

		try {
			byte[] bsh = byteHash(in, internal_state, internal_state2);
			BigInteger val = byteHashToLong(bsh);

			if (val.compareTo(target)==-1){
				return POW_CHECK_RESULT.OK;
			}
			else if (val.compareTo(soft_unblock)==-1)
				return POW_CHECK_RESULT.SOFT_UNBLOCKED;
			else
			{
				
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return ret;
	}


 	public long getConsumedStackUsage(){
      return 0L;
    }

}
