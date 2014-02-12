package teste;

public class TestJNI {
	   public native void greetings();

	   static {
	      System.loadLibrary("C:\\Program Files (x86)\\Windows NT\\Accessories\\WordpadFilter.dll");
	   }

	   public static void main(String args[]) {
	      new TestJNI().greetings();
	   }
	}