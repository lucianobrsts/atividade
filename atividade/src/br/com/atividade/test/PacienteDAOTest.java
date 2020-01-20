package br.com.atividade.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.atividade.dao.PacienteDAO;
import br.com.atividade.dao.PacienteDAOImpl;
import br.com.atividade.domain.Paciente;

public class PacienteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Paciente paciente = new Paciente();
		paciente.setNome("Teste");
		paciente.setIdade(15);

		PacienteDAO pacienteDAO = new PacienteDAOImpl();
		pacienteDAO.salvar(paciente);
	}

	@Test
	@Ignore
	public void excluir() {
		PacienteDAO pacienteDAO = new PacienteDAOImpl();
		Paciente pacienteBuscado = pacienteDAO.pesquisaPorId(Paciente.class, 11L);

		pacienteDAO.excluir(pacienteBuscado);
	}

	@Test
	@Ignore
	public void listar() {
		PacienteDAO pacienteDAO = new PacienteDAOImpl();
		pacienteDAO.listar(Paciente.class);

	}

	@Test
	@Ignore
	public void editar() {
		Paciente paciente = new Paciente();
		paciente.setId(1L);
		paciente.setNome("Luciano Brito dos Santos");
		paciente.setIdade(1000000);

		PacienteDAO pacienteDAO = new PacienteDAOImpl();
		pacienteDAO.editar(paciente);
	}

}
