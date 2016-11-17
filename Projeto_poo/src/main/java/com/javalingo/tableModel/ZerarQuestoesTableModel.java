/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javalingo.tableModel;

import com.javalingo.model.*;
import com.javalingo.repository.QuestaoDAO;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IDsoft
 */
public class ZerarQuestoesTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeColunas[] = { "" };
	private List<Questao> questoes;

	public ZerarQuestoesTableModel(List<Questao> qustoes) {
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
		Questao que = questoes.get(rowIndex);
		QuestaoDAO qd = new QuestaoDAO();
		switch (columnIndex) {
		case 0:
			que.setQuestaofeita("0");
			qd.alterar(que);
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {

		switch (column) {

		case 0:

		}

		return "";
	}
}
