package br.com.ntk.helgo.command;

import java.io.IOException;

import javax.swing.JFrame;

import br.com.ntk.helpgo.ui.ErrosUI;

public interface Correcao {
	void erroCinco(ErrosUI errosUI) throws IOException, InterruptedException, Exception;
}
