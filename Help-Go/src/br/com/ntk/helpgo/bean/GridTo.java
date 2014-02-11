package br.com.ntk.helpgo.bean;

import javax.swing.JRadioButton;

public class GridTo {
	private String descricao;
	private String status;
	private JRadioButton button;
	
	
	public JRadioButton getButton() {
		return button;
	}
	public void setButton(JRadioButton button) {
		this.button = button;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
