package br.com.atividade.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.atividade.util.JPAResourceBean;

public class AbstractDAOImpl<T, ID extends Serializable> implements AbstractDAO<T, ID> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager = JPAResourceBean.getEntityManager();

	public void salvar(T t) {

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(t);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			if (entityManager != null) {
				entityManager.getTransaction().rollback();
			}
		}
	}

	public void excluir(T t) {

		try {
			if (entityManager.getTransaction().isActive() == false) {

				entityManager.getTransaction().begin();
			}
			 if(entityManager.isOpen() == false) {
				 entityManager = JPAResourceBean.getEntityManager();
			 }
			entityManager.remove(t);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			if (entityManager != null) {
				entityManager.getTransaction().rollback();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> listar(Class<T> classe) {

		return entityManager.createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
	}

	public void editar(T t) {

		try {
			entityManager.getTransaction().begin();
			entityManager.merge(t);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager != null) {
				entityManager.getTransaction().rollback();
			}
		}
	}

	public T pesquisaPorId(Class<T> classe, ID id) {
		try {
			entityManager.getTransaction().begin();
			return entityManager.find(classe, id);
		} catch (Exception e) {
			if (entityManager != null) {
				entityManager.getTransaction().rollback();
			}
			return null;
		}
	}
}