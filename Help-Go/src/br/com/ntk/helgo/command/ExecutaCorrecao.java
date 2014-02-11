package br.com.ntk.helgo.command;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.ntk.helpgo.controller.ErrosController;
import br.com.ntk.helpgo.ui.ErrosUI;

public class ExecutaCorrecao implements Correcao {

	@Override
	public void erroCinco(ErrosUI errosUI) throws IOException, InterruptedException, Exception {
		  try{
		if(ErrosController.finishProcesso()==0){
		if(ErrosController.corrigirArqConfVpn()){
		    ErrosController.execultarVpn();
		   }else{
			JOptionPane.showMessageDialog(null," Erro ao iniciar  vpn :"+ " " );					
			}
		}else{						
			JOptionPane.showMessageDialog(null," Erro ao finalizar  vpn :"+ " " );
		}
		  }catch (Exception e) {
			// TODO: handle exception
			  JOptionPane.showMessageDialog(null, e.getMessage());
		}
		  
		errosUI.dispose();
	}

	@Override
	public void erroSeis(ErrosUI errosUI) throws IOException, InterruptedException, Exception {
		if(ErrosController.finishProcesso()==0){
			if(ErrosController.corrigirArqConfVpn()){
			    ErrosController.execultarVpn();
			   }else{
				JOptionPane.showMessageDialog(null," Erro ao iniciar  vpn :"+ " " );					
				}
			}else{						
				JOptionPane.showMessageDialog(null," Erro ao finalizar  vpn :"+ " " );
			}
			
			errosUI.dispose();
	  }


public void erro51(ErrosUI errosUI) throws IOException, InterruptedException, Exception {
	  try{
	if(ErrosController.stopVpn()==0){
		if(ErrosController.startVpn()==0){
		    ErrosController.execultarVpn();
		   }else{
			JOptionPane.showMessageDialog(null," Erro ao iniciar  vpn :"+ " " );					
			}
		}else{						
			JOptionPane.showMessageDialog(null," Erro ao finalizar  vpn :"+ " " );
		}
	  }catch (Exception e) { 
		  e.printStackTrace();
		  JOptionPane.showMessageDialog(null,e.getMessage() );
	}
		errosUI.dispose();
  }

@Override
public void erro56(ErrosUI errosUI) throws IOException, InterruptedException,
		Exception {
	// TODO Auto-generated method stub
	
}

}
