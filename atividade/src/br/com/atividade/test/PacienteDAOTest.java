package br.com.atividade.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.atividade.dao.PacienteDAO;
import br.com.atividade.domain.Paciente;

public class PacienteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Paciente paciente = new Paciente();
		paciente.setNome("Maria José");
		paciente.setIdade(18);

		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.salvar(paciente);
	}

	@Test
	@Ignore
	public void excluir() {
		Paciente paciente = new Paciente();
		paciente.setId(9L);

		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.excluir(paciente);
	}

	@Test
	@Ignore
	public void listar() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		List<Paciente> pacientes = pacienteDAO.listar();

		for (int i = 0; i < pacientes.size(); i++) {
			System.out.println("Id: " + pacientes.get(i).getId() + " - Nome: " + pacientes.get(i).getNome()
					+ " - Idade: " + pacientes.get(i).getIdade());
		}
	}
	
	@Test
	public void editar() {
		Paciente paciente = new Paciente();
		paciente.setId(1L);
		paciente.setNome("Luciano Brito dos Santos");
		
		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.editar(paciente);
	}

}
