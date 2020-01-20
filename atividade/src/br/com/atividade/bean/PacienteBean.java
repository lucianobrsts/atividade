package br.com.atividade.bean;

import br.com.atividade.dao.PacienteDAO;
import br.com.atividade.dao.PacienteDAOImpl;
import br.com.atividade.domain.Paciente;
import br.com.atividade.util.FacesUtil;

public class PacienteBean {

	private Paciente pacienteCadastro;

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

	public Paciente getPacienteCadastro() {
		if (pacienteCadastro == null) {
			pacienteCadastro = new Paciente();
		}
		return pacienteCadastro;
	}

	public void setPacienteCadastro(Paciente pacienteCadastro) {
		this.pacienteCadastro = pacienteCadastro;
	}

}
