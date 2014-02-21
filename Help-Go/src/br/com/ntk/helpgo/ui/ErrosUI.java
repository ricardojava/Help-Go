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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.towel.swing.table.JTableView;

import br.com.ntk.helgo.command.Correcao;
import br.com.ntk.helgo.command.ExecutaCorrecao;
import br.com.ntk.helpgo.bean.GridTo;
import br.com.ntk.helpgo.controller.AggregateModel;
import br.com.ntk.helpgo.controller.GridErros;
import br.com.ntk.helpgo.controller.ErrosController;

public class ErrosUI extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
    private Correcao correcao;
    private static ErrosUI dialog;
    private static int linhaErro,row,col;
    JPanel panel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog = new ErrosUI();
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
		final GridErros gridErros = new GridErros();		
		correcao = new ExecutaCorrecao();

		for (GridTo bean : ErrosController.populaErros()) {
		//	bean.setStatus("ok");
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
		
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				row  = table.rowAtPoint(e.getPoint());
				col = table.columnAtPoint(e.getPoint());
				
				try {				
					linhaErro=table.rowAtPoint(e.getPoint());					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null," startVpn arq vpn :"+ " " +e1.getMessage());
					e1.printStackTrace();
				}
				
				//System.out.println(" Value in the cell clicked :" + " " + table.getValueAt(row, col).toString());
			}

		});
	
		/*JPanel panel = new JPanel();*/
		panel.setBounds(10, 11, 488, 189);
		contentPanel.add(panel);

		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.add(scrollPane);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							
							Object[] options = { "Sim", "Não" };  
							
							table.setValueAt(table, 1, 1);
					        int i = JOptionPane.showOptionDialog(null,  
					                "Deseja orrigir o erro "+table.getValueAt(row, col).toString()+" ?", "Saída",  
					                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,  
					                options, options[0]);  
					        if (i == JOptionPane.YES_OPTION) {  
					        	if(linhaErro==1 ||linhaErro==2){							
									correcao.erroCinco(dialog);		
									
									
							  }else if(linhaErro==3){
								  correcao.erro51(dialog);
							  }
					        }  					
							
					        atualizaTable();
							
						
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					}
				});
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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	
	public void setValueAt(JTable aValue, int rowIndex, int columnIndex) {    
       // Livro titulo = valores.get(row);  
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.    
        //Note que vc poderia alterar 2 campos ao invés de um só.    
		GridTo bean = new GridTo();
		bean.setStatus("ok");
		aValue.setValueAt(bean, rowIndex, columnIndex);
		//table.getValueAt(row, col).toString()
      //  if (columnIndex== 3) //titulo.setTitulo(aValue.toString());    
      //  else if (columnIndex== Status) titulo.getAutor().setNome(aValue.toString());    
    }  
	
	
	
	
	public void atualizaTable()     
	{     
	    ListSelectionModel rowSM = table.getSelectionModel();     
	    if(rowSM.isSelectionEmpty())     
	    {     
	        JOptionPane.showMessageDialog(null, "Nenhum item selecionado!");     
	    }     
	    else     
	    {     
	        try     
	        {     
	            int selectRow = rowSM.getMinSelectionIndex();     
	            String iten = table.getValueAt(selectRow, 0).toString();     
	            table.setValueAt("opa", 0, 1);
	          //  String valor = table.getCellEditor(selectRow, 0).getCellEditorValue().toString();  
	        }     
	        catch(Exception e)     
	        {     
	            e.printStackTrace();     
	        }     
	    }     
	        
	}  
	
}
