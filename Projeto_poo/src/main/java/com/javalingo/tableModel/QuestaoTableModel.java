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
 * @author Raphael Oliveira
 */
public class QuestaoTableModel extends AbstractTableModel {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String nomeColunas[] = {"ID", "Questao", "Resposta", "Dificuldade", "Alternativa A", "Alternativa B" , "Alternativa C" , "Alternativa D"};
    private List<Questao> questoes;
    
    public QuestaoTableModel(List<Questao> qustoes){
        this.questoes = qustoes;
    }
    
     @Override
    public int getRowCount() {
        return questoes.size();
    }

    @Override
    public int getColumnCount() {
       return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Questao questao = questoes.get(rowIndex);
    
        switch(columnIndex){
        
            case 0:
                return questao.getIdQuestao();
            case 1:
                return questao.getQuestao();
                
            case 2:
                return questao.getResposta();
                
            case 3:
                return questao.getDificuldade();
            case 4:
                return questao.getAltA(); 
            case 5:
                return questao.getAltB();
            case 6:
                return questao.getAltC();
            case 7:
                return questao.getAltD();
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
            case 4:
                return nomeColunas[4];
            case 5:
                return nomeColunas[5];
            case 6:
                return nomeColunas[6];
            case 7:
                return nomeColunas[7];
        }
        return "";
    }
}

   
