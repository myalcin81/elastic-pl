package elastic.pl.interpreter;
/* Copyright (c) 2006, Sreenivasa Viswanadha <sreeni@viswanadha.net>
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

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;


/**
 * Specialised node.
 */
public class MyNode
{

  public enum MarkerType {
    NO_MARKER, IF_STATEMENT_BEGIN, IF_STATEMENT_DIVIDER, IF_STATEMENT_END, WHILE_STATEMENT_BEGIN, WHILE_STATEMENT_END
  }

  /** Symbol table */
  protected static int[] symtab = new int[64001];

  /** Stack for calculations. */
  public static Object[] stack = new Object[1024];
  public static int top = -1;

  public static int internal_state = 0;
  public static int internal_state2 = 0;
  public static int internal_state3 = 0;
  public static int internal_state4 = 0;

  public static void mangle_state(int x){
    //System.out.println("Mangling " + x);
    int mod = x%32;
    int f = mod%4;
    if(f==0){
      internal_state = Integer.rotateLeft(internal_state,mod);
      internal_state = internal_state ^ x;
    }else if(f==1){
      internal_state2 = Integer.rotateLeft(internal_state2,mod);
      internal_state2 = internal_state2 ^ x;
    }else if(f==2){
      internal_state3 = Integer.rotateLeft(internal_state3,mod);
      internal_state3 = internal_state3 ^ x;
    }else{
      internal_state4 = Integer.rotateLeft(internal_state4,mod);
      internal_state4 = internal_state4 ^ x;
    }
  }

  private int int_marker_indicator = 0;
  private MarkerType my_marker_type = MarkerType.NO_MARKER;

final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
public static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for ( int j = 0; j < bytes.length; j++ ) {
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
}

  byte[] StateIntToBytes(int starting_value, int numbytes) {
    byte[] bytes = new byte[numbytes];

    for (int i = 0; i < numbytes; ++i) {
      int num_int = starting_value + i / 4;
      int nth = 3 - (i % 4);
      int rawval = (int) symtab[num_int];
      byte rel = (byte) ((rawval >> (nth * 8)) & 0xff);
      bytes[i] = rel;
    }
    return bytes;
  }

  public byte safeGet(byte[] barr, int pos){
    if(barr.length > pos)
      return barr[pos];
    else
      return 0;
  }
  public void bytesBackToState(byte[] barr, int starting_value) {

    int size = (barr.length / 4) + ((barr.length % 4 == 0) ? 0 : 1);
    for (int i = 0; i < size; ++i) {
      int int_converted = ((safeGet(barr, i * 4) & 0Xff) << 24) | ((safeGet(barr, (i * 4) + 1) & 0Xff) << 16)
          | ((safeGet(barr, (i * 4) + 2) & 0Xff) << 8) | ((safeGet(barr, (i * 4) + 3) & 0Xff));
      symtab[starting_value + i] = int_converted;
    }
  }


  /** @throws UnsupportedOperationException if called */
  public void interpret()
  {
     throw new UnsupportedOperationException(); // It better not come here.
  }

  public String compile(){
    throw new UnsupportedOperationException();
  }


  protected static Writer out = new PrintWriter(System.out);
  protected static Reader in = new InputStreamReader(System.in);

  /**
   * @param in the input to set
   */
  public static void setIn(Reader in) {
    MyNode.in = in;
  }

  /**
   * @param out the output to set
   */
  public static void setOut(Writer out) {
    MyNode.out = out;
  }

  public long weight(){
    return 1L;
  }

  

  public boolean ignore(){
    return false;
  }

  public boolean conditional(){
    return false;
  }
  
  public boolean repeat(){
    return false;
  }

  public boolean marker(){
    return false;
  }

  public MarkerType get_marker_type(){
    return my_marker_type;
  }

  public void set_marker_type(MarkerType t){
    this.my_marker_type = t;
  }

}
