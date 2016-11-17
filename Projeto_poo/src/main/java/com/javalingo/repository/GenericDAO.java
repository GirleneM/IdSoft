package com.javalingo.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.JOptionPane;
import org.hibernate.criterion.Restrictions;

public abstract class GenericDAO<T> implements DAO<T> {

	@SuppressWarnings("rawtypes")
	private Class classe;

	public GenericDAO(@SuppressWarnings("rawtypes") Class classe) {
		this.classe = classe;
	}

	SessionFactory getSession() {
		return new Configuration().configure().buildSessionFactory();
	}

	@Override
	public boolean salvar(T t) {
		Session sessao = null;
		try {
			sessao = getSession().openSession();
			sessao.beginTransaction();
			sessao.save(t);

			sessao.getTransaction().commit();
		} catch (Exception e) {
			return false;
		} finally {
			sessao.close();
		}
		return true;
	}

	@Override
	public boolean alterar(T t) {
		Session sessao = null;

		try {
			sessao = getSession().openSession();
			sessao.beginTransaction();

			sessao.update(t);
			sessao.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			sessao.close();
		}
		return true;
	}

	@Override
	public boolean remover(T t) {
		Session sessao = null;
		try {
			sessao = getSession().openSession();
			sessao.beginTransaction();
			sessao.delete(t);
			sessao.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir!", "Erro!", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			sessao.close();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> lista() {
		List<T> lista = null;
		Session sessao = null;
		try {
			sessao = getSession().openSession();
			lista = sessao.createCriteria(classe).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(String campo, Object value) {
		List<T> lista = null;
		Session sessao = null;
		try {
			sessao = getSession().openSession();
			lista = sessao.createCriteria(classe).add(Restrictions.eq(campo, value)).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		} finally {
			sessao.close();
		}
		return lista;
	}

}