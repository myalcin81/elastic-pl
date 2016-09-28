package elastic.pl.interpreter;
public class SafeInteger {
    public static Integer parseInt(String arg) {
        try{
        	return Integer.parseInt(arg);
        }catch(Exception e){
        	return 0;
        }
    }
}