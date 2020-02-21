package br.com.atividade.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.atividade.dao.ClinicaDAO;
import br.com.atividade.dao.ClinicaDAOImpl;
import br.com.atividade.domain.Clinica;
import br.com.atividade.util.FacesUtil;

public class ClinicaBean {

	private Clinica clinicaCadastro;
	private List<Clinica> listaClinicas;
	private List<Clinica> listaClinicasFiltradas;
	private List<SelectItem> selectItemsclinicas;
	private int codigoClinicaSelecionado;

	public List<SelectItem> getSelectItemsClinicas() {
		selectItemsclinicas = new ArrayList<SelectItem>();
		selectItemsclinicas.add(new SelectItem(1, "HAPVIDA"));
		selectItemsclinicas.add(new SelectItem(1, "CLÍNICA SIM"));
		selectItemsclinicas.add(new SelectItem(1, "UNIMED"));
		selectItemsclinicas.add(new SelectItem(1, "HORTOCLÍNICA"));
		selectItemsclinicas.add(new SelectItem(1, "PRONTOCÁRDIO"));
		return selectItemsclinicas;
	}

	public ClinicaBean() {
		carregarPesquisa();
	}

	public void novo() {
		clinicaCadastro = new Clinica();
	}

	public void salvar() {
		try {
			ClinicaDAO clinicaDAO = new ClinicaDAOImpl();
			clinicaDAO.salvar(clinicaCadastro);

			FacesUtil.adicionarMensagemInfo("Clinica salva com sucesso.");
		} catch (Exception e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar salvar um paciente.");
		}
	}

	public boolean fecharModalPanel() {

		if (clinicaCadastro.getDescricao() != null) {
			return true;
		} else {
			return false;
		}
	}

	public void carregarPesquisa() {
		try {
			ClinicaDAO clinicaDAO = new ClinicaDAOImpl();
			listaClinicas = clinicaDAO.listar(Clinica.class);
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar as clínicas." + ex.getMessage());
		}
	}

	public Clinica getClinicaCadastro() {
		if (clinicaCadastro == null) {
			clinicaCadastro = new Clinica();
		}
		return clinicaCadastro;
	}

	public void setClinicaCadastro(Clinica clinicaCadastro) {
		this.clinicaCadastro = clinicaCadastro;
	}

	public List<Clinica> getListaClinicas() {
		return listaClinicas;
	}

	public void setListaClinicas(List<Clinica> listaClinicas) {
		this.listaClinicas = listaClinicas;
	}

	public List<Clinica> getListaClinicasFiltradas() {
		return listaClinicasFiltradas;
	}

	public void setListaClinicasFiltradas(List<Clinica> listaClinicasFiltradas) {
		this.listaClinicasFiltradas = listaClinicasFiltradas;
	}

	public List<SelectItem> getSelectItemsclinicas() {
		return selectItemsclinicas;
	}

	public void setSelectItemsclinicas(List<SelectItem> selectItemsclinicas) {
		this.selectItemsclinicas = selectItemsclinicas;
	}

	public int getCodigoClinicaSelecionado() {
		return codigoClinicaSelecionado;
	}

	public void setCodigoClinicaSelecionado(int codigoClinicaSelecionado) {
		this.codigoClinicaSelecionado = codigoClinicaSelecionado;
	}
}
