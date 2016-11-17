package com.javalingo.repository;

import java.util.List;

public interface DAO<T> {

	public boolean salvar(T t);

	public boolean alterar(T t);

	public boolean remover(T t);

	public List<T> lista();

}
