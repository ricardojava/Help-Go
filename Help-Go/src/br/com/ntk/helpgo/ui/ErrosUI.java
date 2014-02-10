package br.com.ntk.helpgo.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.com.ntk.helpgo.bean.GridTo;
import br.com.ntk.helpgo.controller.GridErros;
import br.com.ntk.helpgo.controller.ErrosController;

public class ErrosUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ErrosUI dialog = new ErrosUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ErrosUI() {
		GridErros gridErros = new GridErros();
		

		for (GridTo bean : ErrosController.populaErros()) {
			gridErros.addRow(bean);
		}
		setBounds(100, 100, 524, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 11, 414, 62);
		scroll.setViewportView(table);
		table = new JTable(gridErros);
		//table.setFillsViewportHeight(true);
		//table.setCellSelectionEnabled(true);
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				
				try {
					if(row==1){
					if(ErrosController.finishVpn()==0){
					if(ErrosController.corrigirArqConfVpn()){
					    ErrosController.startVpn();
					   }else{
						JOptionPane.showMessageDialog(null," Erro ao iniciar  vpn :"+ " " );					
						}
					}else{						
						JOptionPane.showMessageDialog(null," Erro ao finalizar  vpn :"+ " " );
					}
					
				    dispose();
					}	
					//JOptionPane.showMessageDialog(null," corrigindo arq vpn :"+ " " +table.getValueAt(row,col).toString());

					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null," startVpn arq vpn :"+ " " +e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null," startVpn arq vpn :"+ " " +e1.getMessage());
					e1.printStackTrace();
				}
				// JOptionPane.showMessageDialog(null," Value in the cell clicked :"+
				// " " +table.getValueAt(row,col).toString());
				//System.out.println(" Value in the cell clicked :" + " " + table.getValueAt(row, col).toString());
			}
		});
		table.setBounds(10, 11, 414, 62);
		contentPanel.add(table);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 488, 189);
		contentPanel.add(panel);

		JScrollPane scrollPane = new JScrollPane(table);
		/*
		 * scrollPane.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * System.out.println("opa"); } });
		 */
		panel.add(scrollPane);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.setActionCommand("Confirmar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}
}
