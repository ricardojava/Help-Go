package teste;

import java.net.InetAddress;

import javax.swing.JOptionPane;

import com.sun.jna.Native;

public class  TesteJNA {
	
    public static void main(String args[]){
    	try{//898
    		
    		InetAddress endereco = InetAddress.getByName("www.google.com");  
    	//	int timeout = 30000;  
    		  
    	//	if (endereco.isReachable(timeout))  
    		  System.out.println("Funcionou!");  
    		String str="",s1;        
            s1 = String.format("%-512s", str);
            JOptionPane.showMessageDialog(null, "1");
//System.loadLibrary("PG_GetID");
    	//	 MySharedLibrary lib2 = (MySharedLibrary) Native.loadLibrary("shell32.dll", MySharedLibrary.class);
            String srt="";
    	//	 JOptionPane.showMessageDialog(null, "2"); 
            System.setProperty("jna.library.path", "C:/Windows/System32/");
            MySharedLibrary lib = (MySharedLibrary) Native.loadLibrary("PG_GetID.dll", MySharedLibrary.class);
             
             
            
    		 
    		// MySharedLibrary lib = (MySharedLibrary) Native.loadLibrary("shell32.dll", MySharedLibrary.class);
             //Native.register(System.loadLibrary("PG_GetID"));
    	     //MySharedLibrary lib = (MySharedLibrary) Native.loadLibrary("shell32.dll", MySharedLibrary.class);
       
         
      //  System.out.println(s1.length());
   //     s1=lib.PG_GetCGRId(s1);
        JOptionPane.showMessageDialog(null,s1);
         JOptionPane.showMessageDialog(null, "3");
     //     System.out.println(lib.librarymethod());
    	}catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());

    	}
       
    }
}