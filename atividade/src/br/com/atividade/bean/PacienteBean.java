package br.com.atividade.bean;

import java.util.List;

import javax.annotation.ManagedBean;

import br.com.atividade.dao.PacienteDAO;
import br.com.atividade.dao.PacienteDAOImpl;
import br.com.atividade.domain.Paciente;
import br.com.atividade.util.FacesUtil;

@ManagedBean
public class PacienteBean {

	private Paciente pacienteCadastro;
	private List<Paciente> listaPacientes;
	private List<Paciente> listaPacientesFiltrados;

	public PacienteBean() {
		carregarPesquisa();
	}

	public void novo() {
		pacienteCadastro = new Paciente();
	}

	public void salvar() {
		try {
			PacienteDAO pacienteDAO = new PacienteDAOImpl();
			pacienteDAO.salvar(pacienteCadastro);

			FacesUtil.adicionarMensagemInfo("Paciente salvo com sucesso.");
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar salvar um paciente: " + e.getMessage());
		}
	}

	public boolean fecharModalPanel() {

		if (pacienteCadastro.getNome() != null) {
			return true;
		} else {
			return false;
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

	public void excluir() {
		try {
			PacienteDAO pacienteDAO = new PacienteDAOImpl();
			pacienteDAO.excluir(pacienteCadastro);

			FacesUtil.adicionarMensagemInfo("Paciente excluído com sucesso.");
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar excluir um paciente." + e.getMessage());
		}
	}

	public void editar() {
		try {
			PacienteDAO pacienteDAO = new PacienteDAOImpl();
			pacienteDAO.editar(pacienteCadastro);

			listaPacientes = pacienteDAO.listar(Paciente.class);
			FacesUtil.adicionarMensagemInfo("Paciente Editado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();

			FacesUtil.adiconarMensagemErro(e.getMessage());
		}
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
