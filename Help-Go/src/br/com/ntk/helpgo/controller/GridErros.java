package br.com.ntk.helpgo.controller;

import java.util.ArrayList;
import java.util.List;



import javax.swing.table.AbstractTableModel;

import br.com.ntk.helpgo.bean.GridTo;

public class GridErros extends AbstractTableModel{
    
   private List<GridTo> dados;
   private String[] colunas = {"Descrição " , "Status",""};
    
   public GridErros(){
       dados = new ArrayList<GridTo>();
   }
    
   public void addRow(GridTo bean){
       this.dados.add(bean);
       this.fireTableDataChanged();
   }

   public String getColumnName(int num){
       return this.colunas[num];
   }

   @Override
   public int getRowCount() {
       return dados.size();
   }

   @Override
   public int getColumnCount() {
       return colunas.length;
   }

   @Override
   public Object getValueAt(int linha, int coluna) {
       switch(coluna){
           case 0: return dados.get(linha).getDescricao();
           case 1: return dados.get(linha).getStatus();  
           case 2: return dados.get(linha).getButton(); 
       }  
       return null;
   }
}
