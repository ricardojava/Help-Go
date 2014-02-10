package br.com.ntk.helpgo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ntk.helpgo.bean.GridTo;

public class ErrosController {
	public static Process process;
public static List<GridTo>	populaErros(){
	GridTo usrPwd = new GridTo();
	usrPwd.setDescricao("Minha VPN pede usuário e senha");
	//usrPwd.setStatus(status);
	GridTo erro5 = new GridTo();
	erro5.setDescricao("Minha VPN apresenta o erro 5");
	GridTo erro6 = new GridTo();
	erro6.setDescricao("Minha VPN apresenta o erro 6");
	GridTo erro51 = new GridTo();
	erro51.setDescricao("Minha VPN apresenta o erro 51");
	GridTo erro56 = new GridTo();
	erro56.setDescricao("Minha VPN apresenta o erro 56");
	GridTo erro412 = new GridTo();
	erro412.setDescricao("Minha VPN apresenta o erro 412");
	GridTo erro433 = new GridTo();
	erro433.setDescricao("Minha VPN apresenta o erro 433");
	GridTo acessoRemoto = new GridTo();
	erro5.setDescricao("Acesso Remoto");
	List<GridTo> erros = new ArrayList<GridTo>();
	erros.add(usrPwd);
	erros.add(erro5);
	erros.add(erro6);
	erros.add(erro51);
	erros.add(erro56);
	erros.add(erro412);
	erros.add(erro433);
	erros.add(acessoRemoto);
	return Collections.unmodifiableList(erros);
	
}
	public static int finishVpn() throws IOException,InterruptedException{
		//Process process=null;
		try{
			process = Runtime.getRuntime().exec("cmd /c taskkill  /f /im vpngui.exe");
			//process.destroy();
		}catch(IOException e){
			throw e;
			
		}
		return process.waitFor();	
	}
	public static boolean corrigirArqConfVpn()throws Exception{		
		File file=null ;  
	    PrintStream ps = null ; 	      
	    boolean geraArq=false;
	    file = new File("C:/Arquivos de programas/VPN/VPN Client/Profiles/IPSEC_VPN.pcf");     
	       
	          
	        try {
				ps = new PrintStream (file);
			} catch (FileNotFoundException e) {
				throw e; 
			}  
	          
	        try{
	        ps.println("[main]");  
	        ps.println("Description="); 
	        ps.println("Host=pri.vpnisec.com.br");
	        ps.println("AuthType=1");
	        ps.println("GroupName=uipsec");
	        ps.println("GroupPwd=");
	        ps.println("enc_GroupPwd=856AE5C9B4C032722C6BA14A61DF95A0E521ED54B4EF0C98AD1B72D5877189DDB94822FE285DC52C2D83CCCF4E72F27DF5A9AC041CBA511F");
	        ps.println("EnableISPConnect=0");
	        ps.println("ISPConnectType=0");
	        ps.println("ISPConnect=N");
	        ps.println("ISPPhonebook=C:\\Documents and Settings\\All Users\\Application Data\\Microsoft\\Network\\Connections\\Pbk\\rasphone.pbk");
	        ps.println("ISPCommand=");
	        ps.println("Username=");
	        ps.println("SaveUserPassword=1");
	        ps.println("UserPassword=");
	        ps.println("NTDomain=");
	        ps.println("EnableBackup=1");
	        ps.println("BackupServer=200.250.108.102");
	        ps.println("EnableMSLogon=0");
	        ps.println("MSLogonType=0");
	        ps.println("!EnableNat=1");
	        ps.println("!TunnelingMode=1");
	        ps.println("TcpTunnelingPort=10000");
	        ps.println("GCertStore=0");
	        ps.println("CertName=");
	        ps.println("CertPath=");
	        ps.println("CertSubjectName=");
	        ps.println("CertSerialHash=00000000000000000000000000000000");
	        ps.println("SendCertChain=0");
	        ps.println("!PeerTimeout=30");
	        ps.println("!EnableLocalLAN=1");
	        geraArq=true;
	        }catch(Exception e){
	        	throw e;
	        }finally{
	        ps.close();
	        }
			return geraArq;    	
		
	}
	public static Process startVpn()throws IOException, InterruptedException{
		//Process process=null;
		int proc=0;
		try {
			
		    process = Runtime.getRuntime().exec("C:/Arquivos de programas/VPN/VPN Client/vpngui.exe");
		   // proc=process.waitFor();
		   // process.destroy();
		} catch (IOException e) {
			throw e;
		}
		return 	process;
	}
}
