package teste;

import com.sun.jna.*;

import com.sun.jna.Library; 
import com.sun.jna.Native;
import com.sun.jna.Platform;


public interface MySharedLibrary extends Library {
    public String PG_GetCGRId(String str);
    public String ShellExecute(long hWnd, String lpOperation, String lpFile, String lpParameters, String lpDirectory, long nShowCmd);
    
}