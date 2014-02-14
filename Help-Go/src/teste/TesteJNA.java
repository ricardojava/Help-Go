package teste;

import javax.swing.JOptionPane;

import com.sun.jna.Native;

public class  TesteJNA {
	
    public static void main(String args[]){
    	try{//898
            JOptionPane.showMessageDialog(null, "1");
//System.loadLibrary("PG_GetID");
    	//	 MySharedLibrary lib2 = (MySharedLibrary) Native.loadLibrary("shell32.dll", MySharedLibrary.class);
    		 JOptionPane.showMessageDialog(null, "2"); 
             MySharedLibrary lib = (MySharedLibrary) Native.loadLibrary("DescHelGO.dll", MySharedLibrary.class);
             //Native.register(System.loadLibrary("PG_GetID"));
    	     //MySharedLibrary lib = (MySharedLibrary) Native.loadLibrary("shell32.dll", MySharedLibrary.class);
       
        String str="";
    //     JOptionPane.showMessageDialog(null, lib.PG_GetCGRId(str));
    //     JOptionPane.showMessageDialog(null, "3");
         // System.out.println(lib.librarymethod(""));
    	}catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());

    	}
       
    }
}