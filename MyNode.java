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
  protected static java.util.Hashtable symtab = new java.util.Hashtable();

  /** Stack for calculations. */
  protected static Object[] stack = new Object[60000];
  protected static int top = -1;

  private int int_marker_indicator = 0;
  private MarkerType my_marker_type = MarkerType.NO_MARKER;



  /** @throws UnsupportedOperationException if called */
  public void interpret()
  {
     throw new UnsupportedOperationException(); // It better not come here.
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
    return 0L;
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
