package com.javalingo.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Restrictions;

import com.javalingo.HibernateUtil;

public abstract class GenericDAO<T> implements DAO<T>{
	
	 private Session sessao;
	    private Transaction transacao;
	    @SuppressWarnings("rawtypes")
		private Class classe;

	    public GenericDAO(@SuppressWarnings("rawtypes") Class classe) {
	        this.classe = classe;
	    }

	@Override
    public boolean salvar(T t) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(t);

            transacao.commit();
        } catch (Exception e) {
            return false;
        } finally {
            sessao.close();
        }
        return true;
    }

    @Override
    public boolean alterar(T t) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(t);
            transacao.commit();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro!");
            return false;
        }
        finally{
        sessao.close();
        }
        return true;
    }
    

    @Override
    public boolean remover(T t) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(t);
            transacao.commit();
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

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            lista = sessao.createCriteria(Object.class).list();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Falha ao Listar!", "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return lista;
    }

    @SuppressWarnings("unchecked")
	public List<T> listar(String campo, Object value) {
        List<T> lista = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            lista = sessao.createCriteria(classe).add(Restrictions.eq(campo, value)).list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!");
            return null;
        } finally {
            sessao.close();
        }
        return lista;
    }

}