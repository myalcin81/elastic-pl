package elastic.pl.interpreter;
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

public class ASTId extends SimpleNode {

  public ASTId(int id) {
    super(id);
  }

  public ASTId(ElasticPLParser p, int id) {
    super(p, id);
  }

  public void interpret()
  {
     jjtGetChild(0).interpret();
     Integer topint = (Integer)stack[top];
     if(topint<0 || topint>64000)
      topint = 0;
     stack[top] = symtab[topint];
  }

  public void interpret_only_inner()
  {
     jjtGetChild(0).interpret();
     Integer topint = (Integer)stack[top];
     if(topint<0 || topint>64000)
      topint = 0;
     stack[--top] = topint;
  }
  public String compile(){
    String n1 = ((SimpleNode)jjtGetChild(0)).compile();
    
    return "mem[" + n1 + "]";
  }


  public boolean ignore(){
    return true;
  }
  public long getConsumedStackUsage(){
      return 0L;
    }
}
