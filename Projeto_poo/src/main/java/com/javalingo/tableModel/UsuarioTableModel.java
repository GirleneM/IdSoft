/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalingo.tableModel;

import com.javalingo.model.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IDsoft
 */
public class UsuarioTableModel extends AbstractTableModel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeColunas[] = {"ID", "Nome", "Email", "Usuário"};
    private List<Usuario> usuarios;
        
    
    public UsuarioTableModel(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }
    
     @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
       return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Usuario usuario = usuarios.get(rowIndex);
    
        switch(columnIndex){
        
            case 0:
                return usuario.getIdUsuario();
            case 1:
                return usuario.getNome();
                
            case 2:
                return usuario.getEmail();
                
            case 3:
                return usuario.getUsuario();
                
        }
        return null;
    }
    @Override
    public String getColumnName(int column){
        
        switch(column){
        
            case 0:
                return nomeColunas[0];
            case 1:
                return nomeColunas[1];
            case 2:
                return nomeColunas[2];
            case 3:
                return nomeColunas[3];
        }
        return "";
    }
}

   
