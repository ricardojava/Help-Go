package br.com.ntk.helgo.command;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.ntk.helpgo.controller.ErrosController;
import br.com.ntk.helpgo.ui.ErrosUI;

public class ExecutaCorrecao implements Correcao {

	@Override
	public void erroCinco(ErrosUI errosUI) throws IOException, InterruptedException, Exception {
		if(ErrosController.finishVpn()==0){
		if(ErrosController.corrigirArqConfVpn()){
		    ErrosController.startVpn();
		   }else{
			JOptionPane.showMessageDialog(null," Erro ao iniciar  vpn :"+ " " );					
			}
		}else{						
			JOptionPane.showMessageDialog(null," Erro ao finalizar  vpn :"+ " " );
		}
		
		errosUI.dispose();
	}

}
