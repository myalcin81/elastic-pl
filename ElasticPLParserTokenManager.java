/* Generated By:JJTree&JavaCC: Do not edit this line. ElasticPLParserTokenManager.java */

/** Token Manager. */
public class ElasticPLParserTokenManager implements ElasticPLParserConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x1ff8d00000000L) != 0L)
         {
            jjmatchedKind = 49;
            return 2;
         }
         return -1;
      case 1:
         if ((active0 & 0x8000000000L) != 0L)
            return 2;
         if ((active0 & 0x1ff0c00000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 49;
               jjmatchedPos = 1;
            }
            return 2;
         }
         return -1;
      case 2:
         if ((active0 & 0x200000000000L) != 0L)
            return 2;
         if ((active0 & 0x1df0c00000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 2;
            return 2;
         }
         return -1;
      case 3:
         if ((active0 & 0x10400000000L) != 0L)
            return 2;
         if ((active0 & 0x1de0800000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 3;
            return 2;
         }
         return -1;
      case 4:
         if ((active0 & 0x440800000000L) != 0L)
            return 2;
         if ((active0 & 0x19a0000000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 4;
            return 2;
         }
         return -1;
      case 5:
         if ((active0 & 0x11a0000000000L) != 0L)
            return 2;
         if ((active0 & 0x800000000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 5;
            return 2;
         }
         return -1;
      case 6:
         if ((active0 & 0x800000000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 6;
            return 2;
         }
         return -1;
      case 7:
         if ((active0 & 0x800000000000L) != 0L)
         {
            jjmatchedKind = 49;
            jjmatchedPos = 7;
            return 2;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 29;
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 37:
         return jjStopAtPos(0, 23);
      case 38:
         jjmatchedKind = 12;
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 40:
         return jjStopAtPos(0, 30);
      case 41:
         return jjStopAtPos(0, 31);
      case 42:
         return jjStopAtPos(0, 21);
      case 43:
         return jjStopAtPos(0, 19);
      case 45:
         return jjStopAtPos(0, 20);
      case 47:
         return jjStopAtPos(0, 22);
      case 59:
         return jjStopAtPos(0, 36);
      case 60:
         jjmatchedKind = 15;
         return jjMoveStringLiteralDfa1_0(0x9020000L);
      case 61:
         jjmatchedKind = 7;
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 62:
         jjmatchedKind = 16;
         return jjMoveStringLiteralDfa1_0(0x6040000L);
      case 77:
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x800000000000L);
      case 83:
         return jjMoveStringLiteralDfa1_0(0x180000000000L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 93:
         return jjStopAtPos(0, 33);
      case 94:
         return jjStopAtPos(0, 11);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x10000000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x800000000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x48000000000L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x100000000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x20000000000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x1000000000000L);
      case 123:
         return jjStopAtPos(0, 37);
      case 124:
         jjmatchedKind = 10;
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 125:
         return jjStopAtPos(0, 38);
      case 126:
         return jjStopAtPos(0, 28);
      default :
         return jjMoveNfa_0(1, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x200L) != 0L)
            return jjStopAtPos(1, 9);
         break;
      case 60:
         if ((active0 & 0x1000000L) != 0L)
         {
            jjmatchedKind = 24;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000L);
      case 61:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(1, 13);
         else if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(1, 14);
         else if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(1, 17);
         else if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(1, 18);
         break;
      case 62:
         if ((active0 & 0x2000000L) != 0L)
         {
            jjmatchedKind = 25;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000L);
      case 68:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000000000L);
      case 72:
         return jjMoveStringLiteralDfa2_0(active0, 0x180000000000L);
      case 73:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000000L);
      case 91:
         if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(1, 32);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x1020000000000L);
      case 102:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 39, 2);
         break;
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000000000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000000L);
      case 124:
         if ((active0 & 0x100L) != 0L)
            return jjStopAtPos(1, 8);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 53:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 45, 2);
         break;
      case 60:
         if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(2, 27);
         break;
      case 62:
         if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(2, 26);
         break;
      case 65:
         return jjMoveStringLiteralDfa3_0(active0, 0x180000000000L);
      case 80:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000000000L);
      case 103:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000000L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x60000000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000000000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 50:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000000L);
      case 53:
         return jjMoveStringLiteralDfa4_0(active0, 0x100000000000L);
      case 69:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000000000L);
      case 101:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(3, 34, 2);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 40, 2);
         return jjMoveStringLiteralDfa4_0(active0, 0x420000000000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000000000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 49:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000000000L);
      case 53:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000000L);
      case 77:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000000000L);
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000000L);
      case 101:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(4, 35, 2);
         break;
      case 102:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000000000L);
      case 114:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 46, 2);
         break;
      case 116:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 42, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 50:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 44, 2);
         break;
      case 54:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 43, 2);
         break;
      case 68:
         return jjMoveStringLiteralDfa6_0(active0, 0x800000000000L);
      case 116:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 41, 2);
         break;
      case 121:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 48, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 49:
         return jjMoveStringLiteralDfa7_0(active0, 0x800000000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 54:
         return jjMoveStringLiteralDfa8_0(active0, 0x800000000000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 48:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(8, 47, 2);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
               case 0:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAdd(0);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
               case 2:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 49)
                     kind = 49;
                  jjCheckNAdd(2);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, "\75", "\174\174", "\46\46", "\174", 
"\136", "\46", "\75\75", "\41\75", "\74", "\76", "\74\75", "\76\75", "\53", "\55", 
"\52", "\57", "\45", "\74\74", "\76\76", "\76\76\76", "\74\74\74", "\176", "\41", 
"\50", "\51", "\155\133", "\135", "\164\162\165\145", "\146\141\154\163\145", "\73", 
"\173", "\175", "\151\146", "\145\154\163\145", "\162\145\160\145\141\164", 
"\151\156\160\165\164", "\123\110\101\62\65\66", "\123\110\101\65\61\62", "\115\104\65", 
"\124\151\147\145\162", "\122\111\120\105\115\104\61\66\60", "\166\145\162\151\146\171", null, null, 
null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3ffffffffffc1L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[3];
private final int[] jjstateSet = new int[6];
protected char curChar;
/** Constructor. */
public ElasticPLParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public ElasticPLParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 3; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

}
