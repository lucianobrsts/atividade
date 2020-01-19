package br.com.atividade.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDAO<T, ID extends Serializable> extends Serializable {

	public void salvar(T t);

	public void excluir(T t);

	public List<T> listar(Class<T> classe);

	public void editar(T t);

	public T pesquisaPorId(Class<T> classe, ID id);

}
