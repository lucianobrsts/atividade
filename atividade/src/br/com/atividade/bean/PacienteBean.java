package br.com.atividade.bean;

import java.util.List;

import br.com.atividade.dao.PacienteDAO;
import br.com.atividade.dao.PacienteDAOImpl;
import br.com.atividade.domain.Paciente;
import br.com.atividade.util.FacesUtil;

public class PacienteBean {

	private Paciente pacienteCadastro;
	private List<Paciente> listaPacientes;
	private List<Paciente> listaPacientesFiltrados;

	public void novo() {
		pacienteCadastro = new Paciente();
	}

	public void salvar() {
		try {
			PacienteDAO pacienteDAO = new PacienteDAOImpl();
			pacienteDAO.salvar(pacienteCadastro);

			pacienteCadastro = new Paciente();

			FacesUtil.adicionarMensagemInfo("Paciente salvo com sucesso.");
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar salvar um paciente: " + e.getMessage());
		}

	}

	public void carregarPesquisa() {
		try {
			PacienteDAO pacienteDAO = new PacienteDAOImpl();
			listaPacientes = pacienteDAO.listar(Paciente.class);
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os Pacientes: " + ex.getMessage());
		}
	}

	public Paciente getPacienteCadastro() {
		if (pacienteCadastro == null) {
			pacienteCadastro = new Paciente();
		}
		return pacienteCadastro;
	}

	public void setPacienteCadastro(Paciente pacienteCadastro) {
		this.pacienteCadastro = pacienteCadastro;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public List<Paciente> getListaPacientesFiltrados() {
		return listaPacientesFiltrados;
	}

	public void setListaPacientesFiltrados(List<Paciente> listaPacientesFiltrados) {
		this.listaPacientesFiltrados = listaPacientesFiltrados;
	}

}
