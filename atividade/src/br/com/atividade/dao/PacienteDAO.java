package br.com.atividade.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.atividade.domain.Paciente;
import br.com.atividade.util.JPAResourceBean;

public class PacienteDAO {

	EntityManager entityManager = JPAResourceBean.getEntityManager();

	public void salvar(Paciente paciente) {

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(paciente);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			if (entityManager != null) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			entityManager.close();
		}
	}

	public void excluir(Paciente paciente) {

		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createNativeQuery("delete from paciente where id =" + paciente.getId());
			query.executeUpdate();
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			if (entityManager != null) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			entityManager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> listar() {
		List<Paciente> pacientes;

		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("select paciente from Paciente paciente");
			pacientes = query.getResultList();
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			entityManager.close();
		}

		return pacientes;
	}

	public void editar(Paciente paciente) {

		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("update Paciente set paciente where id =" + paciente.getId());
			query.executeUpdate();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager != null) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			entityManager.close();
		}
	}

}